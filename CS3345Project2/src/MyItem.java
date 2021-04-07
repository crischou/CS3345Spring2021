//Cris Chou
//CYC180001

import java.util.*;



public class MyItem implements IDedObject{
	
	//variables
	private int itemID;
	private int itemPrice;
	private List<Integer>itemDescription;
	
	public MyItem (int id, int price, List<Integer> itemDescription) {
		
		itemID = id;
		itemPrice = price;
		this.itemDescription = itemDescription;
		
	}
	
	
	
	public int getID() {
		
		return itemID;
	}
	
	public String printID() {
		
		String line = "";
		Iterator iterator =  itemDescription.listIterator();
		
		while(iterator.hasNext()) {
			line += iterator.next()+ " ";
		}
		
		
		return itemID +" "+ itemPrice  +" "+ line ;
	}

}
