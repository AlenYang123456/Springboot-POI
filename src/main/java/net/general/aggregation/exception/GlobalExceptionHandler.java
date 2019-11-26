package net.general.aggregation.exception;

import lombok.extern.slf4j.Slf4j;
import net.general.aggregation.enums.ResultEnum;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: dreamer Q
 * @Date: 2019/10/25 10:33
 * @Version 1.0
 * @Discription  异常捕获处理器
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    public ResultEnum handleUniteException(Exception e){
        //需要添加日志

        String message="接口繁忙,请联系技术人员";

        if (e instanceof BusinessException) {
            message=e.getMessage();
        }else if (e instanceof SQLException){
            message="数据库SQL异常,请联系开发人员";
        }else if (e instanceof HttpMessageNotReadableException){
            message="请求参数异常";
        }else if (e instanceof MethodArgumentNotValidException){
            //记录参数校验的异常
            message=((MethodArgumentNotValidException)e).getBindingResult().getFieldError().getDefaultMessage();
        }else if (e instanceof BindException){
            BindException bindException = (BindException) e;
            BeanPropertyBindingResult bindingResult = (BeanPropertyBindingResult) bindException.getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            message=fieldErrors.stream().map(error->error.getDefaultMessage()).reduce((s, s2) -> s.concat(s2)).get();
        }else {
            message="接口繁忙,请联系技术人员";
        }
        return ResultEnum.FAIL;
    }


}
