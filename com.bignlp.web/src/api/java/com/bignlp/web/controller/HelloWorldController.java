package com.bignlp.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bignlp.web.model.Converter;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	private static final String FILE_EXTENSION = ".txt";

	/*
	 * Here argFileName should be there in your testdata folder. Output of this
	 * method is in the form of String.
	 */
	@RequestMapping(value = "{argFileName}", method = RequestMethod.GET)
	public @ResponseBody
	String printHello(@PathVariable("argFileName") String argFileName) {
		File inputFile = new File(this.getClass()
				.getResource(buildFilePath(argFileName)).getFile());
		InputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
			return IOUtils.toString(fileInputStream);
			// return fileInputStream;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not found: ", e);
		} catch (IOException e) {
			throw new RuntimeException(
					"Exception while converting from inputstream to string: ",
					e);
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

	private String buildFilePath(String argFileName) {
		if (argFileName != null && !argFileName.isEmpty()) {
			return "/" + argFileName + FILE_EXTENSION;
		}
		return argFileName;
	}

	/*
	 * Here argFileName should be there in your testdata folder. Output of this
	 * method is in the form of JSON.
	 */
	@RequestMapping(value = "/json/{argFileName}", method = RequestMethod.GET)
	public @ResponseBody
	Converter printJson(@PathVariable("argFileName") String argFileName) {
		File inputFile = new File(this.getClass()
				.getResource(buildFilePath(argFileName)).getFile());
		InputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
			try {
				Converter converter = new Converter();
				converter.setBody(IOUtils.toString(fileInputStream));
				return converter;
			} catch (IOException e) {
				throw new RuntimeException(
						"Unable to convert inputstream to string: ", e);
			}
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
	}

}
