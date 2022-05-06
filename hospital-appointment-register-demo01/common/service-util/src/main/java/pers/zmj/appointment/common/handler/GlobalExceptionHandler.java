package pers.zmj.appointment.common.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.zmj.appointment.common.exception.AppointmentException;
import pers.zmj.appointment.common.result.Result;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Object> error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * 自定义异常处理方法
     */
    @ExceptionHandler(AppointmentException.class)
    public Result<Object> error(AppointmentException e){
        System.out.println("------------------------抛出自定义异常-------------------------");
        return Result.build(e.getCode(), e.getMessage());
    }
}