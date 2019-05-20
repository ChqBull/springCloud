package com.jk.controller;

import com.jk.bean.BankCards;
import com.jk.bean.CashModel;
import com.jk.bean.FinanciaModel;
import com.jk.service.FinancialService;
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
public class FinancialController {
    @Autowired
    FinancialService financialService;

    //获取财务报表
    @RequestMapping("getFinancialStatement")
    @ResponseBody
    public HashMap<String, Object> getFinancialStatement(HttpServletRequest request, FinanciaModel financiaModel,Integer page ,Integer limit){
        String id = request.getSession().getId();
        HashMap<String, Object> map = financialService.getFinancialStatement(id,financiaModel,page,limit);
        return map;
    }
    /*获取提现记录*/
    @RequestMapping("getWithdrawalRecords")
    @ResponseBody
    public HashMap<String, Object> getWithdrawalRecords(HttpServletRequest request, CashModel cashModel, Integer page , Integer limit ){
        String id = request.getSession().getId();
        HashMap<String, Object> map = financialService.getWithdrawalRecords(id,cashModel,page,limit);
        return map;
    }
    /*获取提现记录Echars*/
    @RequestMapping("getWithdrawalRecordsEchars")
    @ResponseBody
    public HashMap<String , Object>  getWithdrawalRecordsEchars(HttpServletRequest request,CashModel cashModel){
        String id = request.getSession().getId();
        HashMap<String , Object>  map = financialService.getWithdrawalRecordsEchars(id,cashModel);
        return map;
    }
    /*跳转提现界面*/
    @RequestMapping("goCash")
    public String goCash(HttpServletRequest request, Model model){
        String id = request.getSession().getId();
        CashModel cashModel = financialService.goCash(id);
        model.addAttribute("f",cashModel);
        return "Home";
    }
    /*查询银行卡*/
    @RequestMapping("getInquireAboutBankCards")
    @ResponseBody
    public List<BankCards> getInquireAboutBankCards(HttpServletRequest request){
        String id = request.getSession().getId();
        return financialService.getInquireAboutBankCards(id);
    }
    /*提交提现*/
    @RequestMapping("addCash")
    @ResponseBody
    public String addCash(HttpServletRequest request,CashModel cashModel){
        String id = request.getSession().getId();
        String msg = financialService.addCash(cashModel,id);
        return msg;
    }
    /*获取财务报表Echars*/
    @RequestMapping("getWithdrawal")
    @ResponseBody
    public HashMap<String , Object>  getWithdrawalEchars(HttpServletRequest request){
        String id = request.getSession().getId();
        HashMap<String , Object>  map = financialService.getWithdrawalEchars(id);
        return map;
    }
    /*导出余额提现表*/
    @RequestMapping("ExcelDownloadsPoi")
    public void download(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String id = request.getSession().getId();

        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Excel表单,参数为sheet的名字
        HSSFSheet sheet = workbook.createSheet("用户表");

        //创建表头
        setTitle(workbook, sheet);
        List<CashModel> li = financialService.getWithdrawalRecordsIop(id);

        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        for (CashModel cashModel:li) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(cashModel.getCId());
            row.createCell(1).setCellValue(cashModel.getApplicationDate());
            row.createCell(2).setCellValue(cashModel.getAmount());
            row.createCell(3).setCellValue(cashModel.getBankCards());
            if(cashModel.getAuditStatus() == 1){
                row.createCell(4).setCellValue("待审核");
            }else{
                row.createCell(4).setCellValue("已审核");
            }
            rowNum++;
        }
        String fileName = "WithdrawalRecords.xls";
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
        cell.setCellValue("提现日期");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("提现金额");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("提现银行卡");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("审核状态");
        cell.setCellStyle(style);
    }
    /*导出余额提现表*/
    @RequestMapping("fianExcelDownloadsPoi")
    public void downloadFian(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String id = request.getSession().getId();

        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Excel表单,参数为sheet的名字
        HSSFSheet sheet = workbook.createSheet("用户表");

        //创建表头
        setfinaTitle(workbook, sheet);
        List<FinanciaModel> li = financialService.getWithdrawalRecordsFinaIop(id);

        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        for (FinanciaModel financiaModel:li) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(financiaModel.getFId());
            row.createCell(1).setCellValue(financiaModel.getTradingNumber());
            row.createCell(2).setCellValue(financiaModel.getTradingDate());
            row.createCell(3).setCellValue(financiaModel.getTransactionAmount());
            row.createCell(4).setCellValue(financiaModel.getTransactionType());
            if(financiaModel.getBudgetType() == 1){
                row.createCell(5).setCellValue("支出");
            }else{
                row.createCell(5).setCellValue("收入");
            }
            row.createCell(6).setCellValue(financiaModel.getNote());
            rowNum++;
        }
        String fileName = "FinancialStatements.xls";
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
    private void setfinaTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("交易号");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("交易日期");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("交易金额");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("交易类型");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("收支类型");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("备注");
        cell.setCellStyle(style);
    }

}
