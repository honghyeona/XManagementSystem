package stock;

import java.util.Scanner;

public class CuStock extends Stock implements StockInput {
	
	public CuStock(StockKind kind) {
		super(kind);
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
	
	public void printInfo() {
		String skind="none";
		switch(this.kind) {
		case Cu:
			skind="Cu.";
			break;
		case Gs25:
			skind="Gs.";
			break;
		case Seveneleven:
			skind="Seven.";
			break;
		case Ministop:
			skind="Mini";
			break;
		default:
		}
		System.out.println("kind:"+skind+ "id:"+id+" item:"+item+" name:"+name);
	}

}
