package tw.group4._14_.utils;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.front.model.OrderItemBeanAP;
import tw.group4._14_.front.model.OrderListBeamAP;


public class MailFormat {

	
	public static String mailFormat(Set<Map<String, OrderItemBeanAP>> set, OrderListBeamAP olb) {
		
		String htmlFormatHead = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\r\n" + 
				"    <meta name=\"x-apple-disable-message-reformatting\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"    <meta content=\"telephone=no\" name=\"format-detection\">\r\n" + 
				"    <title></title>\r\n" + 
				"    <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap\" rel=\"stylesheet\">\r\n" + 
				"    <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,500,600,700,900&display=swap\" rel=\"stylesheet\">\r\n" + 
				"</head>";
		
		String htmlFormatBody1 = "<body style=\"width:100%;font-family:tahoma, verdana, segoe, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \r\n" + 
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
				"                      <td class=\"es-infoblock es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:tahoma, verdana, segoe, sans-serif;line-height:14px;color:#CCCCCC\">Put your preheader text here</p></td> \r\n" + 
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
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://oonluu.stripocdn.email/content/guids/48fba385-6c4e-4de0-807d-59b2a1039300/images/91191606806075851.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td> \r\n" + 
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
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\"><img class=\"adapt-img\" src=\"https://oonluu.stripocdn.email/content/guids/CABINET_8ba9362bd94f8450b9cc99d201c33cda/images/59311575451089515.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" bgcolor=\"#ffffff\" style=\"Margin:0;padding-top:5px;padding-left:20px;padding-right:20px;padding-bottom:30px;background-color:#FFFFFF\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"left\" class=\"es-m-p20b\" style=\"padding:0;Margin:0;width:560px\">";
		
		String htmlFormatBody3 ="</td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"           </table></td> \r\n" + 
				"         </tr> \r\n" + 
				"       </table> \r\n" + 
				"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\"> \r\n" + 
				"         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"          <td align=\"center\" bgcolor=\"#1b142d\" style=\"padding:0;Margin:0;background-color:#1B142D\"> \r\n" + 
				"           <table bgcolor=\"#ffffff\" class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#00C4C6;width:600px\"> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding:0;Margin:0;background-color:#FFFFFF\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\"> \r\n" + 
				"                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\"><img class=\"adapt-img\" src=\"https://oonluu.stripocdn.email/content/guids/CABINET_8ba9362bd94f8450b9cc99d201c33cda/images/60441575463377280.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:10px;padding-left:20px;padding-right:20px\"> \r\n" + 
				"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\"> \r\n" + 
				"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px;font-size:0\"> \r\n" + 
				"                       <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><img title=\"Facebook\" src=\"https://oonluu.stripocdn.email/content/assets/img/social-icons/circle-white/facebook-circle-white.png\" alt=\"Fb\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td> \r\n" + 
				"                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><img title=\"Twitter\" src=\"https://oonluu.stripocdn.email/content/assets/img/social-icons/circle-white/twitter-circle-white.png\" alt=\"Tw\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td> \r\n" + 
				"                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><img title=\"Instagram\" src=\"https://oonluu.stripocdn.email/content/assets/img/social-icons/circle-white/instagram-circle-white.png\" alt=\"Inst\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td> \r\n" + 
				"                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0\"><img title=\"Youtube\" src=\"https://oonluu.stripocdn.email/content/assets/img/social-icons/circle-white/youtube-circle-white.png\" alt=\"Yt\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td> \r\n" + 
				"                         </tr> \r\n" + 
				"                       </table></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:tahoma, verdana, segoe, sans-serif;line-height:18px;color:#FFFFFF\">You are receiving this email because you have visited our site or asked us about regular newsletter. Make sure our messages get to your Inbox (and not your bulk or junk folders).</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:tahoma, verdana, segoe, sans-serif;line-height:21px;color:#FFFFFF\">Vector graphics designed by <a target=\"_blank\" href=\"http://www.freepik.com/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:14px;text-decoration:underline;color:#FFFFFF\">Freepik</a>.</p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-top:20px;padding-left:20px;padding-right:20px\"> \r\n" + 
				"               <!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]--> \r\n" + 
				"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:270px\"> \r\n" + 
				"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"left\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0\"><a class=\"unsubscribe\" target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:14px;text-decoration:underline;color:#FFFFFF\">Unsubscribe</a></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table> \r\n" + 
				"               <!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]--> \r\n" + 
				"               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"left\" style=\"padding:0;Margin:0;width:270px\"> \r\n" + 
				"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"right\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:tahoma, verdana, segoe, sans-serif;line-height:21px;color:#FFFFFF\">© All Rights Reserved, 2019</p></td> \r\n" + 
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
				"              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\"> \r\n" + 
				"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\"> \r\n" + 
				"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td class=\"es-infoblock made_with\" align=\"center\" style=\"padding:0;Margin:0;line-height:120%;font-size:0;color:#CCCCCC\"><a target=\"_blank\" href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=gifts_&_flowershand-made&utm_content=christmas_presents\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:12px;text-decoration:underline;color:#CCCCCC\"><img src=\"https://oonluu.stripocdn.email/content/guids/CABINET_9df86e5b6c53dd0319931e2447ed854b/images/64951510234941531.png\" alt width=\"125\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"           </table></td> \r\n" + 
				"         </tr> \r\n" + 
				"       </table></td> \r\n" + 
				"     </tr> \r\n" + 
				"   </table> \r\n" + 
				"  </div>  \r\n" + 
				" </body>\r\n" + 
				"</html>";
		
		String htmlFormatBody2 = "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:5px;padding-top:10px\"><h2 style=\"Margin:0;line-height:30px;mso-line-height-rule:exactly;font-family:Poppins, sans-serif;font-size:25px;font-style:normal;font-weight:bold;color:#00413F\">得藝洋行 感謝您的購買 &lt;3</h2></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:tahoma, verdana, segoe, sans-serif;line-height:23px;color:#333333\">親愛的 " + olb.getMemberID() + "; 您好，</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:tahoma, verdana, segoe, sans-serif;line-height:23px;color:#333333\">本行已收到您於 "+olb.getDate()+"; 訂購的商品明細<br>訂單編號為"+olb.getOrderNoAP()+"<br>請確認下列商品寄送訊息<br>詳細商品清單內容請點選下方連結查看<br>感謝您的支持，祝您有個得藝的一天！<br></p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px\"> \r\n" + 
				"                       <span class=\"msohide es-button-border\" style=\"border-style:solid;border-color:#00C4C6;background:#00C4C6;border-width:0px;display:inline-block;border-radius:5px;width:auto;mso-hide:all\"><a href=\"http://localhost:8080/Art/14/showOrderList.ctrl\" class=\"es-button\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:20px;color:#FFFFFF;border-style:solid;border-color:#00C4C6;border-width:10px 20px 10px 20px;display:inline-block;background:#00C4C6;border-radius:5px;font-weight:normal;font-style:normal;line-height:24px;width:auto;text-align:center\">詳細資訊</a></span> \r\n" + 
				"                      </td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table>";
		
		String htmlFormatBodyContent1 = "<TABLE\r\n" + 
				"                              style=\"margin-left: auto; margin-right: auto; background: #ffffff; border: 1px black solid;\">\r\n" + 
				"                              <tr id='borderA' height='50'>\r\n" + 
				"                                <th id='borderA' align=\"center\" colspan=\"6\">\r\n" + 
				"                                  <h3>訂單明細</h3>\r\n" + 
				"                                </th>\r\n" + 
				"                              </tr>\r\n" + 
				"                              <tr id='borderA' height='36'>\r\n" + 
				"                                <td colspan=\"6\">\r\n" + 
				"                                  <table style=\"text-align: center;\">\r\n" + 
				"                                    <tr id='borderA'>\r\n" + 
				"                                      <td align=\"Left\" width=\"350px\">\r\n" + 
				"                                        <b>出貨地址：</b>"+olb.getAddAP()+"<br>" + 
				"                                      </td>\r\n" + 
				"                                      <td align=\"center\" width=\"300px\">\r\n" + 
				"                                        <b>訂購日期：</b>"+olb.getDate()+"<br>" + 
				"                                      </td>\r\n" + 
				"                                      <td align=\"center\" width=\"280px\">\r\n" + 
				"                                        <b>統一編號：</b>"+olb.getBnoAP()+"<br>" + 
				"                                      </td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                                  </table>\r\n" + 
				"                                </td>\r\n" + 
				"                              </tr>\r\n" + 
				"                              <tr id='borderA' height='36' style=\"text-align: center;\">\r\n" + 
				"                                <th id='borderA' width=\"100px\" align=\"center\">#</th>\r\n" + 
				"                                <th id='borderA' width=\"100px\" align=\"center\">品項</th>\r\n" + 
				"                                <th id='borderA' width=\"70px\" align=\"center\">單價</th>\r\n" + 
				"                                <th id='borderA' width=\"50px\" align=\"center\">數量</th>\r\n" + 
				"                                <th id='borderA' width=\"100px\" align=\"center\">總價</th>\r\n" + 
				"                              </tr>\r\n" + 
				"\r\n" ;
		
		String htmlFormatBodyContent2 =
				"                              <tr height='30'>\r\n" + 
				"                                <TD id='borderA' align=\"center\">&nbsp;</TD>\r\n" + 
				"                                <TD id='borderA' width=\"60px\" align=\"center\" colspan=\"2\"><b>合 計</b></TD>\r\n" + 
				"                                <TD id='borderA' width=\"100px\" align=\"right\" colspan=\"2\">\r\n" + 
				"                            </TABLE>";
		
		
		String htmlContent = "";
		
		
		Iterator<Map<String, OrderItemBeanAP>> iterator = set.iterator();
		int num = 0;
		while(iterator.hasNext()) {
			Map<String, OrderItemBeanAP> map = iterator.next();
			Set<String> keySet = map.keySet();
			
				for (String str : keySet) {
				
//					Object next = iter.next();
					
//					OrderItemBeanAP value = (OrderItemBeanAP) map.get(next);
					htmlContent+="<tr bgColor='FFFFFF' height='30'>" + 
//							"<td align='center'>"+map.get("name")+"</td>" +
//							"<td align='center'>"+value.getOrderIdAP()+"</td>" +
							"<td align='center'>"+map.get(str).getOrderIdAP()+"</td>" +
							"<td align='center'>"+map.get(str).getOrderNameAP()+"</td>" +
							"<td align='center'>"+map.get(str).getProductPrice()+"</td>" +
							"<td align='center'>"+map.get(str).getProductNum()+"</td>" +
							"<td align='center'>"+(map.get(str).getProductNum())*(Integer.parseInt(map.get(str).getProductPrice()))+"</td>";
					num+=(map.get(str).getProductNum())*(Integer.parseInt(map.get(str).getProductPrice()));
		
				}
				
			htmlContent += "<td align='center'>"+num+"</td></tr>";
		}
		
		return htmlFormatHead+htmlFormatBody1+htmlFormatBody2+htmlFormatBodyContent1+htmlContent+htmlFormatBodyContent2+htmlFormatBody3;
	}
	
	
	public static Set<Map<String, OrderItemBeanAP>> mailList(OrderListBeamAP olb) {
		
		Set<OrderItemBeanAP> items = olb.getItems();

//		Set<Map<String, Object>> set = new HashSet<Map<String,Object>>();
		Set<Map<String, OrderItemBeanAP>> set = new HashSet<Map<String,OrderItemBeanAP>>();
		for (OrderItemBeanAP ap : items) {
			Map<String, OrderItemBeanAP> map = new HashedMap();
			map.put(Integer.toString(ap.getOrderIdAP()), ap);
//			map.put("name", map.get("name"));
//			map.put("name", ap.getOrderNameAP());
//			map.put("price", ap.getProductPrice());
//			map.put("number", ap.getProductNum());
//			map.put("tolPrice", ap.getProductNum()*Integer.parseInt(ap.getProductPrice()));
			set.add(map);
			
		}
		return set;
	}
}
