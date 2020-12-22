package tw.group4._04_.back;

import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

public class BlobInsert {

	public static void main(String[] args) {
		Blob blob1 = null;
		Blob blob2 = null;
		  try {
		//   先輸入為BufferedImage (image)
		   FileInputStream fis1 = new FileInputStream("./IOFiles/inputJPG/music.jpg");
		   FileInputStream fis2 = new FileInputStream("./IOFiles/inputJPG/bill.jpg");
		   BufferedImage image1 = ImageIO.read(fis1);
		   BufferedImage image2 = ImageIO.read(fis2);
		//   再把BufferedImage轉為ByteArrayOutputStream (baos)
		   ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
		   ImageIO.write(image1, "jpeg", baos1);
		   ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		   ImageIO.write(image2, "jpeg", baos2);
		//   ByteArrayOutputStream轉ByteArray (ba)
		   byte[] ba1 = baos1.toByteArray();
		   byte[] ba2 = baos2.toByteArray();
//		    convert Byte array to Blob using SerialBlob() method
		   blob1 = new SerialBlob(ba1);
		   blob2 = new SerialBlob(ba2);
		   	System.out.println(blob1);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }

	}

}
