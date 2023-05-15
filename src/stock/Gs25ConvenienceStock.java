package stock;

import java.util.Scanner;

public class Gs25ConvenienceStock extends Stock implements StockInput{
	
	public Gs25ConvenienceStock(StockKind kind) {
		super(kind);
	}
	
	public void getUserInput(Scanner input) {
		System.out.print("Stock ID: "); 
	    int id=input.nextInt();
	    this.setId(id);
	    
	    char answer='x';
	    while(answer!='y'&&answer!='Y'&&answer!='n'&&answer!='N') {
	      System.out.print("Do you have an item? (Y/N)");
	      answer=input.next().charAt(0);
	      if(answer=='y'||answer=='Y') {
	    	  System.out.print("Stock Item: ");
			  String item=input.next();
			  this.setItem(item);
			  break;
	      }
	      else if(answer=='n'||answer=='N') {
	    	  this.setItem("");
	    	  break;
	      }
	      else {
	      }
	    }
		
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
