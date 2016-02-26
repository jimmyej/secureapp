package pe.com.dev.util;

import java.util.ResourceBundle;

public class ConfigProperties {

	private void loadProperties(){
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		System.out.println("Driver "+rb.getString("jdbc.driverClassName"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigProperties config = new ConfigProperties();
		config.loadProperties();
	}

}
