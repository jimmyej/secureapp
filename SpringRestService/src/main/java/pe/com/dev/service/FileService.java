package pe.com.dev.service;

import java.util.List;

import pe.com.dev.domain.FileInfo;

public interface FileService {
	public FileInfo FileInfoById(int fileNumber);
	public FileInfo FileInfoByName(String fileName);
	public List<FileInfo> FileList();
	public int createFile(FileInfo file);
	public int modifyFile(FileInfo file);
	public int removeFile(int fileNumber);
}
