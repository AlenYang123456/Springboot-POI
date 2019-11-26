package net.general.aggregation.enums;

import lombok.Getter;

/**
 * @Author: 杨强
 * @Date: 2019/10/25 10:31
 * @Version 1.0
 * @Discription 响应枚举类
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    FAIL(-1,"失败"),
    PARAM_ERROR(1, "参数不正确");



    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
