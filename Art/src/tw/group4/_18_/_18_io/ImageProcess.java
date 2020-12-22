package tw.group4._18_._18_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

public class ImageProcess {
	
//	public static byte[] fileToByte(String imageFileName) throws IOException, SQLException {
//		File imageFile = new File(imageFileName);
//		long size = imageFile.length();
//		byte[] b = new byte[(int) size];
//		byte[] rs;
//		try (
////				FileInputStream fis = new FileInputStream(imageFile);
//				ByteArrayInputStream in = new ByteArrayInputStream(b);) {
////			fis.read(b);
//		
//			rs = in.readAllBytes();
//			
//		}
//		return rs;
//	}
	
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

}
