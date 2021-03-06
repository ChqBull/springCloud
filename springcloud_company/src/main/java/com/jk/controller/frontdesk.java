package com.jk.controller;


import com.jk.bean.*;
import com.jk.service.FrontdeskService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

@Controller
public class frontdesk {
    @Autowired
    private FrontdeskService frontdeskService;

    @RequestMapping("aa")
    public String aa(){
        return "pop";
    }

    @RequestMapping("ee")
    public String ee(){
        return "linemanager";
    }

    @RequestMapping("ff")
    public String ff(){
        return "editLine";
    }
    @RequestMapping("gg")
    public String gg(){
        return "addedService";
    }

    @RequestMapping("lineSearch")
    @ResponseBody
    public HashMap<String,Object> lineSearch(Integer page, Integer limit, Wuliuxianlu wuliuxianlu,HttpServletRequest request){

        return frontdeskService.lineSearch(page,limit,wuliuxianlu,request);


    }


    @RequestMapping("editLine")
    public String editLine(Model model,String id){
        Wuliuxianlu wuliuxianlu = frontdeskService.editLine(id);
        model.addAttribute("order",wuliuxianlu);
        return "editLine";
    }
    @RequestMapping("listData")
    @ResponseBody
    public List listData (){
        List list = frontdeskService.listData();
        return  list;
    }
    @RequestMapping("add")
    @ResponseBody
    public String add(Wuliuxianlu  wuliuxianlu){
        frontdeskService.add(wuliuxianlu);
        return "linemanager";
    }
    @RequestMapping("deleteData")
    public String deleteData(int id){
        frontdeskService.deleteData(id);
        return "linemanager";

    }


    @RequestMapping("UserExcelDownloads")
    public void download(HttpServletResponse response) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Excel表单,参数为sheet的名字
        HSSFSheet sheet = workbook.createSheet("线路表");

        //创建表头
        setTitle(workbook, sheet);
        List<Wuliuxianlu> answers = frontdeskService.findAll();

        //新增数据行，并且设置单元格数据
        int rowNum = 1;


        for (Wuliuxianlu answer:answers) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(answer.getXlId());
            row.createCell(1).setCellValue(answer.getStartplace());
            row.createCell(2).setCellValue(answer.getEndplace());
            row.createCell(4).setCellValue(answer.getZhongHuoJiqGe());
            row.createCell(5).setCellValue(answer.getQingHuoJiaGe());
            row.createCell(6).setCellValue(answer.getZuiDiYiPiao());
            row.createCell(8).setCellValue(answer.getShangMenTiHuo());
            row.createCell(9).setCellValue(answer.getSubstatus());
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
        sheet.setColumnWidth(1, 10*256);
        sheet.setColumnWidth(2, 10*256);
        sheet.setColumnWidth(4, 10*256);
        sheet.setColumnWidth(5, 10*256);
        sheet.setColumnWidth(6, 10*256);
        sheet.setColumnWidth(7, 10*256);
        sheet.setColumnWidth(8, 10*256);
        sheet.setColumnWidth(9, 10*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("始发地");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("目的地");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("运输时效");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("重货价格");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("轻货价格");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("最低一票价格");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue("上门提货");
        cell.setCellStyle(style);

        cell = row.createCell(9);
        cell.setCellValue("送货上门");
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellValue("发布状态");
        cell.setCellStyle(style);
    }
    @RequestMapping("queryTwo")
    @ResponseBody
    public Wuliuxianlu queryOne(Integer id){
        Wuliuxianlu wuliuxianlu= frontdeskService.queryOne(id);
        return wuliuxianlu;
    }

    @RequestMapping("address")
    @ResponseBody
    public String address(Integer area1,Integer area2){
        String aa = frontdeskService.address(area1,area2);
        return aa;
    }
    @RequestMapping("addLine")
    @ResponseBody
    public String addLine(Wuliuxianlu wuliuxianlu, HttpServletRequest request){
        String aa = frontdeskService.addLine(wuliuxianlu,request);
        return aa;
    }

}
