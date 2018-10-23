package com.qianli.ilink.cloud_platform.messagecenter.core.exception.handles;


import com.google.common.collect.Lists;
import com.qianli.ilink.cloud_platform.commons.core.eneity.FieldErrorEntity;
import com.qianli.ilink.cloud_platform.commons.core.enums.ResultEnum;
import com.qianli.ilink.cloud_platform.commons.core.utils.ResponseEntityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    //添加全局异常处理流程，根据需要设置需要处理的异常，本文以MethodArgumentNotValidException为例
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidHandler(HttpServletRequest request,
                                                MethodArgumentNotValidException exception) {

        //按需重新封装需要返回的错误信息
        List<FieldErrorEntity> list = Lists.newArrayList();

        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        exception.getBindingResult().getFieldErrors().forEach
                (error -> list.add(new FieldErrorEntity(error.getDefaultMessage(), error.getField(), error.getRejectedValue())));
        log.error("request url method argument not valid , url : {} ,errors : {}",request.getRequestURL().toString(),list);

        return ResponseEntityUtils.build(ResultEnum.ILLEGAL_ARGUMENT_ERROR,list);
    }

    @ExceptionHandler(value = Throwable.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                Throwable exception) {
        log.error("unknown error , from url : {} , exception : {}",request.getRequestURL().toString(),exception);

        return ResponseEntityUtils.build(ResultEnum.UNKNOWN_ERROR);
    }
}