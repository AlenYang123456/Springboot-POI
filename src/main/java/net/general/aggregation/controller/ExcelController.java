package net.general.aggregation.controller;

import net.general.aggregation.domain.User;
import net.general.aggregation.utils.ExcelUtil;
import net.general.aggregation.vo.request.ErrorUploadReq;
import net.general.aggregation.vo.request.UploadReq;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 杨强
 * @Date: 2019/10/24 17:24
 * @Version 1.0
 * @Discription Excel导入接口
 */
@RequestMapping("/api/v1/")
@RestController
public class ExcelController {


    @RequestMapping("/user")
    public String testUser() {
        return "success user~";
    }

    /**
     * 文件上传错误的方式,会报错415,错误的媒介类型
     * @param request
     * @return
     * @throws IOException
     */
    @Deprecated
    @RequestMapping("/upload1")
    public Object upload(@RequestBody ErrorUploadReq request) throws IOException {
        MultipartFile file=request.getFile();
        int rowNum = 0;//已取值的行数
        int colNum = 0;//列号
        int realRowCount = 0;//真正有数据的行数

        //得到工作空间
        Workbook workbook = null;
        try {
            workbook = ExcelUtil.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到工作表
        Sheet sheet = ExcelUtil.getSheetByWorkbook(workbook, 0);
        if (sheet.getRow(2000) != null){
            throw new RuntimeException("系统已限制单批次导入必须小于或等于2000笔！");
        }

        realRowCount = sheet.getPhysicalNumberOfRows();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<User> list = new ArrayList<>();
        User user = null;

        for(Row row:sheet) {
            if(realRowCount == rowNum) {
                break;
            }
            if(ExcelUtil.isBlankRow(row)) {//空行跳过
                continue;
            }
            if(row.getRowNum() == -1) {
                continue;
            }else {
                if(row.getRowNum() == 0) {//第一行表头跳过
                    continue;
                }
            }
            rowNum ++;
            colNum = 1;
            user = new User();
            ExcelUtil.validCellValue(sheet, row, colNum, "id");
            user.setId(Integer.valueOf(ExcelUtil.getCellValue(sheet, row, colNum - 1)));
            ExcelUtil.validCellValue(sheet, row, ++ colNum, "name");
            list.add(user);
        }
        return list;
    }

    /**
     * Excel文件上传正确的方式
     * @param file
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public Object upload1(MultipartFile file, @Validated UploadReq req) throws IOException {
        System.out.println(req);
        int rowNum = 0;//已取值的行数
        int colNum = 0;//列号
        int realRowCount = 0;//真正有数据的行数

        //得到工作空间
        Workbook workbook = null;
        try {
            workbook = ExcelUtil.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到工作表
        Sheet sheet = ExcelUtil.getSheetByWorkbook(workbook, 0);
        if (sheet.getRow(2000) != null){
            throw new RuntimeException("系统已限制单批次导入必须小于或等于2000笔！");
        }

        realRowCount = sheet.getPhysicalNumberOfRows();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<User> list = new ArrayList<>();
        User user = null;

        for(Row row:sheet) {
            if(realRowCount == rowNum) {
                break;
            }
            if(ExcelUtil.isBlankRow(row)) {//空行跳过
                continue;
            }
            if(row.getRowNum() == -1) {
                continue;
            }else {
                if(row.getRowNum() == 0) {//第一行表头跳过
                    continue;
                }
            }
            rowNum ++;
            colNum = 1;
            user = new User();
            ExcelUtil.validCellValue(sheet, row, colNum, "id");
            user.setId(Integer.valueOf(ExcelUtil.getCellValue(sheet, row, colNum - 1)));
            ExcelUtil.validCellValue(sheet, row, ++ colNum, "name");
            list.add(user);
        }
        return list;
    }



}
