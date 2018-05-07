package com.stone.webapp.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/office/toPdf")
public class OfficeToPdfController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/preview")
	public void preview(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.info("preview");
		File file = new File("/target.pdf");
        if (file.exists()){
            byte[] data = null;
            try {
                FileInputStream input = new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
                input.close();
            } catch (Exception e) {
                log.error("pdf文件处理异常：" + e.getMessage());
            }
        }else{
            return;
        }
	}

}
