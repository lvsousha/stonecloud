package com.stone.webapp.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/content/upload/")
public class UploadController {
	
	private Logger log = Logger.getLogger(this.getClass());
	private static final int BUFFER_SIZE = 2 * 1024;
	private Gson gson = new GsonBuilder()  
//				.setDateFormat("yyyy-MM-dd HH:mm:ss")  
				.create();
	
	@RequestMapping(value = "upload")
	public void localUpLoadProgram(@RequestParam("file") CommonsMultipartFile[] files, HttpServletResponse response, HttpServletRequest request) throws Exception {
//		log.info(params);
		copyFile(files, request);
	}
	
	@ResponseBody
	@RequestMapping(value = "getUploadedData")
	public JsonObject getUploadedData(HttpServletResponse response, HttpServletRequest request, String params) throws Exception {
		System.out.println(params);
		JsonObject paramsJson = gson.fromJson(params, JsonObject.class);
		for(Entry<String, JsonElement> e : paramsJson.entrySet()){
			System.out.println(e.getKey());
		}
		
		JsonObject object = new JsonObject();
		JsonArray array = new JsonArray();
//		for(int i=1; i<10; i++){
//			JsonObject o = new JsonObject();
//			o.addProperty("fileId", i);
//			o.addProperty("fileName", "file"+i);
//			o.addProperty("fileSize", "1000KB");
//			o.addProperty("progress", i);
//			array.add(o);
//		}
		object.add("data", array);
		object.addProperty("draw", 1);
		object.addProperty("recordsTotal", 0);
		object.addProperty("recordsFiltered", 0);
		return object;
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
			log.error(destFile,e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				log.error(destFile,e);;
			}
		}
	}
}
