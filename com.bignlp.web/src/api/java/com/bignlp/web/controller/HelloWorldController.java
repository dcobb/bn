package com.bignlp.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @RequestMapping(value = "/helloworld")
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping(value = "{argAppContextPath}", method = RequestMethod.GET)
	public String displayLayout(Model argModel,
			@PathVariable String argAppContextPath,
			HttpServletRequest argRequest, HttpServletResponse argResponse) {
		if (argAppContextPath != null && !argAppContextPath.isEmpty()) {
			argModel.addAttribute("contextPath", argAppContextPath);
		} else {
			argModel.addAttribute("contextPath", "ROOT");
		}
		return "helloworld";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	InputStream printHello() {
		File inputFile = new File(this.getClass().getResource("/example.txt")
				.getFile());
		InputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not found: ", e);
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
		return fileInputStream;
	}

}
