package tw.group4._04_.front.test;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class radomTEST {
	public static void main(String[] args) {
		List<String> seatlistList = new ArrayList();
		int ticketnum = 4;
		for (int j = 0; j < ticketnum; j++) {

			// 亂數A~E
			char Alphabet = (char) (int) (Math.random() * 1 + 65);
			Random random = new Random();
			// 亂數1~10
			String num = "";
			for (int i = 1; i < 2; i++) {
				num += random.nextInt(10) + 1;
			}

			String radomString = Alphabet + num;
			System.out.println(radomString);
			Integer seattpye = null;
			System.out.println("seattpye" + seattpye);



			if (seattpye != null ) {
				ticketnum = ticketnum + 1;
				System.out.println("座位已劃位");
				
			}else if (seatlistList.contains(radomString)) {
				ticketnum = ticketnum + 1;
				System.out.println("座位已重複");
			}
			else {
				// 重新選座位
				seatlistList.add(radomString);
				System.out.println(seatlistList.size());
			}

		}

	}
}
