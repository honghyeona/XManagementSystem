package stock;

import java.util.Scanner;

public class Stock {
	protected StockKind kind=StockKind.ConvenienceStore;
	protected int id;
	protected String item;
	protected String name;
	
	public StockKind getKind() {
		return kind;
	}

	public void setKind(StockKind kind) {
		this.kind = kind;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Stock() {
	}
	
	public Stock(int id,String item) {
		this.id=id;
		this.item=item;
	}
	
	public Stock(int id,String item,String name) {
		this.id=id;
		this.item=item;
		this.name=name;
	}
	
	public void printInfo() {
		System.out.println("id:"+id+" item:"+item+" name:"+name);
	}
	
	public void getUserInput(Scanner input) {
		System.out.print("Stock ID: "); 
	    int id=input.nextInt();
	    this.setId(id);
	    
		System.out.print("Stock Item: ");
		String item=input.next();
		this.setItem(item);
		
		System.out.print("stock Name: ");
		String name=input.next();
		this.setName(name);
	}

}
