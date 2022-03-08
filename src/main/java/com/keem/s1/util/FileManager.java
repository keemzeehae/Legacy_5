package com.keem.s1.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;
	
	public String save(MultipartFile file,String path) throws Exception{
		//1. 어디에 저장할거냐 /resources/upload/memeber
		//path = /resources/upload/member
		
		String realPath= servletContext.getRealPath(path);
		System.out.println(realPath);
		
		return "";
		
	}

}
