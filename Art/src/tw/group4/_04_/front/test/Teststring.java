package tw.group4._04_.front.test;

public class Teststring {

	public static void main(String[] args) {
		 StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			buf.append(i);
		}
		System.out.println(buf);
	}

}
