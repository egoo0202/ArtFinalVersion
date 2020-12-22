package tw.group4._35_.login.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class JavaMail {
	// ---------------------------------------------------------基本資料

	private String userName = "aaartgroup4@gmail.com"; // 寄件者信箱
	private String password = "aaart1225"; // 寄件者密碼
//		private String email = ""; // 收件者郵箱
	private String subject = "歡迎加入得藝的一天"; // 標題
	private String mailTemplateP1 = 
				"\r\n" + 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;font-family:tahoma, verdana, segoe, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\r\n" + 
				" <head> \r\n" + 
				"  <meta charset=\"UTF-8\"> \r\n" + 
				"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \r\n" + 
				"  <meta name=\"x-apple-disable-message-reformatting\"> \r\n" + 
				"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \r\n" + 
				"  <meta content=\"telephone=no\" name=\"format-detection\"> \r\n" + 
				"  <title>demo_4c132af2-bbd7-4992-acd7-bead23af7d5e</title> \r\n" + 
				"  <!--[if (mso 16)]>\r\n" + 
				"    <style type=\"text/css\">\r\n" + 
				"    a {text-decoration: none;}\r\n" + 
				"    </style>\r\n" + 
				"    <![endif]--> \r\n" + 
				"  <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--> \r\n" + 
				"  <!--[if !mso]><!-- --> \r\n" + 
				"  <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap\" rel=\"stylesheet\"> \r\n" + 
				"  <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,500,600,700,900&display=swap\" rel=\"stylesheet\"> \r\n" + 
				"  <!--<![endif]--> \r\n" + 
				"  <!--[if gte mso 9]>\r\n" + 
				"<xml>\r\n" + 
				"    <o:OfficeDocumentSettings>\r\n" + 
				"    <o:AllowPNG></o:AllowPNG>\r\n" + 
				"    <o:PixelsPerInch>96</o:PixelsPerInch>\r\n" + 
				"    </o:OfficeDocumentSettings>\r\n" + 
				"</xml>\r\n" + 
				"<![endif]--> \r\n" + 
				"  <style type=\"text/css\">\r\n" + 
				"#outlook a {\r\n" + 
				"	padding:0;\r\n" + 
				"}\r\n" + 
				".ExternalClass {\r\n" + 
				"	width:100%;\r\n" + 
				"}\r\n" + 
				".ExternalClass,\r\n" + 
				".ExternalClass p,\r\n" + 
				".ExternalClass span,\r\n" + 
				".ExternalClass font,\r\n" + 
				".ExternalClass td,\r\n" + 
				".ExternalClass div {\r\n" + 
				"	line-height:100%;\r\n" + 
				"}\r\n" + 
				".es-button {\r\n" + 
				"	mso-style-priority:100!important;\r\n" + 
				"	text-decoration:none!important;\r\n" + 
				"}\r\n" + 
				"a[x-apple-data-detectors] {\r\n" + 
				"	color:inherit!important;\r\n" + 
				"	text-decoration:none!important;\r\n" + 
				"	font-size:inherit!important;\r\n" + 
				"	font-family:inherit!important;\r\n" + 
				"	font-weight:inherit!important;\r\n" + 
				"	line-height:inherit!important;\r\n" + 
				"}\r\n" + 
				".es-desk-hidden {\r\n" + 
				"	display:none;\r\n" + 
				"	float:left;\r\n" + 
				"	overflow:hidden;\r\n" + 
				"	width:0;\r\n" + 
				"	max-height:0;\r\n" + 
				"	line-height:0;\r\n" + 
				"	mso-hide:all;\r\n" + 
				"}\r\n" + 
				".es-button-border:hover {\r\n" + 
				"	border-color:#00f5f9 #00f5f9 #00f5f9 #00f5f9!important;\r\n" + 
				"	background:#065C66!important;\r\n" + 
				"}\r\n" + 
				"@media only screen and (max-width:600px) {p, ul li, ol li, a { font-size:14px!important; line-height:150%!important } h1 { font-size:28px!important; text-align:center; line-height:120%!important } h2 { font-size:24px!important; text-align:center; line-height:120%!important } h3 { font-size:18px!important; text-align:center; line-height:120%!important } h1 a { font-size:28px!important } h2 a { font-size:24px!important } h3 a { font-size:18px!important } .es-menu td a { font-size:12px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:13px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:11px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:11px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } a.es-button, button.es-button { font-size:16px!important; display:inline-block!important } }\r\n" + 
				"</style> \r\n" + 
				" </head> \r\n" + 
				" <body style=\"width:100%;font-family:tahoma, verdana, segoe, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \r\n" + 
				"  <div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\"> \r\n" + 
				"   <!--[if gte mso 9]>\r\n" + 
				"			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\r\n" + 
				"				<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\r\n" + 
				"			</v:background>\r\n" + 
				"		<![endif]--> \r\n" + 
				"   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\"> \r\n" + 
				"     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"      <td valign=\"top\" style=\"padding:0;Margin:0\"> \r\n" + 
				"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \r\n" + 
				"         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"          <td class=\"es-adaptive\" align=\"center\" bgcolor=\"#1b142d\" style=\"padding:0;Margin:0;background-color:#1B142D\"> \r\n" + 
				"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:10px;Margin:0\"> \r\n" + 
				"               <!--[if mso]><table style=\"width:580px\"><tr><td style=\"width:280px\" valign=\"top\"><![endif]--> \r\n" + 
				"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"left\" style=\"padding:0;Margin:0;width:280px\"> \r\n" + 
				"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td class=\"es-infoblock es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:tahoma, verdana, segoe, sans-serif;line-height:14px;color:#CCCCCC\">Welcome to AAART!</p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table> \r\n" + 
				"               <!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:280px\" valign=\"top\"><![endif]--> \r\n" + 
				"               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"left\" style=\"padding:0;Margin:0;width:280px\"> \r\n" + 
				"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"right\" class=\"es-infoblock es-m-txt-c\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:tahoma, verdana, segoe, sans-serif;line-height:14px;color:#CCCCCC\"><a href=\"https://viewstripo.email/\" target=\"_blank\" class=\"view\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:12px;text-decoration:underline;color:#CCCCCC\">View in browser</a></p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table> \r\n" + 
				"               <!--[if mso]></td></tr></table><![endif]--></td> \r\n" + 
				"             </tr> \r\n" + 
				"           </table></td> \r\n" + 
				"         </tr> \r\n" + 
				"       </table> \r\n" + 
				"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \r\n" + 
				"         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"          <td align=\"center\" bgcolor=\"#1b142d\" style=\"padding:0;Margin:0;background-color:#1B142D\"> \r\n" + 
				"           <table bgcolor=\"transparent\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:0;Margin:0\"> \r\n" + 
				"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\"> \r\n" + 
				"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><a target=\"_blank\" href=\"http://localhost:8080/Art/index.html\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:15px;text-decoration:underline;color:#2CB543\"><img class=\"adapt-img\" src=\"https://noonma.stripocdn.email/content/guids/4c132af2-bbd7-4992-acd7-bead23af7d5e/images/68781606795675739.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:0;Margin:0\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\"> \r\n" + 
				"                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\"><img class=\"adapt-img\" src=\"https://noonma.stripocdn.email/content/guids/CABINET_8ba9362bd94f8450b9cc99d201c33cda/images/59311575451089515.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" bgcolor=\"#ffffff\" style=\"Margin:0;padding-top:5px;padding-left:20px;padding-right:20px;padding-bottom:30px;background-color:#FFFFFF\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"left\" class=\"es-m-p20b\" style=\"padding:0;Margin:0;width:560px\"> \r\n" + 
				"                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:5px;padding-top:10px\"><h2 style=\"Margin:0;line-height:30px;mso-line-height-rule:exactly;font-family:Poppins, sans-serif;font-size:25px;font-style:normal;font-weight:bold;color:#00413F\">";

	private String mailTemplateP2 = "                     </tr> \r\n"
			+ "                     <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px\"> \r\n"
			+ "                       <!--[if mso]><a href=\"https://viewstripo.email/\" target=\"_blank\">\r\n"
			+ "	<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" stripoVmlButton href=\"http://localhost:8080/Art/index.html/\" \r\n"
			+ "                style=\"height:49px;v-text-anchor:middle;width:160px;\" arcsize=\"10%\" stroke=\"f\" fillcolor=\"#00c4c6\">\r\n"
			+ "		<w:anchorlock></w:anchorlock>\r\n"
			+ "		<center style='color:#ffffff;font-family:arial, \"helvetica neue\", helvetica, sans-serif;font-size:18px;font-weight:400;'>即將迎來美好的一天</center>\r\n"
			+ "	</v:roundrect></a>\r\n" + "<![endif]--> \r\n"
			+ "                       <!--[if !mso]><!-- --><span class=\"msohide es-button-border\" style=\"border-style:solid;border-color:#00C4C6;background:#00C4C6;border-width:0px;display:inline-block;border-radius:5px;width:auto;mso-hide:all\"><a href=\""
			+ ""
			+ "\" class=\"es-button\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:20px;color:#FFFFFF;border-style:solid;border-color:#00C4C6;border-width:10px 20px 10px 20px;display:inline-block;background:#00C4C6;border-radius:5px;font-weight:normal;font-style:normal;line-height:24px;width:auto;text-align:center\">即將迎來美好的一天</a></span> \r\n"
			+ "                       <!--<![endif]--></td> \r\n" + "                     </tr> \r\n"
			+ "                   </table></td> \r\n" + "                 </tr> \r\n"
			+ "               </table></td> \r\n" + "             </tr> \r\n" + "           </table></td> \r\n"
			+ "         </tr> \r\n" + "       </table> \r\n"
			+ "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\"> \r\n"
			+ "         <tr style=\"border-collapse:collapse\"> \r\n"
			+ "          <td align=\"center\" bgcolor=\"#1b142d\" style=\"padding:0;Margin:0;background-color:#1B142D\"> \r\n"
			+ "           <table bgcolor=\"#ffffff\" class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#00C4C6;width:600px\"> \r\n"
			+ "             <tr style=\"border-collapse:collapse\"> \r\n"
			+ "              <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding:0;Margin:0;background-color:#FFFFFF\"> \r\n"
			+ "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n"
			+ "                 <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\"> \r\n"
			+ "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n"
			+ "                     <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\"><img class=\"adapt-img\" src=\"https://noonma.stripocdn.email/content/guids/CABINET_8ba9362bd94f8450b9cc99d201c33cda/images/60441575463377280.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td> \r\n"
			+ "                     </tr> \r\n" + "                   </table></td> \r\n"
			+ "                 </tr> \r\n" + "               </table></td> \r\n" + "             </tr> \r\n"
			+ "             <tr style=\"border-collapse:collapse\"> \r\n"
			+ "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:10px;padding-left:20px;padding-right:20px\"> \r\n"
			+ "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n"
			+ "                 <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\"> \r\n"
			+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n"
			+ "                     <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px;font-size:0\"> \r\n"
			+ "                       <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n"
			+ "                         <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><img title=\"Facebook\" src=\"https://noonma.stripocdn.email/content/assets/img/social-icons/circle-white/facebook-circle-white.png\" alt=\"Fb\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td> \r\n"
			+ "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><img title=\"Twitter\" src=\"https://noonma.stripocdn.email/content/assets/img/social-icons/circle-white/twitter-circle-white.png\" alt=\"Tw\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td> \r\n"
			+ "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><img title=\"Instagram\" src=\"https://noonma.stripocdn.email/content/assets/img/social-icons/circle-white/instagram-circle-white.png\" alt=\"Inst\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td> \r\n"
			+ "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0\"><img title=\"Youtube\" src=\"https://noonma.stripocdn.email/content/assets/img/social-icons/circle-white/youtube-circle-white.png\" alt=\"Yt\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td> \r\n"
			+ "                         </tr> \r\n" + "                       </table></td> \r\n"
			+ "                     </tr> \r\n" + "                     <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:tahoma, verdana, segoe, sans-serif;line-height:18px;color:#FFFFFF\">You are receiving this email because you have visited our site or asked us about regular newsletter. Make sure our messages get to your Inbox (and not your bulk or junk folders).</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:tahoma, verdana, segoe, sans-serif;line-height:21px;color:#FFFFFF\">Vector graphics designed by <a target=\"_blank\" href=\"http://www.freepik.com/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:14px;text-decoration:underline;color:#FFFFFF\">Freepik</a>.</p></td> \r\n"
			+ "                     </tr> \r\n" + "                   </table></td> \r\n"
			+ "                 </tr> \r\n" + "               </table></td> \r\n" + "             </tr> \r\n"
			+ "             <tr style=\"border-collapse:collapse\"> \r\n"
			+ "              <td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-top:20px;padding-left:20px;padding-right:20px\"> \r\n"
			+ "               <!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]--> \r\n"
			+ "               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\"> \r\n"
			+ "                 <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:270px\"> \r\n"
			+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n"
			+ "                     <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                      <td align=\"left\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0\"><a class=\"unsubscribe\" target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:14px;text-decoration:underline;color:#FFFFFF\">Unsubscribe</a></td> \r\n"
			+ "                     </tr> \r\n" + "                   </table></td> \r\n"
			+ "                 </tr> \r\n" + "               </table> \r\n"
			+ "               <!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]--> \r\n"
			+ "               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\"> \r\n"
			+ "                 <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                  <td align=\"left\" style=\"padding:0;Margin:0;width:270px\"> \r\n"
			+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n"
			+ "                     <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                      <td align=\"right\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:tahoma, verdana, segoe, sans-serif;line-height:21px;color:#FFFFFF\">© All Rights Reserved, 2019</p></td> \r\n"
			+ "                     </tr> \r\n" + "                   </table></td> \r\n"
			+ "                 </tr> \r\n" + "               </table> \r\n"
			+ "               <!--[if mso]></td></tr></table><![endif]--></td> \r\n" + "             </tr> \r\n"
			+ "           </table></td> \r\n" + "         </tr> \r\n" + "       </table> \r\n"
			+ "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \r\n"
			+ "         <tr style=\"border-collapse:collapse\"> \r\n"
			+ "          <td align=\"center\" bgcolor=\"#1b142d\" style=\"padding:0;Margin:0;background-color:#1B142D\"> \r\n"
			+ "           <table bgcolor=\"transparent\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"> \r\n"
			+ "             <tr style=\"border-collapse:collapse\"> \r\n"
			+ "              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\"> \r\n"
			+ "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n"
			+ "                 <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\"> \r\n"
			+ "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n"
			+ "                     <tr style=\"border-collapse:collapse\"> \r\n"
			+ "                      <td class=\"es-infoblock made_with\" align=\"center\" style=\"padding:0;Margin:0;line-height:120%;font-size:0;color:#CCCCCC\"><a target=\"_blank\" href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=gifts_&_flowershand-made&utm_content=christmas_presents\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:12px;text-decoration:underline;color:#CCCCCC\"><img src=\"https://noonma.stripocdn.email/content/guids/CABINET_9df86e5b6c53dd0319931e2447ed854b/images/64951510234941531.png\" alt width=\"125\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \r\n"
			+ "                     </tr> \r\n" + "                   </table></td> \r\n"
			+ "                 </tr> \r\n" + "               </table></td> \r\n" + "             </tr> \r\n"
			+ "           </table></td> \r\n" + "         </tr> \r\n" + "       </table></td> \r\n" + "     </tr> \r\n"
			+ "   </table> \r\n" + "  </div>  \r\n" + " </body>\r\n" + "</html>";
//		private String txt = "<h1>郵件內容</h1><h2>文字內容</h2>"; // 內容

	public void SendMail(String email, String authUrl) {
		// ---------------------------------------------------------連線設定
		Properties prop = new Properties();

		// 設定連線為smtp
		prop.setProperty("mail.transport.protocol", "smtp");

		// host主機:smtp.gmail.com
		prop.setProperty("mail.host", "smtp.gmail.com");

		// host port:465
		prop.put("mail.smtp.port", "465");

		// 寄件者帳號需要驗證：是
		prop.put("mail.smtp.auth", "true");

		// 需要安全資料傳輸層 (SSL)：是
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// 安全資料傳輸層 (SSL) 通訊埠：465
		prop.put("mail.smtp.socketFactory.port", "465");

		// 顯示連線資訊
		prop.put("mail.debug", "true");

		// ---------------------------------------------------------驗證
		// ---------------------------------------------------------Session默認屬性設定值
		// 匿名類別
//			Session session = Session.getDefaultInstance(prop, new Authenticator() {
		//
//				@Override
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(userName, password);
//				}
//			});

		// class
		Auth auth = new Auth(userName, password);
		Session session = Session.getDefaultInstance(prop, auth);

		// ---------------------------------------------------------Message郵件格式
		MimeMessage message = new MimeMessage(session);

		try {
			// 寄件者
			// 匿名類別
			// message.setSender(new InternetAddress(userName));

			// class
			InternetAddress sender = new InternetAddress(userName);
			message.setSender(sender);

			// 收件者
			message.setRecipient(RecipientType.TO, new InternetAddress(email));

			// 標題
			message.setSubject(subject);

			// 內容/格式
			message.setContent(mailTemplateP1+authUrl+mailTemplateP2, "text/html;charset = UTF-8");

			// ---------------------------------------------------------Transport傳送Message
			Transport transport = session.getTransport();

			// transport將message送出
			transport.send(message);

			// 關閉Transport
			transport.close();

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Auth extends Authenticator {

	private String userName;
	private String password;

	public Auth(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication(userName, password);
		return pa;
	}

}
