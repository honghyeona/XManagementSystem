
import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		StockManager stockmanager=new StockManager(input);
		
		int num  =-1;
		while(num!=5) {
			System.out.println("***Stocks Management System Menu***");
			System.out.println("1. Add stock");
			System.out.println("2. Delete stock");
			System.out.println("3. Edit stock");
			System.out.println("4. View stocks");
			System.out.println("5. Exit");
			System.out.println("Select one number between 1-5:");
			num=input.nextInt();
			if (num==1) {
				stockmanager.addStock();
			}
			else if (num==2) {
				stockmanager.deleteStock();
			}
			else if (num==3) {
				stockmanager.editStock();
			}
			else if (num==4) {
				stockmanager.viewStocks();
			}
			else {
				continue;
			}
			
		}
	}
}
