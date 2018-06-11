package com.stone.webapp.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stone.webapp.config.ResultMsg;

@Controller
@RequestMapping("/content/upload/")
public class UploadController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private static final int BUFFER_SIZE = 2 * 1024;
	
	@RequestMapping(value = "upload")
	public void localUpLoadProgram(@RequestParam("file") CommonsMultipartFile[] files, HttpServletResponse response, HttpServletRequest request) throws Exception {
//		log.info(params);
		copyFile(files, request);
	}
	
	@ResponseBody
	@RequestMapping(value = "getUploadedData")
	public ResultMsg getUploadedData(HttpServletResponse response, HttpServletRequest request, String params) throws Exception {
		System.out.println(params);
		
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		object.put("data", array);
		object.put("draw", 1);
		object.put("recordsTotal", 0);
		object.put("recordsFiltered", 0);
		return ResultMsg.buildSuccess(object);
	}
	
	private void copyFile(CommonsMultipartFile[] files, HttpServletRequest request) throws Exception{
		log.info(request.getCharacterEncoding());
		String basePath = request.getSession().getServletContext().getRealPath("")+"/files/upload/";
		log.info(basePath);
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		Integer chunk = Integer.parseInt(request.getParameter("chunk"));
//		Integer chunks = Integer.parseInt(request.getParameter("chunks"));
		String fileName = request.getParameter("name");
		if (isMultipart) {
			File folder = new File(basePath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			for(CommonsMultipartFile file : files ){
				FileItem item = file.getFileItem();
				InputStream input = item.getInputStream();
				if (!item.isFormField()) {
					File destFile = new File(folder, fileName);
					if (chunk == 0 && destFile.exists()) {
						destFile.delete();
						destFile = new File(folder, fileName);
					}
					appendFile(input, destFile);
				}
			}
		}
	}

	private void appendFile(InputStream in, File destFile) {
		OutputStream out = null;
		try {
			if (destFile.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(destFile, true), BUFFER_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(destFile), BUFFER_SIZE);
			}
			in = new BufferedInputStream(in, BUFFER_SIZE);
			int len = 0;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			log.error(destFile.getAbsolutePath(),e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				log.error(destFile.getAbsolutePath(),e);;
			}
		}
	}
}
