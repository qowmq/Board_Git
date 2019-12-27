package kh.sping.babpulss.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import kh.sping.babpulss.fileDTO.FileDTO;
import kh.sping.babpulss.service.FileService;

@Controller
public class FileController {

	@Autowired
	private HttpSession session;

	@Autowired
	private FileService fileService;
	
	public List<FileDTO> getFilesBySeq(int seq) throws Exception {
		return fileService.getFilesBySeq(seq);
	}
	
	public int insertFile(BoardDTO boardDTO) throws Exception {
		MultipartFile[] files = boardDTO.getFiles();
		String rootPath = session.getServletContext().getRealPath("/files");
		
		for (MultipartFile tmp : files) {
			String oriName = tmp.getOriginalFilename();
			String sysName = System.currentTimeMillis() + "_" + oriName;
			File f = new File(rootPath + "/" + sysName);
		}
		return fileService.insertFile(boardDTO);
	}
	
	public int deleteFileByName(String fileName) throws Exception {
		return fileService.deleteFileByName(fileName);
	}
	
}
