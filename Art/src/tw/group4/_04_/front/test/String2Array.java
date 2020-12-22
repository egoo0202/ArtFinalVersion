package tw.group4._04_.front.test;

public class String2Array {

	public static void main(String[] args) {

		String arraystring="[A1,A2,A3,A4]";
		
		
		 // 將剛剛輸出之 array string 先作去頭去尾處理
	        // 並用 split 來分開各個項目
		         String[] items = arraystring.replaceAll("\\[", "")
		                 .replaceAll("\\]", "").split(",");
		        
		        // items.length 是所有項目的個數
		        String[] results = new String[items.length];
		        
		    	for (String s : items) {
					
					System.out.println(s);

				}
		
		         // 將結果放入 results，
		         // 並利用 Integer.parseInt 來將整數字串轉換為 int
		         for (int i = 0; i < items.length; i++) {
		             results[i] = items[i].trim();
		         }
	 
		        // 此時已將字串轉換至 results 中，
		        // 但為了檢查，我們還是要把 results 印出來。
		        // 輸出結果：4, 2, 5, 1, 5, 2, 4, 3, 
		         for (String element : results) {
		             System.out.print(element);
		         }
		     }
	

}
