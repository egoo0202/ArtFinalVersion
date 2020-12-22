package tw.group4._14_.front.model;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import tw.group4._14_.back.ARTProduct;

public class ShoppingCartAP {
	private Map<String, ARTProduct> cart =  new LinkedHashMap< >();
	
public ShoppingCartAP() {
		
	}
	
	public Map<String, ARTProduct> getCartAP() {
		return cart;
	}

	public void addToCarAP (String productID, ARTProduct pd) {
		if(pd.getProductNum() <= 0) {
			return;
		}
		//判斷顧客是第一次購買此商品或加購商品
		if (cart.get(productID) == null) {
			cart.put(productID, pd);
		}else {
			ARTProduct pdSet =cart.get(productID);
			pdSet.setProductNum(pd.getProductNum() +pdSet.getProductNum() );
		}
	}
	

	public boolean modifyQty(String productID, int newQty) {
		System.out.println(productID);
		System.out.println(cart);
		System.out.println(cart.get(productID));
		System.out.println(newQty);
		if ( cart.get(productID) != null ) {
			ARTProduct  pd = cart.get(productID);
		   pd.setProductNum(newQty);

		   System.out.println("修改方法中的productID= "+productID);
		   System.out.println("修改方法中的newQty= "+newQty);

		   return true;
		} else {
			System.out.println("修改方法中的productID="+productID);
			System.out.println("修改方法錯誤，newQty="+newQty+"__ cart.get(productID)= "+cart.get(productID));
		   return false;
		   
		}
	}
	
	
	public int deleteProduct(String productID) {
		System.out.println("進入刪除方法");
		if ( cart.get(productID) != null ) {
			System.out.println("找到刪除物件");
	       cart.remove(productID);  // Map介面的remove()方法
	       return 1;
		} else {
			System.out.println("找不到刪除物件");
		   return 0;
		}
	}
	
	
	public int getSubtotal(){
		int subTotal = 0 ;
		Set<String> set = cart.keySet();
		for(String n : set){
			int price = Integer.parseInt(cart.get(n).getProductPrice());
			int qty = cart.get(n).getProductNum();
			subTotal +=  price * qty;
		}
		return subTotal;
	}
	

}
