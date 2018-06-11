package com.stone.webapp.config.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stone.webapp.config.ResultMsg;
import com.stone.webapp.config.listener.StringPrintWriter;

@ControllerAdvice
public class GlobalDefultExceptionHandler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(ApiException.class)  
    @ResponseBody  
    public ResultMsg defultExcepitonHandler(HttpServletRequest request,ApiException e) {  
        log.error("ApiException");
		return e.getResult();  
    }
	
	@ExceptionHandler(Exception.class)  
    public Object defultExcepitonHandler(HttpServletRequest req, Exception e) throws IOException {  
		log.error("Exception", e);
		StringPrintWriter spw = new StringPrintWriter();
		e.printStackTrace(spw);
		String errorContent = spw.getString();
		List<String> list = new ArrayList<>();
		for(String s : errorContent.split("\r\n")){
			list.add(s);
		}
		String contentTypeHeader = req.getHeader("Content-Type");
        String acceptHeader = req.getHeader("Accept");
        String xRequestedWith = req.getHeader("X-Requested-With");
        if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
        	return new ResponseEntity<>(ResultMsg.buildFail(list), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("detailMessage", HttpStatus.INTERNAL_SERVER_ERROR);
            modelAndView.addObject("url", req.getRequestURL());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }
	
}
