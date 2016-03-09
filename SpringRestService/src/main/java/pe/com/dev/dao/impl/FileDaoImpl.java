package pe.com.dev.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.dev.dao.FileDao;
import pe.com.dev.domain.FileInfo;

@Repository("fileDao")
public class FileDaoImpl implements FileDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

	
	public FileInfo getFilebyId(int id) {
		FileInfo file = (FileInfo) getJdbcTemplate().queryForObject(getFileByIdSql(), new Object[] { id }, new BeanPropertyRowMapper<FileInfo>(FileInfo.class));
		return file;
	}
	public FileInfo getFilebyName(String fileName) {
		FileInfo file = (FileInfo) getJdbcTemplate().queryForObject(getFileByNameSql(), new Object[] { fileName }, new BeanPropertyRowMapper<FileInfo>(FileInfo.class));
		return file;
	}
	public List<FileInfo> getAllFiles() {
		List<FileInfo> files = (ArrayList<FileInfo>) getJdbcTemplate().query(getAllFilesSql(), new BeanPropertyRowMapper<FileInfo>(FileInfo.class));
		return files;
	}
	public int addFile(FileInfo file) {
		int result = 0;
		System.out.println("file: "+file);
		
		Calendar cal = Calendar.getInstance();
		file.setCreatedDate(cal.getTime());
		file.setUpdatedDate(cal.getTime());

		Object[] parameters = new Object[] { 
			file.getFileName(),
			file.getFileType(),
			file.getFileData(),
			file.getDescription(),
			file.getCreatedBy(),
			file.getCreatedDate(),
			file.getUpdatedBy(),
			file.getUpdatedDate()
	    };
		result = getJdbcTemplate().update(insFileSql(), parameters);
		return result;
	}
	public int updFile(FileInfo file) {
		FileInfo fileInfo = getFilebyName(file.getFileName());
		String params = "";
		int result = 0;
		ArrayList<Object> parameters = new ArrayList<Object>();
		
		if(file.getFileName() != fileInfo.getFileName()){
			params = params + "FILE_NAME,";
			parameters.add(file.getFileName());
		}
		if(!file.getFileType().equals(fileInfo.getFileType())){
			params = params + "FILE_TYPE,";
			parameters.add(file.getFileType());
		}
		if(!file.getFileData().equals(fileInfo.getFileData())){
			params = params + "FILE_DATA,";
			parameters.add(file.getFileData());
		}
		if(file.getDescription() != fileInfo.getDescription()){
			params = params + "DESCRIPTION,";
			parameters.add(file.getDescription());
		}
		Calendar cal = Calendar.getInstance();
		file.setUpdatedDate(cal.getTime());
		
		parameters.add(file.getUpdatedDate());
		parameters.add(file.getUpdatedBy());
		parameters.add(file.getFileNumber());
		
		result = getJdbcTemplate().update(updFileAllSql(params), parameters.toArray() );
		return result;
	}
	public int dellFileById(int id) {
		int result = 0;
		result = getJdbcTemplate().update(delFileByIdSql(), new Object[] { id });
		if(result!=0)
			System.out.println("User deleted successfully.");
		else
			System.out.println("Couldn't delete User with given id as it doesn't exist");
		return result;
	}
	public int dellFileByName(String fileName) {
		int result = 0;
		result = getJdbcTemplate().update(delFileByNameSql(), new Object[] { fileName });
		if(result!=0)
			System.out.println("User deleted successfully.");
		else
			System.out.println("Couldn't delete User with given id as it doesn't exist");
		return result;
	}
	
	
	private String getFileByIdSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM FILES WHERE FILE_NUMBER = ?");
		return sql.toString();
	}
	private String getFileByNameSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM FILES WHERE FILE_NAME = ?");
		return sql.toString();
	}
	private String getAllFilesSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM FILES");
		return sql.toString();
	}
	private String insFileSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO FILES ( FILE_NAME, FILE_TYPE, FILE_DATA, DESCRIPTION, CREATED_BY, CREATED_DATE, UPDATED_BY, UPDATED_DATE ) VALUES( ?, ?, ?, ?, ?, ?, ?, ? )");
		return sql.toString();
	}
	private String updFileAllSql(String params){
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE FILES SET ");
		if(params.contains("FILE_NAME")){
			sql.append("FILE_NAME= ? , ");
		}
		if(params.contains("FILE_TYPE")){
			sql.append("FILE_TYPE= ? , ");
		}
		if(params.contains("FILE_DATA")){
			sql.append("FILE_DATA= ? , ");
		}
		if(params.contains("DESCRIPTION")){
			sql.append("DESCRIPTION= ? , ");
		}
		sql.append("UPDATED_DATE= ?, UPDATED_BY= ? WHERE FILE_NUMBER= ?");
		return sql.toString();
	}
	private String delFileByIdSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM FILES WHERE FILE_NUMBER = ?");
		return sql.toString();
	}
	private String delFileByNameSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM FILES WHERE FILE_NAME = ?");
		return sql.toString();
	}
}
