package com.suny.association.utils;

import com.suny.association.enums.BaseEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.pojo.po.Member;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Comments:   对Excel的相关操作工具类
 * Author:   孙建荣
 * Create Date: 2017/05/15 18:09
 */
public class ExcelUtils {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLXS = "xlxs";

    public static Workbook matchExcelVersion(File file) {
       /* String fileType = multipartFile.getContentType();
        *//*  获取上传文件名 *//*
        String fileName = ((CommonsMultipartFile) multipartFile).getFileItem().getName();
        *//* 获取上传文件名的文件后缀名    *//*
        String fileExtension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);*/
       /* *//* 获取文件名的后缀名，检查是否存在欺骗   *//*
        if (!compareFileType(fileType, fileExtension)) {
            logger.warn("上传的文件貌似有点小问题，可能是后缀名欺骗");
        }*/
        return null;

    }

    public static List<List<Member>> readExcel(File file, int startSheet, int startRow) {
        String fileExtension = null;
        List<List<Member>> memberList = new LinkedList<>();
        Workbook workbook = null;
        workbook = getWorkbook(file, fileExtension);
        Sheet sheet = workbook.getSheetAt(startSheet);
        Object value = null;
        Row row = null;
        Cell cell = null;

        return null;
    }

    /**
     * 根据上传的Excel版本返回不同的解析Excel表格的方法
     *
     * @param file          上传的Excel文件
     * @param fileExtension 上传的文件的扩展名
     * @return 根据不同的文件扩展名返回不同的工具方法
     */
    public static Workbook getWorkbook(File file, String fileExtension) {
        try {
            FileInputStream fs = new FileInputStream(file);
            switch (fileExtension) {
                case "xls":
                    try {
                        return new HSSFWorkbook(fs);
                    } catch (IOException e) {
                        logger.warn("读取的文件格式不支持");
                        throw new BusinessException(BaseEnum.FILE_READ_FAIL);
                    }
                case "xlsx":
                    try {
                        return new XSSFWorkbook(fs);
                    } catch (IOException e) {
                        logger.warn("读取的文件格式不支持");
                        throw new BusinessException(BaseEnum.FILE_READ_FAIL);
                    }
                default:
                    logger.warn("读取的文件格式不支持");
                    throw new BusinessException(BaseEnum.FILE_NOT_SUPPORT);
            }
        } catch (FileNotFoundException e) {
            logger.error("不存在这个文件，无法进行读取");
            throw new BusinessException(BaseEnum.FILE_NOT_EXIST);
        }
    }


    /**
     * 比较上传的Excel文件的文件类型是否是Excel表格，防止客户端欺骗
     *
     * @param fileType 上传文件的文件类型
     * @return 如果是Excel表格则返回true，否则就返回false
     */
    public static boolean compareFileType(String fileType, String fileExtension) {
        if (fileType.equals("application/vnd.ms-excel") && fileExtension.equals("xls")) {
            logger.info("Windows 2003版以前的EXCEL表格");
            return true;
        } else if (fileType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") && fileExtension.equals("xlsx")) {
            logger.info("Windows 2007版后的Excel表格");
            return true;
        }
        logger.warn("未知的文件扩展名");
        return false;
    }


}
