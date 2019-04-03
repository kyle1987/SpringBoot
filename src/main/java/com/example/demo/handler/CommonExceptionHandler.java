package com.example.demo.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.exception.ResponseException;

@ControllerAdvice
public class CommonExceptionHandler {
 
	 private static Logger logger = LogManager.getLogger(CommonExceptionHandler.class.getName());
	  
    /**
     *  拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> result = new HashMap<String,Object>();
        logger.error("",e);
        result.put("respCode", "999999");
        result.put("respMsg", "系统错误");
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return result; 
    }
    
    /**
     * 拦截 ResponseException 的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(ResponseException.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(ResponseException ex){
	    Map<String,Object> result = new HashMap<String,Object>();
	    result.put("respCode", ex.getRespCode());
	    result.put("respMsg", ex.getRespMsg());
	    return result; 
    }
}
