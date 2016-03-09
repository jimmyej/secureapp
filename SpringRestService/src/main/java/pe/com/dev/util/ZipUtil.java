package pe.com.dev.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipUtil {

	public static void main(String[] args) {
        try {
               // --------Encryption zipParameters (for password protection)--------
               // Create ZipParameters
               ZipParameters zipParameters = new ZipParameters();

               // Set how you want to encrypt files
               zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
               zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

               // Set encryption of files to true
               zipParameters.setEncryptFiles(true);

               // Set encryption method
               zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
               // Set key strength
               zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);

               // Set password
               zipParameters.setPassword("password");
               
               // --------------------CREATE ZIP file - Zip DIRECTORY-------------

               //Zip file name
               String destinationZipFilePath = "C:\\Users\\v174477\\MyFile.zip";

               // Create ZIP file
               ZipFile zipFile = new ZipFile(destinationZipFilePath);

               // Directory to be Zipped
               String directoryToBeZipped = "C:\\Users\\v174477\\readme";

               // pass (Directory to be Zipped) and ZIP parameters for Zip file to be created
               zipFile.addFolder(directoryToBeZipped, zipParameters);

               System.out.println("Password protected Zip file of Directory " + directoryToBeZipped+" have been created at "+ destinationZipFilePath);

        } catch (ZipException e) {
               e.printStackTrace();
        }
 }

}
