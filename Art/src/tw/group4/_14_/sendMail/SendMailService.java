package tw.group4._14_.sendMail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import tw.group4._04_.front.javaMail.model.EmailServiceImpl;
import tw.group4._14_.front.model.OrderItemBeanAP;
import tw.group4._14_.front.model.OrderListBeamAP;
import tw.group4._14_.utils.MailFormat;

@Service
public class SendMailService {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private EmailServiceImpl emailServiceImpl;

	public void processSendMailAP(OrderListBeamAP olb) throws MessagingException {
		
		MailFormat mailFormat = new MailFormat();
		Set<Map<String, OrderItemBeanAP>> mailSet = mailFormat.mailList(olb);
		String content = mailFormat.mailFormat(mailSet, olb);
		
		// 寄訂單詳細mail
		String to = olb.getEmail();
		String subject = "AAART 得藝洋行 訂單編號" + olb.getOrderNoAP() + "購物明細";
		String text = "親愛的" + olb.getMemberID() + "先生／小姐，您好!" + "\n\r" + "感謝您於得藝的一天購物。" + "\n\r" + "訂單編號："
				+ olb.getOrderNoAP() + "\n\r" + "訂購人姓名：" + olb.getMemberID() + "\n\r" + "電子郵件："
				+ olb.getEmail() + "\n\r" + "電話：" + olb.getAddAP()+ "\n\r" + "地址："
				+ olb.getAddAP() + "\n\r" + "訂單明細：\n\r" ;
		
		
		

		emailServiceImpl.sendMessageWithAttachment(to, subject, content);
		System.out.println("mail已寄送");
	}

}
