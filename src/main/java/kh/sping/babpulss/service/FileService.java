package kh.sping.babpulss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sping.babpulss.fileDAO.FileDAO;
import kh.sping.babpulss.fileDTO.FileDTO;

@Service
public class FileService {

	@Autowired
	private FileDAO fileDAO;
	
	public List<FileDTO> getFilesBySeq(int seq) throws Exception {
		return fileDAO.getFilesBySeq(seq);
	}
	
	public int insertFile(BoardDTO boardDTO) throws Exception {
		FileDTO dto = new FileDTO();
		dto.setBoardSeq(boardDTO.getSeq());

		return fileDAO.insertFile(dto);
	}
	
	public int deleteFileByName(String fileName) throws Exception {
		return fileDAO.deleteFileByName(fileName);
	}
	
}
