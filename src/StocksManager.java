import java.util.Scanner;

public class StocksManager {
	Stocks stocks;
	Scanner input;
	StocksManager(Scanner input){
		this.input=input;
	}
	
	public void addStocks() {
		stocks=new Stocks();
		System.out.print("Stocks ID: "); 
		stocks.id=input.nextInt();
		System.out.print("Stocks Item: ");
		stocks.item=input.next();
		System.out.print("stocksName:");
		stocks.name=input.next();
	}
	public  void deleteStocks() {
		System.out.print("Stocks ID: ");
		int stocksId = input.nextInt();
		if (stocks==null) {
			System.out.println("the stocks has not been registered");
			return;
		}
		if (stocks.id==stocksId) {
			stocks=null;
			System.out.println("the stocks is deleted");
			return;
		}
		
	}
	public  void editStocks() {
		System.out.print("Stocks ID: ");
		int stocksId = input.nextInt();
		if (stocks.id==stocksId) {
			System.out.println("the stocks to be edited is "+stocksId);
			return;
		}
	}
	
	public  void viewStocks() {
		System.out.print("Stocks ID: ");
		int stocksId = input.nextInt();
		if (stocks.id==stocksId) {
			stocks.printInfo();
		}
	}
	
}


