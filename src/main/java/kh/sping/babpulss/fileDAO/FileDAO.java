package kh.sping.babpulss.fileDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kh.sping.babpulss.fileDTO.FileDTO;

public class FileDAO {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<FileDTO> getFilesBySeq(int seq) {
		String sql = "select * from files where seq = ?";
//		jdbc.query(sql, new RowMapper() {
//			@Override
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return null;
//			}
//		}, seq);
		return jdbc.query(sql, (rs, rowNum) -> {
			FileDTO dto = new FileDTO();
			dto.setSeq(rs.getInt(1));
			dto.setBoardSeq(rs.getInt(2));
			dto.setFileName(rs.getString(3));
			dto.setOriFileName(rs.getString(4));
			return dto;
		}, sql);
	}
	
	public int insertFile(FileDTO dto) throws Exception {
		return sst.insert("File.insertFile");
	}
	
	public int deleteFileByName(String fileName) throws Exception {
		String sql = "delete from files where fileName = ?";
		return jdbc.update(sql, fileName);
	}
	
}
