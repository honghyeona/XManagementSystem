package gui;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manager.StockManager;
import stock.StockInput;

public class StockViewer extends JPanel {
	
	WindowFrame frame;
	
	StockManager stockManager;
	
	public StockManager getStockManager() {
		return stockManager;
	}
	
	public void setStockManager(StockManager stockManager) {
		this.stockManager=stockManager;
		this.removeAll();
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Item");
		model.addColumn("Name");
		model.addColumn("Contact Info.");
		
		for (int i=0;i<stockManager.size();i++) {
			Vector row=new Vector();
			StockInput si=stockManager.get(i);
			row.add(si.getId());
			row.add(si.getItem());
			row.add(si.getName());
			model.addRow(row);
		}
	
		JTable table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		
		this.add(sp);
	}
	

	public StockViewer(WindowFrame frame,StockManager stockManager) {
		this.frame=frame;
		this.stockManager=stockManager;
		
		System.out.println("***"+stockManager.size()+"***");
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Item");
		model.addColumn("Name");
		model.addColumn("Contact Info.");
		
		for (int i=0;i<stockManager.size();i++) {
			Vector row=new Vector();
			StockInput si=stockManager.get(i);
			row.add(si.getId());
			row.add(si.getItem());
			row.add(si.getName());
			model.addRow(row);
		}
	
		JTable table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		
		this.add(sp);
		
	}

}
