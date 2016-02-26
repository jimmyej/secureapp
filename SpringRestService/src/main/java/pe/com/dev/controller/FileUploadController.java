package pe.com.dev.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pe.com.dev.constant.URIConstants;
import pe.com.dev.domain.FileInfo;
import pe.com.dev.service.FileService;

/**
 * Handles requests for the application file upload requests
 */
@Controller("fileUploadController")
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@Autowired
	FileService service;
	
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = URIConstants.COMMON_FS_SIMPLE_UPLOAD, method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file) {
		return uploadFile(file);
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = URIConstants.COMMON_FS_MULTIP_UPLOAD, method = RequestMethod.POST)
	public @ResponseBody String uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {
		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			message = message + uploadFile(file);
		}
		return message;
	}

	public String uploadFile(MultipartFile file) {
		String fileName = "";
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				fileName = generateFileName(file.getOriginalFilename());

				// Creating the directory to store file
				String rootPath = "C:\\opt";// System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + fileName;
			} catch (Exception e) {
				return "You failed to upload " + fileName + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + fileName + " because the file was empty.";
		}
	}

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = URIConstants.COMMON_DB_SIMPLE_UPLOAD, method = RequestMethod.POST)
	public @ResponseBody String uploadFileDB(@RequestParam("file") MultipartFile file) {
		
		String message = "";
		if(!file.isEmpty()){
			FileInfo fileInfo = new FileInfo();
			try {
				fileInfo.setFileName(file.getOriginalFilename());
				fileInfo.setFileType(file.getContentType());
				fileInfo.setFileData(file.getBytes());
				fileInfo.setDescription("Test 1");
				fileInfo.setCreatedBy("jimmyej");
				fileInfo.setUpdatedBy("jimmyej");
			} catch (IOException e) {
				e.printStackTrace();
			}
			int response = service.createFile(fileInfo);
			
			if(response>0){
				message = "You successfully uploaded file="+file.getOriginalFilename();
			} else {
				message = "You failed to upload " + file.getOriginalFilename();
			}
		}else{
			message = "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
		}
		
		return message;
	}
	
	public String generateFileName(String fileName) {
		String name = "";
		if (!fileName.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHMMss");
			String dateTime = sdf.format(new Date());
			int i = fileName.lastIndexOf('.');
			name = fileName.substring(0, i) + "_" + dateTime + fileName.substring(i);
		}
		return name.toUpperCase();
	}

	@RequestMapping(value = URIConstants.COMMON_FS_SIMPLE_DOWNLOAD, method = RequestMethod.GET)
	public @ResponseBody void downloadFiles(HttpServletRequest request, HttpServletResponse response) {
		ServletContext context = request.getSession().getServletContext();//request.getServletContext();
		String filePath = "C:\\opt\\tmpFiles\\result.xls";
		File downloadFile = new File(filePath);
		FileInputStream inputStream = null;
		OutputStream outStream = null;

		try {
			inputStream = new FileInputStream(downloadFile);

			response.setContentLength((int) downloadFile.length());
			response.setContentType(context.getMimeType(filePath));

			// response header
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
			response.setHeader(headerKey, headerValue);

			// Write response
			outStream = response.getOutputStream();
			IOUtils.copy(inputStream, outStream);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream)
					inputStream.close();
				if (null != outStream)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = URIConstants.COMMON_DB_SIMPLE_DOWNLOAD, method = RequestMethod.GET)
	public @ResponseBody void downloadFileDB(HttpServletRequest request, HttpServletResponse response) {
		String fileName = "Marriage Certificate.pdf";
		OutputStream outStream = null;

		try {
			FileInfo fileInfo = service.FileInfoByName(fileName);
			byte[] data = fileInfo.getFileData();

			response.setContentLength((int) data.length);
			response.setContentType(fileInfo.getFileType());

			// response header
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", fileInfo.getFileName());
			response.setHeader(headerKey, headerValue);

			// Write response
			outStream = response.getOutputStream();			
			FileCopyUtils.copy(data, outStream);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != outStream)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
