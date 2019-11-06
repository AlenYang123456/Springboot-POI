package net.general.aggregation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.general.aggregation.domain.User;
import net.general.aggregation.service.IUserService;
import net.general.aggregation.utils.ExcelUtil;
import net.general.aggregation.vo.request.ErrorUploadReq;
import net.general.aggregation.vo.request.UploadReq;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dreamer Q
 * @Date: 2019/10/24 17:24
 * @Version 1.0
 * @Discription Excel导入接口
 */
@RequestMapping("/api/v1/")
@RestController
@Api(tags = "Excel 导入导出接口")
public class ExcelController {

    @Autowired
    private IUserService userService;
    @ApiOperation(value = "测试swagger")
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
//    @Deprecated
//    @RequestMapping("/upload1")
//    public Object upload(@RequestBody ErrorUploadReq request) throws IOException {
//        MultipartFile file=request.getFile();
//        int rowNum = 0;//已取值的行数
//        int colNum = 0;//列号
//        int realRowCount = 0;//真正有数据的行数
//
//        //得到工作空间
//        Workbook workbook = null;
//        try {
//            workbook = ExcelUtil.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //得到工作表
//        Sheet sheet = ExcelUtil.getSheetByWorkbook(workbook, 0);
//        if (sheet.getRow(2000) != null){
//            throw new RuntimeException("系统已限制单批次导入必须小于或等于2000笔！");
//        }
//
//        realRowCount = sheet.getPhysicalNumberOfRows();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        List<User> list = new ArrayList<>();
//        User user = null;
//
//        for(Row row:sheet) {
//            if(realRowCount == rowNum) {
//                break;
//            }
//            if(ExcelUtil.isBlankRow(row)) {//空行跳过
//                continue;
//            }
//            if(row.getRowNum() == -1) {
//                continue;
//            }else {
//                if(row.getRowNum() == 0) {//第一行表头跳过
//                    continue;
//                }
//            }
//            rowNum ++;
//            colNum = 1;
//            user = new User();
//            ExcelUtil.validCellValue(sheet, row, colNum, "id");
//            user.setId(Integer.valueOf(ExcelUtil.getCellValue(sheet, row, colNum - 1)));
//            ExcelUtil.validCellValue(sheet, row, ++ colNum, "name");
//            list.add(user);
//        }
//        return list;
//    }

    /**
     * Excel文件上传正确的方式
     * @param req
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public void upload1(@RequestBody @Validated UploadReq req, HttpServletRequest request) throws Exception {
//        MultipartFile file = (MultipartFile) request.getAttribute("file");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        MultipartFile file = multipartRequest.getFile("file");
//        MultipartFile file =req.getFile();
        //从数据库查询出现有的数据,根据去重的字段分组去构建成一个HashMap,通过containsKey()判断
        //将需要更新的数据放到updateList中
        List<User> updateList=new ArrayList<>();

        //已取值的行数
        int rowNum = 0;
        //列号
        int colNum = 0;
        //真正有数据的行数
        int realRowCount = 0;
        //得到工作空间
        Workbook workbook = null;

        try {
            workbook = ExcelUtil.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到工作表
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = ExcelUtil.getSheetByWorkbook(workbook, i);

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
                //空行跳过
                if(ExcelUtil.isBlankRow(row)) {
                    continue;
                }
                if(row.getRowNum() == -1) {
                    continue;
                }else {
                    //第一行表头跳过
                    if(row.getRowNum() == 0) {
                        continue;
                    }
                }
                rowNum ++;
                colNum = 1;
                user = new User();
                ExcelUtil.validCellValue(sheet, row, colNum, "id");
                user.setId(Integer.valueOf(ExcelUtil.getCellValue(sheet, row, colNum - 1)));
                ExcelUtil.validCellValue(sheet, row, ++ colNum, "name");
                user.setId(Integer.valueOf(ExcelUtil.getCellValue(sheet, row, colNum - 1)));
                //判断是否是已存在的数据,如果是就更新,不是就新增
                //updateList.add(user);
                list.add(user);

            }

            //新增的逻辑
            userService.saveBatch(list);
            System.out.println(list);
        }
    }

}
