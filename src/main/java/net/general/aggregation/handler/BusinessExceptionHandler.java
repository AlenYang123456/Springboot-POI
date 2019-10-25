package net.general.aggregation.handler;

import net.general.aggregation.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: 杨强
 * @Date: 2019/10/25 10:33
 * @Version 1.0
 * @Discription  异常捕获处理器
 */
@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public void handleBusinessException(){

    }
}
