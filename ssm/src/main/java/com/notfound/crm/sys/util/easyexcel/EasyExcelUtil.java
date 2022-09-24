package com.notfound.crm.sys.util.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.notfound.crm.common.base.CodeMsg;
import com.notfound.crm.common.base.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Description:    easyexcel工具类
 */
@Component
public class EasyExcelUtil<T> {

    /**
     * 导入excel
     * @param multipartFile 上传excel文件
     * @param object        上传的excel文件需要封装到哪个实体类
     * @param analysisEventListener 文件数据写入监听类
     * @return
     */
    public Result importExcel(MultipartFile multipartFile, Class<T> object, AnalysisEventListener<T> analysisEventListener){
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();

            //封装excel工作簿对象
            ExcelReaderBuilder read = EasyExcel.read(inputStream, object, analysisEventListener);
            //封装工作表
            ExcelReaderSheetBuilder sheet = read.sheet();
            //读取数据
            sheet.doRead();

            return new Result();
        } catch (IOException e) {
            System.out.println("上传的文件有问题！");
            e.printStackTrace();
            return new Result(CodeMsg.ERROR);
        }
    }

    /**
     * 导出excel
     * @param response   工
     * @param name      导出文件名称
     * @param object    需要封装到的实体类字节码文件
     * @param listdata  导出数据
     * @return          返回操作码和操作信息
     */
    public void exportExcel(HttpServletResponse response, String name, Class<T> object, List<Object> listdata){

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        ServletOutputStream outputStream = null;
        try {
            // 防止中文乱码
            String fileName = URLEncoder.encode(name, "UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + fileName + ".xlsx");

            outputStream = response.getOutputStream();
        //创建工作簿
        ExcelWriterBuilder workbook = EasyExcel.write(outputStream, object);
        //创建工作表
        ExcelWriterSheetBuilder sheet = workbook.sheet("员工个人信息表");
        //写入数据
        sheet.doWrite(listdata);
        //向前端发送操作数据
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
