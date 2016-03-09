package pe.com.dev.util;

import java.io.File;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SQLDeveloperDecrypter {
	
	
	
    public static void main(String[] args) throws Exception {

    	File file = new File("C:\\Users\\v174477\\AppData\\Roaming\\SQL Developer\\system4.0.2.15.21\\o.jdeveloper.db.connection.12.1.3.2.41.140418.1111\\");
//    	File file = new File("C:/Users/v174477/AppData/Roaming/SQL Developer/system4.0.2.15.21/o.jdeveloper.db.connection.12.1.3.2.41.140418.1111/");
        
        if (file.isDirectory()) {
            file = new File(file, "connections.xml");
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file.toURI().toString());
        
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile("//StringRefAddr[@addrType='password']/Contents");

        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Element e = (Element) nodes.item(i);
            System.out.println("Connection name     : " + ((Element) e.getParentNode().getParentNode().getParentNode()).getAttribute("name"));
            System.out.println("Password (encrypted): " + e.getTextContent());
            System.out.println("Password (decrypted): " + decryptPassword(e.getTextContent()));
            System.out.println();
        }
    }
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    
    public static String decryptPassword(String result) throws GeneralSecurityException {
          return new String(decryptPassword(hexStringToByteArray(result)));
    }

    public static byte[] decryptPassword(byte[] result) throws GeneralSecurityException {
        byte constant = result[0];
        if (constant != 5) {
            throw new IllegalArgumentException();
        }

        byte[] secretKey = new byte[8];
        System.arraycopy(result, 1, secretKey, 0, 8);

        byte[] encryptedPassword = new byte[result.length - 9];
        System.arraycopy(result, 9, encryptedPassword, 0, encryptedPassword.length);

        byte[] iv = new byte[8];
        for (int i = 0; i < iv.length; i++) {
            iv[i] = 0;
        }

        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey, "DES"), new IvParameterSpec(iv));
        return cipher.doFinal(encryptedPassword);
    }

}
