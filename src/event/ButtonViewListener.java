package event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;

import gui.StockViewer;
import gui.WindowFrame;
import manager.StockManager;

public class ButtonViewListener implements ActionListener {
	
	WindowFrame frame;

	StockManager stockManager;
	public ButtonViewListener(WindowFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StockViewer stockViewer = frame.getStockviewer();
		StockManager stockManager = getObject("stockmanager.ser");
		stockViewer.setStockManager(stockManager);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(stockViewer);
		frame.revalidate();
		frame.repaint();
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

}
