package com.jk.Controller;

import com.jk.bean.LogLogin;
import com.jk.bean.PhoneCount;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Controller
public class BlackController {

    @Autowired
    MongoTemplate mongoTemplate;


    //日志删除
    @RequestMapping("delLog")
    public  String delLog(String id){
        mongoTemplate.remove(new Query().addCriteria(Criteria.where("id").in(id)), LogLogin.class, "logLogin");
        return "logShow";
    }


    //日志查询
    @RequestMapping("findLog")
    @ResponseBody
    public HashMap<String, Object> findLog(Integer page, Integer limit, LogLogin logLogin) {

        Criteria criteriax=new Criteria();

           if(StringUtils.isNotEmpty(logLogin.getUsername())){
                //  返回  java 正则      ‘^.*.* $’
                Pattern xx = Pattern.compile("^.*"+logLogin.getUsername()+".*$", Pattern.CASE_INSENSITIVE);
                criteriax.and("username").regex(xx);
            }

        Query query = new Query();
     query.addCriteria(criteriax);
        long count = mongoTemplate.count(query, "logLogin");
        List<LogLogin> find = mongoTemplate.find(query.skip((page-1)*limit).limit(limit), LogLogin.class, "logLogin");
        HashMap<String,Object> hashMap = new HashMap<>();

        hashMap.put("code",0);
        hashMap.put("msg","");

        hashMap.put("data", find);
        hashMap.put("count",find.size());

        return hashMap;
    }


    //跳日志查询
    @RequestMapping("toLogShow")
    public String toLogShow(){
        return "logShow";
    }


   //黑名单查询
    @RequestMapping("toblack")
    public  String toblack()
    {
        return "blackShow";
    }



    //日志导出
    @RequestMapping("logExcelDownloads")
    public void download2(HttpServletResponse response) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Excel表单,参数为sheet的名字
        HSSFSheet sheet = workbook.createSheet("日志记录");

        //创建表头
        setTitle(workbook, sheet);
        List<LogLogin> answers = mongoTemplate.find(new Query(),LogLogin.class,"logLogin");

        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        for (LogLogin answer:answers) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(answer.getId());
            row.createCell(1).setCellValue(answer.getUsername());
            row.createCell(2).setCellValue(answer.getOperation());
            row.createCell(3).setCellValue(answer.getMethod());
            row.createCell(4).setCellValue(answer.getParams());
            row.createCell(5).setCellValue(answer.getIp());
            row.createCell(6).setCellValue(answer.getCreateDate());
            rowNum++;
        }
        String fileName = "survey-answer.xls";
        //清空response

        response.reset();
        //设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename="+ fileName);
        OutputStream os = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/vnd.ms-excel;charset=gb2312");
        //将excel写入到输出流中
        workbook.write(os);
        os.flush();
        os.close();
    }

    /***
     * 设置表头
     * @param workbook
     * @param sheet
     */
    private void setTitle2(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(0, 10*256);
        sheet.setColumnWidth(1, 20*256);
        sheet.setColumnWidth(2, 20*256);
        sheet.setColumnWidth(3, 100*256);
        sheet.setColumnWidth(4, 100*256);
        sheet.setColumnWidth(5, 100*256);
        sheet.setColumnWidth(6, 100*256);
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("id");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("用户名");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("操作");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("方法名");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("参数");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("ip");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("时间");
        cell.setCellStyle(style);
    }






    //黑名单导出
    @RequestMapping("BlackExcelDownloads")
    public void download(HttpServletResponse response) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Excel表单,参数为sheet的名字
        HSSFSheet sheet = workbook.createSheet("用户表");

        //创建表头
        setTitle(workbook, sheet);
        List<PhoneCount> answers = mongoTemplate.find(new Query(),PhoneCount.class,"phoneCount");

        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        for (PhoneCount answer:answers) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(answer.getId());
            row.createCell(1).setCellValue(answer.getPhoneNumber());
            row.createCell(2).setCellValue(answer.getStatus());
            row.createCell(3).setCellValue(answer.getYcCause());
            row.createCell(4).setCellValue(answer.getBlackDate());

            rowNum++;
        }
        String fileName = "survey-answer.xls";
        //清空response

        response.reset();
        //设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename="+ fileName);
        OutputStream os = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/vnd.ms-excel;charset=gb2312");
        //将excel写入到输出流中
        workbook.write(os);
        os.flush();
        os.close();
    }

    /***
     * 设置表头
     * @param workbook
     * @param sheet
     */
    private void setTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(0, 10*256);
        sheet.setColumnWidth(1, 20*256);
        sheet.setColumnWidth(2, 20*256);
        sheet.setColumnWidth(3, 100*256);
        sheet.setColumnWidth(4, 100*256);
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("id");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("黑名单手机号");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("时间");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("异常原因");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("状态");
        cell.setCellStyle(style);
    }



    //黑名单新增
   @RequestMapping("addBlack")
    public String saveMongo(PhoneCount phoneCount) {
       if (phoneCount.getYcCause()==""){
           phoneCount.setYcCause("无");
       }
       phoneCount.setId(UUID.randomUUID().toString());
       phoneCount.setBlackDate(new Date());
        mongoTemplate.insert(phoneCount);
        return "blackShow";
    }



    //新增弹框
    @RequestMapping("toBlackDialog")
    public String toBlackDialog(){
        return "blackDialog";
    }


    //黑名单解禁
    @RequestMapping("delBlack")

    public  String delBlack(String id){
        mongoTemplate.remove(new Query().addCriteria(Criteria.where("id").in(id)), PhoneCount.class, "phoneCount");
        return "blackShow";
    }


    //黑名单查询
    @RequestMapping("findbalck")
    @ResponseBody
    public HashMap<String, Object> findProject(Integer page, Integer limit, PhoneCount phoneCount) {
                 /* PhoneCount cc =  new PhoneCount();
             cc.setId(UUID.randomUUID().toString());
            cc.setBlackDate(new Date());
            cc.setStatus(1);
            cc.setPhoneNumber("415122");
            cc.setYcCause("被举报");
               mongoTemplate.save(cc);*/

        long count = mongoTemplate.count(new Query(), "phoneCount");
        List<PhoneCount> find = mongoTemplate.find(new Query().skip((page-1)*limit).limit(limit), PhoneCount.class, "phoneCount");
        HashMap<String,Object> hashMap = new HashMap<>();

        hashMap.put("code",0);
        hashMap.put("msg","");


        hashMap.put("data", find);
        hashMap.put("count",find.size());

        return hashMap;
    }




}
