package tw.group4._04_.front.test;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hpsf.Array;
import org.springframework.ui.Model;

import com.google.common.base.Ticker;

import tw.group4._04_.front.shopcart.model.Shoppingcart;

public class arraytest {

	public static void main(String[] args) {
		String[] seats2 = {};
		List<String> seatlist = new ArrayList<String>();
		int num =3;
		String[] seats = { "A1", "A2",  "A4" };
		if (num == 4) {
		String seatA=seats[0];
		String seatB=seats[1];
		String seatC=seats[2];
		String seatD=seats[3];
		}else if (num == 3) {
			String seatA=seats[0];
			String seatB=seats[1];
			String seatC=seats[2];
		}else if (num == 2) {
			String seatA=seats[0];
			String seatB=seats[1];
			
		}else {
			String seatA=seats[0];
					
		}
		
		
		//		try {
//			System.out.println(seats[0]);
//			System.out.println(seats[1]);
//			System.out.println(seats[2]);
//			System.out.println(seats[3]);
//			
//		} catch (ArrayIndexOutOfBoundsException e) {
//			// TODO: handle exception
//		}
		String a =null;
		for (String s : seats) {
			
				System.out.println(s);
				a =s;
			}
		
		System.out.println(a);
		}
//
//		for (String s : seatlist) {
//
//			System.out.println("s2" + 2);
//		}
//		seats2 = new String[seatlist.size()];
//		seatlist.toArray(seats2);
//
//		for (String s3 : seats2) {
//			System.out.println("s3" + s3);
//		}
		
		
	

}
