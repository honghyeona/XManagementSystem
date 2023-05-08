package stock;

import java.util.Scanner;

public class MiniStopConvenienceStock extends Stock {
	
	public MiniStopConvenienceStock(StockKind kind) {
		super(kind);
	}
	
	protected int companyid;
	protected String companyitem;
	
	public void getUserInput(Scanner input) {
		System.out.print("Stock ID: "); 
	    int id=input.nextInt();
	    this.setId(id);
	    
	    char answer='x';
	    while(answer!='y'&&answer!='Y'&&answer!='n'&&answer!='N') {
	      System.out.print("Do you have an item? (Y/N)");
	      answer=input.next().charAt(0);
	      if(answer=='y'||answer=='Y') {
	    	  System.out.print("stock item: ");
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
	    
	    answer='x';
	    while(answer!='y'&&answer!='Y'&&answer!='n'&&answer!='N') {
	      System.out.print("Do you have a company's item? (Y/N)");
	      answer=input.next().charAt(0);
	      if(answer=='y'||answer=='Y') {
	    	  System.out.print("company's stock item: ");
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
		System.out.println("kind:"+skind+ "company's id:"+id+" company's item:"+item+" name:"+name);
	}


}
