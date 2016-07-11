package pe.com.dev.util;

import java.io.IOException;

public class ProcessUtil {

    private void init(){ 
        try { 
//            Process p = Runtime.getRuntime().exec("calc.exe"); 
//            Process p = Runtime.getRuntime().exec("notepad.exe"); 
            Runtime.getRuntime().exec("cmd /c start cmd.exe"); 
        } catch (IOException ex) { 
        	ex.printStackTrace();
        } 
    } 

    /** 
     * @param args the command line arguments 
     */ 
    public static void main(String[] args) { 
    	ProcessUtil pt = new ProcessUtil(); 
        pt.init(); 
    }

}
