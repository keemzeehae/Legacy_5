package com.keem.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;
	
	public Boolean remove(String path,String fileName) throws Exception{
		//파일 HDD에서 삭제
		//필요한 정보: 저장된 폴더명, 저장된 파일명
		path=servletContext.getRealPath(path);
		
		File file = new File(path, fileName);
		
		return file.delete();

	}
	
	public String save(MultipartFile multipartFile,String path) throws Exception{
		//1. 어디에 저장할거냐 /resources/upload/memeber
		//path = /resources/upload/member 
		//파일 저장은 tomcat이 아니라 OS에서 저장
		String realPath= servletContext.getRealPath(path);
		System.out.println(realPath);
		
		File file= new File(realPath);
		//파일 객체에 폴더 정보를 담아라
		if(!file.exists()) {
			//file2.mkdir(); //중간에 폴더가 없으면 에러  /resources/upload이게 없다면 에러/memeber
			file.mkdirs();//중간폴더가 없으면 중간 폴더를 생성해줌
		}
		
		
		//1. 시간을 이용
		Calendar ca= Calendar.getInstance();
		long l = ca.getTimeInMillis(); //현재시간을 밀리세컨즈로 변환
		System.out.println("time: "+l);
		String oriName = multipartFile.getOriginalFilename(); //ari.jpg
		
		String fileName=l+"_"+oriName;
		System.out.println("fileName: "+fileName);
		
		//2. UUID
		fileName=UUID.randomUUID().toString(); //static 클래스메서드임 리턴이 string이 아니라서 toString으로 변환
		fileName=fileName+"_"+oriName;
		System.out.println("UUID: "+fileName);
		
		//file HDD에 저장
		//1. MultipartFile 클래스의 transferTo 메서드 사용
		//file = new File(realPath,fileName); //이경로에 이 파일이름으로 
		//file = new File(file,fileName); //이경로에 직접 경로명을 넣어도 됨
		//multipartFile.transferTo(file);
		
		//2. FileCopyUtils
		file = new File(file,fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		//이진데이터로 사진이 저장되어있는걸 꺼내가지고 옴
		
		return fileName;
		
	}

}
