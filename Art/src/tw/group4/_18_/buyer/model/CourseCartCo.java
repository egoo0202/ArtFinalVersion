package tw.group4._18_.buyer.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CourseCartCo {

	private Map<String, CourseFront> cart = new LinkedHashMap<>();
	
	public CourseCartCo() {

	}
	
	public Map<String, CourseFront> getCartCo() {
		return cart;
	}

	// 購物車屬性
	// 購物項集合:Map<K,V>的Key=商品coId，Value=購物項

	// 1. 將購物項目添加到購物車

	public void addToCoCart(String coId, CourseFront co) {
		if (co.getCoNum() <= 0) {
			return;
		}
		// 顧客未點選購買的商品，顧客的購物車是空的
		if (cart.get(coId) == null) {
			cart.put(coId, co);
		} else {
			CourseFront coCI = cart.get(coId);
			coCI.setCoNum(co.getCoNum() + coCI.getCoNum());
		}
	}

	// 2.修改數量
	public boolean updateQuantity(String coId, int newQuantity) {
		System.out.println(coId);
		System.out.println(cart);
		System.out.println(cart.get(coId));
		System.out.println(newQuantity);

		if (cart.get(coId) != null) {
			CourseFront co = cart.get(coId);
			co.setCoNum(newQuantity);

			return true;
		} else {
			System.out.println("修改方法中的productID=" + coId);
			System.out.println("修改方法錯誤，newQty=" + newQuantity + "__ cart.get(coId)= " + cart.get(coId));
			return false;
		}
	}

	// 3.將購物項目刪除
	public int deleteCart(String coId) {
		System.out.println("前往刪除課程");
		if (cart.get(coId) != null) {
			System.out.println("找到目標課程");
			cart.remove(coId);
			return 1;
		} else {
			System.out.println("未找到目標課程");
			return 0;
		}
	}

	// 4.購物總計
	public int getTotal() {
		int total = 0;
		Set<String> set = cart.keySet();
		for (String n : set) {
//			int price = Integer.parseInt(cart.get(n).getCoPrice());
			int price = cart.get(n).getCoPrice();
			int quantity = cart.get(n).getCoNum();
			total += price * quantity;
		}
		return total;
	}

	

	
	
	
}
