package tw.group4.config.viewResolver;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import tw.group4._35_.login.model.WebsiteMember;

public class PdfView extends AbstractPdfView {
	
	public static final String FONT = "/WEB-INF/IOFiles/fonts/NotoSansCJKsc-Regular.otf";

//	public static final String CHINESE = "\u5341\u950a\u57cb\u4f0f";
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PdfPTable table = new PdfPTable(7);

		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.getDefaultCell().setBackgroundColor(Color.white);
		table.getDefaultCell().setMinimumHeight((float) 75.0);
		table.getDefaultCell().setBorderWidth((float) 1.5);
		
		table.addCell("ID");
		table.addCell("NAME");
//		中文字體輸出問題，暫時擱置
//		table.addCell("REALNAME");
		table.addCell("E-MAIL");
		table.addCell("TEL");
		table.addCell("PREF.");
		table.addCell("REGIS.");
		table.addCell("PURCH.");
		
		List<WebsiteMember> list = (List<WebsiteMember>)model.get("memberOutput");
		String realPath = request.getServletContext().getRealPath(FONT);
		
		for (WebsiteMember item: list) {

			table.addCell(String.valueOf(item.getId()));
			table.addCell(item.getName());
			table.addCell(item.getEmail());
			table.addCell(item.getTel());
			table.addCell(item.getPreference());
			table.addCell(String.valueOf(item.getRegisterTime()));
			table.addCell(String.valueOf(item.getPurchaseLimit()));
		}

	    document.open();
	    document.add(table);
		document.close();

	}

}
