package com.keem.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.keem.s1.file.FileDTO;
import com.keem.s1.member.MemberFileDTO;
@Component
public class FileDown extends AbstractView{
	//Bean의 이름이 FileDown
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//controller에서 mv.object ( "file" ,memberfileDTO) 가 여기 model에 담겨있는것
		FileDTO fileDTO=(FileDTO)model.get("file");
		
		System.out.println(fileDTO.getFileName());
		System.out.println(fileDTO.getOriName());

		String board = (String)model.get("board");
		String path="/resources/upload/"+board+"/";
		
		//내장객체는 다른 영역의 내장객체를 불러올 수 있음
		//단 좁은영역에서 큰영역(오래사는)으로 가능, 반대는 불가능
		//page -> request -> session -> application (ServletContext)
		//이때 getRealPath메서드를 써야하는데 이메서드는 application이 가지고 있음 
		//매개변수에 request가 있음 
		ServletContext sc = request.getSession().getServletContext();
		
		path=sc.getRealPath(path);
		
		//파일정보를 담아놓는 객체를 만듦
		File file = new File(path, fileDTO.getFileName());
		System.out.println(file.exists());
		System.out.println(file.isFile());
		
		//Encoding 처리
		response.setCharacterEncoding("UTF-8");
		
		//총 파일의 크기
		response.setContentLength((int)file.length());
		
		//download시에 파일의 이름을 인코딩
		String fileName=URLEncoder.encode(fileDTO.getOriName(),"UTF-8");
		
		//Header설정 다운로드시 보이는 이름 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//HDD에서 파일을 읽어서 client로 전송 연결 준비
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		//최종전송
		FileCopyUtils.copy(fi, os);
		
		//Stream으로 하는건 연결 끊어줘야 함
		//연결 끊기
		
		os.close();
		fi.close();
		
		
	}
}
