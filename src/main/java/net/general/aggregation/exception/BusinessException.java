package net.general.aggregation.exception;

import net.general.aggregation.enums.ResultEnum;

/**
 * @Author: 杨强
 * @Date: 2019/10/25 10:29
 * @Version 1.0
 * @Discription 自定义异常类
 */
public class BusinessException extends RuntimeException {

    private Integer code;

    /** 带枚举入参的构造方法 */
    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
    /** 带code和message的构造方法 */
    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
