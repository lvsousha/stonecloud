package com.stone.webapp.listener;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SimpleHandlerExceptionResolver implements HandlerExceptionResolver {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		String requestType = request.getHeader("X-Requested-With");
		if(requestType == null){
			log.info("simple");
			log.error("Catch Exception: ",exception); 
			Map<String,Object> map = new HashMap<String,Object>();
			StringPrintWriter strintPrintWriter = new StringPrintWriter();  
			exception.printStackTrace(strintPrintWriter);  
			map.put("errorMsg", strintPrintWriter.getString());//将错误信息传递给view  
			
		}else if(requestType.equals("XMLHttpRequest")){
			log.info("AJAX");
			try{
				InputStream is = request.getInputStream();
				byte[] b = new byte[1024];
				int status = is.read(b);
				
				while(status != -1){
					log.info(new String(b));
					status = is.read(b);
				}
				PrintWriter writer = response.getWriter();  
	            writer.write("500");  
	            writer.flush(); 
			}catch(Exception e){
				log.error(e);
			}
		}
        return null;
	}

}
