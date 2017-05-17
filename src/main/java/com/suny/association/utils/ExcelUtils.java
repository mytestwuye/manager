package com.suny.association.utils;

import com.suny.association.enums.BaseEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Department;
import com.suny.association.pojo.po.Member;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Comments:   对Excel的相关操作工具类
 * Author:   孙建荣
 * Create Date: 2017/05/15 18:09
 */
public class ExcelUtils {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLXS = "xlxs";


    public static AtomicReference<Map<Object, Object>> readExcel(File file, String fileExtension, int startSheet, int startRow) {
        AtomicReference<Map<Object, Object>> memberAndAccountMap = new AtomicReference<>(new HashMap<>());
        List<Member> memberList = new LinkedList<>();
        List<Account> accountList = new LinkedList<>();
        Workbook workbook;
        workbook = getWorkbook(file, fileExtension);          /*   首选获取一个工作簿   */
        if (isOverFlowSheet(workbook, startRow)) {
            logger.error("读取Excel表格时读取的工作表下标溢出，不存在这个工作表");
            throw new BusinessException(BaseEnum.SHEET_NUM_OVERFLOW);
        }
        Sheet sheet = workbook.getSheetAt(startSheet);       /*   这里传入一个起始工作表的序号，读取这个工作表      */
        Row row = null;             /*  Excel的每一行数据  */
        Cell cell = null;         /*  Excel一行数据中的每一个单元格的数据  */
        CellStyle cellStyle = null;    /*     表格的样式         */
        Department department = new Department();
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {      /*  遍历单元表的每一行的数据    */
            row = sheet.getRow(i);
            if (row.getRowNum() >= startRow) {
                Member member = new Member();
                Account account = new Account();
                /*  创建一个List来存放读取的每一行数据     */
                member.setMemberName((String) getCellValue(row.getCell(0)));
                member.setMemberClassName((String) getCellValue(row.getCell(1)));
                member.setMemberSex((Boolean) getCellValue(row.getCell(2)));
                member.setMemberGradeNumber((Integer) getCellValue(row.getCell(4)));
                department.setDepartmentId(convertDepartId((String) getCellValue(row.getCell(5))));
                member.setMemberDepartment(department);
                /*   因为要自动产生一个账号，所以默认拉取电话号码作为登录账号   */
                Long phoneNumber = (Long) getCellValue(row.getCell(3));
                String accountName = String.valueOf(getCellValue(row.getCell(3)));
                account.setAccountPhone(phoneNumber);
                account.setAccountName(accountName);
                logger.info(account.toString());
                logger.info(member.toString());
                memberList.add(member);
                accountList.add(account);
            } else {
                logger.warn("开始读取的这一列不存在数据，不存在这行");
                throw new BusinessException(BaseEnum.SHEET_NUM_OVERFLOW);
            }
        }
        memberAndAccountMap.get().put("memberList", memberList);
        memberAndAccountMap.get().put("accountList", accountList);
        return memberAndAccountMap;
    }

    /**
     * 通过部门的名字转换成部门ID，暂时先固定代码
     *
     * @param departName 部门的名字
     * @return 部门对应的ID
     */
    private static Integer convertDepartId(String departName) {
        switch (departName) {
            case "办公室":
                return 1;
            case "组织部":
                return 3;
            case "宣传部":
                return 4;
            case "策划部":
                return 5;
            case "团支部":
                return 6;
            default:
                return 0;
        }
    }


    /**
     * 检查传入的开始读取的工作表下表是否大于文件中存在的工作表数量,防止下标溢出.
     * <b>startSheet</b>是一个读取工作表的下标位置，请注意是从<b>0</b>开始的，
     * <b>workbook.getNumberOfSheets()</b>得到的是工作表的数量，是从<b>1</b>
     * 开始的，所以在判断时应该判断大于或者等于
     *
     * @param workbook   读取出来的工作簿
     * @param startSheet 开始读取的工作表下标，开始读取时从第0个开始读取的
     * @return 如果越界就说明不可行，返回false，如果没有超出就返回true
     */
    private static boolean isOverFlowSheet(Workbook workbook, int startSheet) {
        return startSheet >= workbook.getNumberOfSheets();
    }


    /**
     * 根据传进来的cell判断是什么类型的值，然后返回什么类型的值
     *
     * @param cell 代表一个小单元格
     * @return 根据类型判断出来的值
     */
    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                if (isSexText(cell)) {
                    return convertSexToBoolean(cell);
                }
                return cell.getRichStringCellValue().getString();
            /*    取出来的值是数字类型的时候也会分几种情况，第一种情况就是取出来的是日期字符型的时候 ，要么就是纯数字了      */
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                }
                DecimalFormat df = new DecimalFormat("0");
                String stringNumber = df.format(cell.getNumericCellValue());
                /*  长度大于11位的就应该是Long类型的数字了，就转换成Long类型数字，否则默认就是转换成Integer类型  */
                if (stringNumber.length() >= 11) {
                    return convertLong(stringNumber);
                }
                return convertInteger(stringNumber);
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case Cell.CELL_TYPE_BLANK:
                return "";
            case Cell.CELL_TYPE_ERROR:
                return "类型错误";
            default:
                return "无法判断的一个类型";
        }

    }

    /**
     * 将一个String类型的数字转换成一个Long类型的数字
     *
     * @param stringNumber String类型的数字
     * @return 如果是一个可以被转换的数字的话就转换成那个数字，否则就默认设置一个默认的值9999，以表示这条数据出错
     */
    private static Long convertLong(String stringNumber) {
        Long parseLong;
        try {
            parseLong = Long.parseLong(stringNumber);
        } catch (NumberFormatException e) {
            parseLong = 9999L;
            throw new BusinessException(BaseEnum.ROW_VALUE_CONVERT_NUMBER_FAIL);
        }
        return parseLong;
    }


    /**
     * 将一个String类型的数字转换成一个Integer类型的数字
     *
     * @param stringNumber String类型的数字
     * @return 如果是一个可以被转换的数字的话就转换成那个数字，否则就默认设置一个默认的值9999，以表示这条数据出错
     */
    private static Integer convertInteger(String stringNumber) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            parseInt = 9999;
            throw new BusinessException(BaseEnum.ROW_VALUE_CONVERT_NUMBER_FAIL);
        }
        return parseInt;
    }

    /**
     * 判断单元格中的值是不是性别，如果是则返回true
     *
     * @param cell 一个单元格
     * @return 是性别文本的话就返回true，如果不是就返回false
     */
    private static boolean isSexText(Cell cell) {
        String anyText = cell.getStringCellValue();
        return anyText.equals("男") || anyText.equals("女");
    }


    /**
     * 根据表格里获取的文本判断性别，如果没有获取到就默认是男
     *
     * @param cell 一个单元格
     * @return 用boolean表示的性别，true为男，false为女
     */
    private static boolean convertSexToBoolean(Cell cell) {
        return !cell.getStringCellValue().equals("女");
    }


    /**
     * 根据上传的Excel版本返回不同的解析Excel表格的方法
     *
     * @param file          上传的Excel文件
     * @param fileExtension 上传的文件的扩展名
     * @return 根据不同的文件扩展名返回不同的工具方法
     */
    private static Workbook getWorkbook(File file, String fileExtension) {
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
    public static boolean parseExcelFileType(String fileType, String fileExtension) {
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
