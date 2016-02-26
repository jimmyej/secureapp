package pe.com.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.dev.dao.FileDao;
import pe.com.dev.domain.FileInfo;
import pe.com.dev.service.FileService;

@Repository("fileService")
public class FileServiceImpl implements FileService {

	@Autowired
	FileDao dao;
	
	public FileInfo FileInfoById(int fileNumber) {
		return dao.getFilebyId(fileNumber);
	}

	public FileInfo FileInfoByName(String fileName) {
		return dao.getFilebyName(fileName);
	}

	public List<FileInfo> FileList() {
		return dao.getAllFiles();
	}

	public int createFile(FileInfo file) {
		return dao.addFile(file);
	}
	
	public int modifyFile(FileInfo file) {
		return dao.updFile(file);
	}
	
	public int removeFile(int fileNumber) {
		return dao.dellFileById(fileNumber);
	}

}
