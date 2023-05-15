package stock;

import java.util.Scanner;

public interface StockInput {
	
	public int getId();
	
	public void setId(int id);
	
	public void setItem(String item);
	
	public void setName(String name);
	
	public void getUserInput(Scanner input);
	
	public void printInfo();

}
