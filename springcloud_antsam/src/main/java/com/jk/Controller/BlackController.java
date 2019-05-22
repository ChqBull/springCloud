package com.jk.Controller;

import com.jk.bean.PhoneCount;
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

@Controller
public class BlackController {

    @Autowired
    MongoTemplate mongoTemplate;


    @RequestMapping("UserExcelDownloads")
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




    @RequestMapping("toblack")
    public  String toblack()
    {
        return "blackShow";
    }
}
