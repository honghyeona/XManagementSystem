import java.util.ArrayList;
import java.util.Scanner;

public class StockManager {
	ArrayList<Stock> stocks=new ArrayList<Stock>();
	Scanner input;
	StockManager(Scanner input){
		this.input=input;
	}
	
	public void addStock() {
		Stock stock=new Stock();
		System.out.print("Stock ID: "); 
		stock.id=input.nextInt();
		System.out.print("Stock Item: ");
		stock.item=input.next();
		System.out.print("stock Name: ");
		stock.name=input.next();
		stocks.add(stock);
	}
	
	public  void deleteStock() {
		System.out.print("Stock ID: ");
		int stockId = input.nextInt();
		int index=-1;
		for(int i=0;i<stocks.size();i++) {
			if (stocks.get(i).id==stockId) {
				index=i;
				break;
			}
		}
		
		if(index>=0) {
			stocks.remove(index);
			System.out.println("the stock "+stockId+"is deleted");
		}
		else {
			System.out.println("the stock has not been registered");
			return;
		}
	}
	
	public  void editStock() {
		System.out.print("Stock ID: ");
		int stockId = input.nextInt();
		for(int i=0;i<stocks.size();i++) {
			Stock stock=stocks.get(i);
		   if (stock.id==stockId) {
			  int num=-1;
			  while(num!=5) {
				System.out.println("***Stocks Info Edit Menu***");
				System.out.println("1. Edit Id");
				System.out.println("2. Edit item");
				System.out.println("3. Edit Name");
				System.out.println("4. Exit");
				System.out.println("Select one number between 1-4:");
				num=input.nextInt();
				if (num==1) {
					System.out.print("Stock ID:");
					stock.id=input.nextInt();
				}
				else if (num==2) {
					System.out.print("Stock Item:");
					stock.item=input.next();
				}
				else if (num==3) {
					System.out.print("Stock name:");
					stock.name=input.next();
				}
				else if (num ==4) {
					 break;
				}//if	
			  }//while
			  break;
		   }//if
		}//for
	}
	
	public  void viewStocks() {
//		System.out.print("Stock ID: ");
//		int stocksId = input.nextInt();
		for(int i=0;i<stocks.size();i++) {
			stocks.get(i).printInfo();
		}
	}
	
}


