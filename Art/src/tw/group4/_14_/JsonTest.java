package tw.group4._14_;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;

import tw.group4._14_.back.ARTProduct;

public class JsonTest {
	public static void main(String[] args) {

		ARTProduct artProduct = new ARTProduct();
		ARTProduct artProduct2 = new ARTProduct();
		
		ArrayList<ARTProduct> arrayList = new ArrayList<ARTProduct>();
		
		artProduct.setProductId("30");
		artProduct.setProductNum(20);
		artProduct.setProductType("1236");
		artProduct.setProductTitle("Something");
		
		artProduct2.setProductId("320");
		artProduct2.setProductNum(20);
		artProduct2.setProductType("12236");
		artProduct2.setProductTitle("222Something");
		
		
		arrayList.add(artProduct);
		arrayList.add(artProduct2);
		
		Gson gson = new Gson();

		String json = gson.toJson(arrayList);

		System.out.println(json);
	}

}
