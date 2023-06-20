package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import event.StockAdderCancelListener;
import event.StockAdderListener;
import manager.StockManager;

public class StockAdder extends JPanel {
	
	WindowFrame frame;
	StockManager stockManager;
	
	public StockAdder(WindowFrame frame,StockManager stockManager) {
		this.frame=frame;
		this.stockManager= stockManager;
		
		JPanel panel=new JPanel(new SpringLayout());
		panel.setLayout(new SpringLayout());
		
		JLabel labelID=new JLabel("ID: ",JLabel.TRAILING);
		JTextField fieldID=new JTextField(10);
		labelID.setLabelFor(fieldID);
		panel.add(labelID);
		panel.add(fieldID);
		
		JLabel labelItem=new JLabel("Item: ",JLabel.TRAILING);
		JTextField fieldItem=new JTextField(10);
		labelItem.setLabelFor(fieldItem);
		panel.add(labelItem);
		panel.add(fieldItem);
		
		JLabel labelName=new JLabel("Name: ",JLabel.TRAILING);
		JTextField fieldName=new JTextField(10);
		labelName.setLabelFor(fieldName);
		
		JButton saveButton=new JButton("save");
		saveButton.addActionListener(new StockAdderListener(fieldID,fieldItem,fieldName,stockManager));
		
		JButton cancelButton=new JButton("cancel");
		cancelButton.addActionListener(new StockAdderCancelListener(frame));
		
		panel.add(labelName);
		panel.add(fieldName);
		
		panel.add(saveButton);
		panel.add(cancelButton);
		
		SpringUtilities.makeCompactGrid(panel,4, 2, 6, 6, 6, 6);
		
		
		this.add(panel);
		this.setVisible(true);
		
		
	}

}
