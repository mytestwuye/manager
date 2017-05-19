package com.suny.association.enums;

/**
 * Comments:  基础错误代码枚举类
 * Author:   孙建荣
 * Create Date: 2017/03/08 18:10
 */
public enum BaseEnum {

    LOGIN_FAILURE("001", "登陆验证失败，请检查用户名密码是否正确"),
    ADD_FAILURE("002", "添加失败"),
    DELETE_FAILURE("003", "删除失败"),
    UPDATE_FAILURE("004", "更新失败"),
    SELECT_FAILURE("005", "查询失败"),
    REPEAT_ADD("006", "重复添加"),
    SYSTEM_LIMIT("007", "系统限制，不允许操作"),
    ADD_FAIL_ALL_NULL("008", "数据为空，全部插入失败"),
    ADD_FAIL_ALL("009", "开启考勤失败"),
    ADD_SUCCESS("102", "添加成功"),
    DELETE_SUCCESS("103", "删除成功"),
    UPDATE_SUCCESS("104", "更新成功"),
    SELECT_SUCCESS("105", "查询成功"),
    REPEAT_EMAIL("106", "邮箱重复"),
    REPEAT_PHONE("107", "手机号码重复"),
    REPEAT_USERNAME("108", "用户名重复"),
    ADD_SUCCESS_PART_OF("109", "批量插入部分成功"),
    ADD_SUCCESS_ALL("110", "全部插入成功"),
    NULL_OBJ("201", "对象为空"),
    FIELD_NULL("202", "必要字段为空"),
    PRIMARY_NULL("203", "主键字段为空"),
    HAVE_QUOTE("204", "存在引用"),
    MUST_CHINESE("205", "一定要是中文"),
    LIMIT_MEMBER_Manager("206", "部门角色太低"),
    FIELD_LENGTH_WRONG("207", "字段的长度有错误"),
    OLD_PASSWORD_WRONG("208", "原密码错误"),
    TWICE_PASSWORD_EQUALS("209", "两次密码一样"),
    TWICE_PASSWORD_DIFFERENT("210", "两次密码不一样"),
    MALICIOUS_OPERATION("211", "恶意操作"),
    REPEAT_PUNCH("212", "重复签到"),
    TIME_NOT_REACH("213", "未到达指定时间"),
    PUNCH_SUCCESS("214", "考勤成功"),
    PUNCH_FAIL("215", "考勤失败"),
    ROW_VALUE_CONVERT_NUMBER_FAIL("797", "转换成数字失败"),
    ROW_NUM_OVERFLOW("798", "读取工作行下标溢出"),
    SHEET_NUM_OVERFLOW("799", "读取工作表下标溢出"),
    FILE_NOT_EXIST("897", "读取的文件不存在"),
    FILE_READ_FAIL("896", "读取出错"),
    FILE_NOT_SUPPORT("897", "不支持的文件"),
    FILE_EXTENSION_WARN("898", "文件名可能存在欺骗"),
    FILE_NULL("899", "文件是空的，无法读取"),
    NO_LOGIN_IN("987", "没有登录"),
    REPEAT_SUBMIT("988", "重复提交"),
    LOGOUT_FAIL("989", "注销失败"),
    UNDERPASS_ERROR("990", "用户名或密码输入错误"),
    VALIDATE_CODE_ERROR("991", "验证码输入错误"),
    VALIDATE_CODE_SUCCESS("992", "验证码输入正确"),
    LOGOUT_SUCCESS("993", "注销系统成功"),
    LOGIN_SYSTEM("995", "登录成功"),
    PASS_ERROR("996", "密码错误"),
    REPEAT_LOGIN("998", "重复登录"),
    UNKNOWN_ERROR("999", "系统繁忙....");

    String value;
    String desc;

    BaseEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "系统代码:" + value + "," + desc;
    }


}
