package stock;

import java.util.Scanner;

public class Gs25 extends Stock {
	
	public Gs25(StockKind kind) {
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


}
