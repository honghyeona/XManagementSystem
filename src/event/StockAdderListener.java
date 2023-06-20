package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import Exception.ItemFormatException;
import manager.StockManager;
import stock.CuStock;
import stock.Stock;
import stock.StockInput;
import stock.StockKind;

public class StockAdderListener implements ActionListener {
	
	
	JTextField fieldID;
	JTextField fieldItem;
	JTextField fieldName;
	
	StockManager stockManager;
	
	public StockAdderListener(JTextField fieldID,
			JTextField fieldItem,
			JTextField fieldName,StockManager stockManager) {
		this.fieldID=fieldID;
		this.fieldItem=fieldItem;
		this.fieldName=fieldName;
		this.stockManager=stockManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		StockInput stock=new CuStock(StockKind.Cu);
		try {
			stock.setId(Integer.parseInt(fieldID.getText()));
			stock.setItem(fieldItem.getText());
			stock.setName(fieldName.getText());
			stockManager.addStock(stock);
			putObject(stockManager,"stockmanager.ser");
			stock.printInfo();
		} catch (ItemFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
