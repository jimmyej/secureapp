package pe.com.dev.util.ssh;

import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSHUtil {

	public static void main(String[] args) {

		String command = "ls";
		SSHUtil test = new SSHUtil();
		test.initSession();
		test.runCommand(command);
//		test.runCommand("ssh v174477@v19saccda07 -pw J1337e$e");
//		test.runCommand("bash");
//		test.runCommand("cd /");
//		test.runCommand("ls apps/opt/");
		test.disconnectSession();
	}
	Session session;
	
	public void initSession() {
		JSch jsch = new JSch();
		String host = "salsa.verizon.com";
		String username = "v174477";
		String password = "changeme";
		try {
			session = jsch.getSession(username, host, 22);
			session.setPassword(password);
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setPassword(password);
			session.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void disconnectSession(){
		session.disconnect();
	}
	public void runCommand(String command) {
		try {
			Channel channel = session.openChannel("exec");
			channel.setInputStream(null);
			channel.setOutputStream(System.out);
			((ChannelExec) channel).setCommand(command);
			channel.connect();
			InputStream in = channel.getInputStream();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					System.out.println("exit-status:"+channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
					
				}
			}
			channel.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
