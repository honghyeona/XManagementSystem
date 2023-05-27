import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import stock.CuStock;
import stock.Gs25ConvenienceStock;
import stock.MiniStopConvenienceStock;
import stock.StockInput;
import stock.StockKind;

public class StockManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2957955150063190653L;
	
	ArrayList<StockInput> stocks=new ArrayList<StockInput>();
	transient Scanner input;
	StockManager(Scanner input){
		this.input=input;
	}
	
	public void addStock() {
		int kind=0;
		StockInput stockInput;
		while(kind<1||kind>3) {
			try {
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
			catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 3!");
				if(input.hasNext()) {
					input.next();
				}
				kind=-1;
			}
		}
	}
	
	public  void deleteStock() {
		System.out.print("Stock ID: ");
		int stockId = input.nextInt();
		int index=findIndex(stockId);
		removefromStocks(index,stockId);
	}
	
	public int removefromStocks(int index,int stockId) {
		if(index>=0) {
			stocks.remove(index);
			System.out.println("the stock "+stockId+"is deleted");
			return 1;
		}
		else {
			System.out.println("the stock has not been registered");
			return -1;
		}
	}
	
	public int findIndex(int stockId) {
		int index=-1;
		for(int i=0;i<stocks.size();i++) {
			if (stocks.get(i).getId()==stockId) {
				index=i;
				break;
			}
		}		
		return index;
	}
	
	public  void editStock() {
		System.out.print("Stock ID: ");
		int stockId = input.nextInt();
		for(int i=0;i<stocks.size();i++) {
			StockInput stock=stocks.get(i);
		   if (stock.getId()==stockId) {
			  int num=-1;
			  while(num!=5) {
			    showEditMenu();
				num=input.nextInt();
				switch(num) {
				case 1:
					stock.setStockID(input);
					break;
				case 2:
					stock.setStockItem(input);
					break;
				case 3:
					stock.setStockName(input);
					break;
				default:
					continue;
				}
			  }//while
			  break;
		   }//if
		}//for
	}
	
	public  void viewStocks() {
		System.out.println("# of registered stocks:"+stocks.size());
		for(int i=0;i<stocks.size();i++) {
			stocks.get(i).printInfo();
		}
	}
	
	public void showEditMenu() {
		System.out.println("***Stocks Info Edit Menu***");
		System.out.println("1. Edit Id");
		System.out.println("2. Edit item");
		System.out.println("3. Edit Name");
		System.out.println("4. Exit");
		System.out.println("Select one number between 1-4:");
	}
}


