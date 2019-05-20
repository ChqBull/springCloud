/*
package com.jk.controller;

import com.jk.bean.OrderBean;
import com.jk.service.OrderService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class poiController {
      @Autowired
     private OrderService service;
    @RequestMapping("userExcelDownloads")
    public void download(HttpServletResponse response) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Excel表单,参数为sheet的名字
        HSSFSheet sheet = workbook.createSheet("用户表");


        //创建表头
        setTitle(workbook, sheet);
        List<OrderBean> answers = service.getOrder();


        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        for (OrderBean answer:answers) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(answer.getId());
            row.createCell(1).setCellValue(answer.getDdid());
            row.createCell(2).setCellValue(answer.getQuhuoWay());
            row.createCell(3).setCellValue(answer.getZhifuWay());
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


    */
/***
     * 设置表头
     * @param workbook
     * @param sheet
     *//*

    private void setTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(0, 10*256);
        sheet.setColumnWidth(1, 20*256);
        sheet.setColumnWidth(2, 20*256);
        sheet.setColumnWidth(3, 100*256);


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
        cell.setCellValue("订单号");
        cell.setCellStyle(style);


        cell = row.createCell(2);
        cell.setCellValue("取货方式");
        cell.setCellStyle(style);


        cell = row.createCell(3);
        cell.setCellValue("付款方式");
        cell.setCellStyle(style);
    }
}
*/
