package pe.com.dev.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompresor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte[] buffer = new byte[1024];
    	
    	try{
    		
    		FileOutputStream fos = new FileOutputStream("C:\\Users\\v174477\\MyFile.zip");
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry("readme.txt");
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream("C:\\Users\\v174477\\readme.txt");
   	   
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}
    		in.close();
    		zos.closeEntry();
           
    		//remember close it
    		zos.close();
    		System.out.println("Done");

    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
	}

}
