package com.jk.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.jk.ConstantConf;
import com.jk.bean.CompanyModel;
import com.jk.mapper.UserMapper;
import com.jk.bean.PhoneCount;
import com.jk.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    MongoTemplate mongoTemplate;

    /*判断手机号是否被注册*/
    @Override
    public HashMap<String, Object> findUserByPhone(String phoneNumber) {
        HashMap<String, Object> hash = new HashMap<>();
        //先判断 该手机是否注册
        UserBean user = userMapper.findUserByPhone(phoneNumber);
        if (user != null) {
            hash.put("code", 1);
            hash.put("msg", "该手机已注册");
        } else {
            hash.put("code", 0);
        }
        return hash;
    }

    /*短信验证码*/
    @Override
    public HashMap<String, Object> phoneTest(String phoneNumber) {

        Jedis redis = jedisPool.getResource();
        HashMap<String, Object> hash = new HashMap<>();
        Date date = new Date();

        //在mongodb根据手机号条查手机号是否在mongodb中
        List<PhoneCount> phoneNumber1 = mongoTemplate.find(new Query().addCriteria(Criteria.where("phoneNumber").is(phoneNumber)), PhoneCount.class);
        if(phoneNumber1.size()>0){
            hash.put("code", 1);
            hash.put("msg", "该手机号在黑名单,请联系管理员");
            return hash;
        }

        //判断是否今天三次上限
        SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
        String format = si.format(date);
        Long llen1 = redis.llen(phoneNumber + format);
        if (llen1 >= 3) {
            PhoneCount phoneCount = new PhoneCount();
            phoneCount.setId(UUID.randomUUID().toString());
            phoneCount.setPhoneNumber(phoneNumber);
            phoneCount.setStatus(1);//状态1 为黑名单
            /*手机号三次存入黑名单*/
            mongoTemplate.insert(phoneCount);
            hash.put("code", 1);
            hash.put("msg", "该手机号今天已经发送三次");
            return hash;
        }
        //判断是否1 分钟以内
        String s2 = redis.get(phoneNumber);
        if (!StringUtils.isEmpty(s2)) {
            hash.put("code", 1);
            hash.put("msg", "一分钟内不能重复获取，请稍后重试");
            return hash;
        }
        Integer randomNumber = (int) (Math.random() * 899999 + 100000);
        System.out.println(randomNumber);

       /*  HashMap<String, Object> params = new HashMap<>();
         *//*发送短信*//*
        params.put("accountSid",ConstantConf.ACCOUNTSID);
        params.put("to",phoneNumber);
        String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        params.put("timestamp",timestamp);
        String sig= Md5Util.getMd532(ConstantConf.ACCOUNTSID+ConstantConf.AUTH_TOKEN+timestamp);
        params.put("sig",sig);
        params.put("templateid",ConstantConf.TEMPLATEID);
        params.put("param",randomNumber);
        String string = HttpClientUtil.post(ConstantConf.SMS_URL,params);

        System.out.println(string);

        JSONObject parseObject = JSON.parseObject(string);
        String string2 = parseObject.getString("respCode");
        if(ConstantConf.SMS_SUCCESS.equals(string2)) {*/
        String s = randomNumber.toString();
        redis.set(phoneNumber, s);
        redis.expire(phoneNumber, 60);
        redis.lpush(phoneNumber + format, s);
        redis.expire(phoneNumber + format, 86400);
        hash.put("yzm", randomNumber);
        hash.put("code", 0);
        hash.put("msg", "短信发送成功，一分钟内有效");
        return hash;
      /* }else {
            hash.put("code", 1);
            hash.put("msg", "发送失败");
            return hash;
        }*/
    }

    //用户注册   1发货方,2物流公司
    @Override
    public HashMap<String, Object> saveUser(UserBean userBean,String phonecode) {
        Jedis redis = jedisPool.getResource();
        HashMap<String, Object> hash = new HashMap<>();
        if(userBean.getUsertype() == 1){
            //判断手机号是否注册
            UserBean user = userMapper.findUserByPhone(userBean.getPhoneNumber());
            if (user != null) {
                hash.put("code", 1);
                hash.put("msg", "该手机已注册");
                return hash;
            } else {
                hash.put("code", 0);
                hash.put("msg", "注册成功");
                //手机验证码
                String s = redis.get(userBean.getPhoneNumber());
                if (!s.equals(phonecode)) {
                    hash.put("code", 1);
                    hash.put("msg", "短信验证码错误");
                    return hash;
                }
                //判断用户选择的类型  1发货方 2物流
                Integer usertype = userBean.getUsertype();
                userBean.setCreateTime(new Date());
                userBean.setMoney(0.00);
           /* String md516 = Md5Util.getMd516(userBean.getPassword());//密码加密
            userBean.setPassword(md516);*/
                    userBean.setSex(1);
                    userMapper.saveOneUser(userBean);//注册发货方

                return hash;
            }
        }else{
            CompanyModel companyModel = userMapper.findCompanyByName(userBean.getCompanyName());
            if(companyModel != null){
                hash.put("code", 1);
                hash.put("msg", "该公司已注册");
                return hash;
            }else{
                CompanyModel companyModel2 = userMapper.findCompanyByPhone(userBean.getPhoneNumber());
                if(companyModel2 != null){
                    hash.put("code", 1);
                    hash.put("msg", "该电话号已注册");
                }
                userMapper.saveComUser(userBean);
                hash.put("code", 1);
                hash.put("msg", "注册成功");
                return hash;
            }
        }
    }

    // 前后台登录+记住密码     type1发货方,2物流公司
    @Override
    public UserBean login(UserBean userBean) {
        Jedis redis = jedisPool.getResource();
        HashMap<String, Object> hashMap= new HashMap<>();
        String uuid = UUID.randomUUID().toString();
        //判断用户名和密码是否正确
        String password = userBean.getPassword();
       /* String md516 = Md5Util.getMd516(password);
        userBean.setPassword(md516);*/
        UserBean userFromDb = userMapper.getUserByPasPhone(userBean);
        if(userFromDb !=null){
            String str = JSON.toJSONString(userFromDb);
            redis.set(ConstantConf.COOKIEUUID+uuid,str);
            redis.expire(ConstantConf.COOKIEUUID+uuid,604800);
        }
        return userFromDb;
    }

    @Override
    public CompanyModel comlogin(UserBean userBean) {
        CompanyModel companyModel =  userMapper.comlogin(userBean);
        return companyModel;
    }


    /*手机登录*/
    @Override
    public HashMap<String, Object> phoneLogin(UserBean userBean, String phonecode) {
        Jedis redis = jedisPool.getResource();
        HashMap<String, Object> hashMap = new HashMap<>();

        UserBean user2 = userMapper.findUserByPhone(userBean.getPhoneNumber());
        if(user2 == null){
            hashMap.put("code",1);
            hashMap.put("msg","该手机号未注册，请先注册");
            return hashMap;
        }
        String s = redis.get(userBean.getPhoneNumber());
        if(!s.equals(phonecode)){
            hashMap.put("code", 1);
            hashMap.put("msg", "短信验证码错误");
            return hashMap;
        }
        hashMap.put("code",0);
        hashMap.put("msg","登录成功");
        return hashMap;
    }
}