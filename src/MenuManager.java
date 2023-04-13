
import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		StocksManager stocksManager=new StocksManager(input);
		
		int num  =-1;
		while(num!=5) {
			System.out.println("***Stocks Management System Menu***");
			System.out.println("1. Add stocks");
			System.out.println("2. Delete stocks");
			System.out.println("3. Edit stocks");
			System.out.println("4. View stocks");
			System.out.println("5. Exit");
			System.out.println("Select one number between 1-5:");
			num=input.nextInt();
			if (num==1) {
				stocksManager.addStocks();
			}
			else if (num==2) {
				stocksManager.deleteStocks();
			}
			else if (num==3) {
				stocksManager.editStocks();
			}
			else if (num==4) {
				stocksManager.viewStocks();
			}
			else {
				continue;
			}
			
		}
	}
	public static void addStocks() {
		Scanner input =new Scanner(System.in);	
		
		System.out.print("Stocks ID: "); 
		int stocksID=input.nextInt();
		
		System.out.print("Stocks Item: ");
		String stocksItem=input.next();
		System.out.println(stocksItem);

		System.out.print("stocksName:");
		String stocksName=input.next();
		System.out.println(stocksName);
	}
	
	
	public static void deleteStocks() {
		Scanner input =new Scanner(System.in);
		System.out.print("Stocks ID: ");
		int stocksID = input.nextInt();
	}
	public static void editStocks() {
		Scanner input =new Scanner(System.in);
		System.out.print("Stocks ID: ");
		int stocksID = input.nextInt();
	}
	
	public static void viewStocks() {
		Scanner input =new Scanner(System.in);
		System.out.print("Stocks ID: ");
		int stocksID = input.nextInt();
	}
	
}