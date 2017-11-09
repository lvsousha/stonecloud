package com.stone.webapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/page")
public class PageController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value={"/index",""})
	public String index(HttpServletRequest request, Model model, RedirectAttributes ra) throws IOException {
		log.info("index");
		return "index";
	}
	
	@RequestMapping(value={"/upload"})
	public String upload(HttpServletRequest request, Model model, RedirectAttributes ra) throws IOException {
		log.info("upload");
		return "content/upload/index";
	}
	
	@RequestMapping(value={"/angularjs"})
	public String angularjs(HttpServletRequest request, Model model, RedirectAttributes ra) throws IOException {
		log.info("angularjs");
		return "content/angularjs/index";
	}
	
}
