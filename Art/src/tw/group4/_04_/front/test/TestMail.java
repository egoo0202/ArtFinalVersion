package tw.group4._04_.front.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import javax.mail.MessagingException;

import org.apache.commons.codec.binary.Base64;

import tw.group4._04_.front.javaMail.model.EmailServiceImpl;

public class TestMail {

	public static void main(String[] args) throws MessagingException, IOException {
	
//	File file = new File("./IOFiles/inputJPG/activityImage/class_music.jpg"); 	  					
//	InputStream fin = new FileInputStream(file); 
//	byte[] bytes = new byte[fin.available()];
//	String base64 = Base64.encodeBase64String(bytes);
    
	EmailServiceImpl emailServiceImpl =new EmailServiceImpl();
	String to = "benny199312@hotmail.com";
	String subject = "附件測試";
	String text ="測試測試";	
	String pathToAttachment = "./Test.png";
	File file1 = new File("./Test.png");	
	System.out.println(file1.exists()); // true	
	emailServiceImpl.sendMessageWithAttachmentTEST(to, subject, text, pathToAttachment);
	System.out.println("已寄送");
	}
	
	

}
