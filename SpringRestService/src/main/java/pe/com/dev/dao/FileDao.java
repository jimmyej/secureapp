package pe.com.dev.dao;

import java.util.List;

import pe.com.dev.domain.FileInfo;

public interface FileDao {
	public FileInfo getFilebyId(int id);
	public FileInfo getFilebyName(String fileName);
	public List<FileInfo> getAllFiles();
	public int addFile(FileInfo file);
	public int updFile(FileInfo file);
	public int dellFileById(int id);
	public int dellFileByName(String fileName);
}
