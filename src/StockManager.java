import java.util.ArrayList;
import java.util.Scanner;

import stock.MartStock;
import stock.Stock;

public class StockManager {
	ArrayList<Stock> stocks=new ArrayList<Stock>();
	Scanner input;
	StockManager(Scanner input){
		this.input=input;
	}
	
	public void addStock() {
		int kind=0;
		Stock stock;
		while(kind!=1&&kind!=2) {
		  System.out.print("1 for ConveniecneStore");
		  System.out.print("2 for Mart");
		  System.out.print("Select num for Stock Kind between 1 and 2 : ");
		  kind=input.nextInt();
		  if(kind==1) {
			 stock=new Stock();
			 stock.getUserInput(input);
			 stocks.add(stock);
			 break;
		  }
		  else if(kind==2) {
			 stock=new MartStock();
			 stock.getUserInput(input);
			 stocks.add(stock);
			 break;
		  }
		  else {
			  System.out.print("Select num for Stock Kind between 1 and 2 : ");
		  }
		}
	}
	
	public  void deleteStock() {
		System.out.print("Stock ID: ");
		int stockId = input.nextInt();
		int index=-1;
		for(int i=0;i<stocks.size();i++) {
			if (stocks.get(i).getId()==stockId) {
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
		   if (stock.getId()==stockId) {
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
					int id=input.nextInt();
					stock.setId(id);
				}
				else if (num==2) {
					System.out.print("Stock Item:");
					String item=input.next();
					stock.setItem(item);
				}
				else if (num==3) {
					System.out.print("Stock name:");
					String name=input.next();
					stock.setName(name);
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
		System.out.println("# of registered stocks:"+stocks.size());
		for(int i=0;i<stocks.size();i++) {
			stocks.get(i).printInfo();
		}
	}
	
}


