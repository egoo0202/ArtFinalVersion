package tw.group4._11_.model;

import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tw.group4._04_.front.javaMail.model.EmailServiceImpl;
@Service
public class SentMailService {
	@Autowired
	private JavaMailSender eMailSender;
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	public void processSendMailSA(DonateRecordBean drb) throws MessagingException {
		
		MailSet mailSet = new MailSet();
		Set<Map<String, DonateRecordBean>> mailSetting = mailSet.mailListSA(drb);
		String content = mailSet.mailSet(mailSetting, drb);
		
		// 寄訂單詳細mail
		String to = "aaartgroup4@gmail.com";
		String subject = "AAART 贊助藝人 單號" + drb.getId_donation() ;
		String text = "親愛的" + drb.getName_SA() + "先生／小姐，您好!" + "\n\r" + "感謝您於本系統贊助藝人。" + "\n\r" + "訂單編號："
				+ drb.getId_donation() + "\n\r" + "贊助人姓名：" + drb.getName_user() + "\n\r" + "電子郵件："
				+ "aaartgroup4@gmail.com" + "\n\r" +  "\n\r" + "訂單明細：\n\r" ;
		
		
		

		emailServiceImpl.sendMessageWithAttachment(to, subject, content);
		System.out.println("mail已寄送");
	}
}
