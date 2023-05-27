
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import log.EventLogger;

public class MenuManager {
	static EventLogger logger=new EventLogger("log.txt");

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StockManager stockManager = getObject("stockmanager.ser");
		if(stockManager==null) {
			stockManager=new StockManager(input);
		}
		
		selectMenu(input, stockManager);
		putObject(stockManager,"stockmanager.ser");
	}

	public static void selectMenu(Scanner input,StockManager stockmanager) {
		int num  =-1;
		while(num!=5) {
			try {
				showMenu();
				num=input.nextInt();
				switch(num) {
				case 1:
					stockmanager.addStock();
					logger.log("add a stock");
					break;
				case 2:
					stockmanager.deleteStock();
					logger.log("delete a stock");
					break;
				case 3:
					stockmanager.editStock();
					logger.log("edit a stock");
					break;
				case 4:
					stockmanager.viewStocks();
					logger.log("view a list of stock");
					break;
				default:
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 5!");
				if(input.hasNext()) {
					input.next();
				}
				num=-1;
			}
		}
	}

	public static void showMenu() {
		System.out.println("***Stocks Management System Menu***");
		System.out.println("1. Add stock");
		System.out.println("2. Delete stock");
		System.out.println("3. Edit stock");
		System.out.println("4. View stocks");
		System.out.println("5. Exit");
		System.out.println("Select one number between 1-5:");
	}
	
	public static StockManager getObject(String filename) {
		StockManager stockManager=null;
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in=new ObjectInputStream(file);
			
			stockManager=(StockManager)in.readObject();
			in.close();
			file.close();	
		} catch (FileNotFoundException e) {
			return stockManager;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		return stockManager;
	}
	
	public static void putObject(StockManager stockManager,String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out=new ObjectOutputStream(file);
			
			out.writeObject(stockManager);
			out.close();
			file.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
