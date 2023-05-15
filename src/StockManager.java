import java.util.ArrayList;
import java.util.Scanner;

import stock.CuStock;
import stock.Gs25ConvenienceStock;
import stock.MiniStopConvenienceStock;
import stock.Stock;
import stock.StockInput;
import stock.StockKind;

public class StockManager {
	ArrayList<StockInput> stocks=new ArrayList<StockInput>();
	Scanner input;
	StockManager(Scanner input){
		this.input=input;
	}
	
	public void addStock() {
		int kind=0;
		StockInput stockInput;
		while(kind!=1&&kind!=2) {
		  System.out.println("1 for Cu");
		  System.out.println("2 for Gs25 ");
		  System.out.println("3 for Ministop ");
		  System.out.println("Select num 1, 2 or 3 for Stock Kind : ");
		  kind=input.nextInt();
		  if(kind==1) {
			 stockInput=new CuStock(StockKind.Cu);
			 stockInput.getUserInput(input);
			 stocks.add(stockInput);
			 break;
		  }
		  else if(kind==2) {
			 stockInput=new Gs25ConvenienceStock(StockKind.Gs25);
			 stockInput.getUserInput(input);
			 stocks.add(stockInput);
			 break;
		  }
		  else if(kind==3) {
				 stockInput=new MiniStopConvenienceStock(StockKind.Ministop);
				 stockInput.getUserInput(input);
				 stocks.add(stockInput);
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
			StockInput stockInput=stocks.get(i);
		   if (stockInput.getId()==stockId) {
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
					stockInput.setId(id);
				}
				else if (num==2) {
					System.out.print("Stock Item:");
					String item=input.next();
					stockInput.setItem(item);
				}
				else if (num==3) {
					System.out.print("Stock name:");
					String name=input.next();
					stockInput.setName(name);
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


