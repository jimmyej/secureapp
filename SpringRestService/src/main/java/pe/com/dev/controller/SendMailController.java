package pe.com.dev.controller;

//import java.io.File;
//import java.io.IOException;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.multipart.MultipartFile;
//
//import pe.com.dev.constant.URIConstants;

//@Controller("sendMailController")
public class SendMailController {
	/*
	@Autowired
	//private MailSender mailSender;
	private JavaMailSenderImpl mailSender;
	
	@RequestMapping(value = URIConstants.COMMON_SIMPLE_EMAIL, method = RequestMethod.POST)
	public String sendSimpleemail(@PathVariable("to") String to,@PathVariable("subject") String subject, @PathVariable("message") String message){
		String sent = "";
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(message);
        try {
        	// sends the e-mail
            mailSender.send(email);
            sent="Email sent successfully..!!!";
		} catch (Exception e) {
			sent="Email failed..!!1";
		}
		return sent;
	}
	public void send(String to, String subject, String text, MultipartFile[] files) {
		// plantilla para el envío de email
		final MimeMessage message = mailSender.createMimeMessage();
 
		try {
			// el flag a true indica que va a ser multipart
			final MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			// settings de los parámetros del envío
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("");
			helper.setText(text);
 
			// adjuntando los ficheros
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					MultipartFile multiPartFile = files[i];
					FileSystemResource file = new FileSystemResource(multipartToFile(multiPartFile));
					helper.addAttachment(files[i].getOriginalFilename(), file);
				}
			}
		} catch (MessagingException e) {
			new RuntimeException(e);
		} 
		
		// el envío
		this.mailSender.send(message);
	}
	public File multipartToFile(MultipartFile multipart)
	{
        File convFile = new File( multipart.getOriginalFilename());
        try {
			multipart.transferTo(convFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
        return convFile;
	}*/
}
