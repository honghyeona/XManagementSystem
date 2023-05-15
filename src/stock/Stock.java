package stock;

import java.util.Scanner;

public abstract class Stock {
	protected StockKind kind=StockKind.Cu;
	protected int id;
	protected String item;
	protected String name;
	
	public Stock() {
	}
	
	public Stock(StockKind kind) {
		this.kind=kind;
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
	
	public Stock(StockKind kind,int id,String item,String name) {
		this.kind=kind;
		this.id=id;
		this.item=item;
		this.name=name;
	}
	
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
	
	public abstract void printInfo();

}
