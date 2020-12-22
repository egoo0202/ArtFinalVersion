package tw.group4._14_.init;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

public class ImageProcess {
	public static Blob fileToBlob(String imageFileName) throws IOException, SQLException {
		File imageFile = new File(imageFileName);
		long size = imageFile.length();
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		try (FileInputStream fis = new FileInputStream(imageFile);) {
			fis.read(b);
			sb = new SerialBlob(b);
		}
		return sb;
	}
	public static byte[] fileToByte(String imageFileName) throws IOException, SQLException {
		File imageFile = new File(imageFileName);
		long size = imageFile.length();
		byte[] b = new byte[(int) size];
		byte[] rs;
		try (
//				FileInputStream fis = new FileInputStream(imageFile);
				ByteArrayInputStream in = new ByteArrayInputStream(b);) {
//			fis.read(b);
		
			rs = in.readAllBytes();
			
		}
		return rs;
	}
	public static void writeFile(String destPath, byte[] file) throws IOException{
		OutputStream out = null;
		try {
			out = new FileOutputStream(destPath);
			out.write(file);
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null) out.close();
		}
	}
	

}
