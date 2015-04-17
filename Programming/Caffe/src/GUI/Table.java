package GUI;

import Control.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Table extends JFrame {
	private JButton btnTable1;
	private JButton btnTable2;
	private JButton btnTable3;
	public Table() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 400, 200);
		this.setTitle("Table");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnTable1 = new JButton("Table 1");
		btnTable1.setBounds(10, 11, 89, 23);
		btnTable1.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CtrTable table = new CtrTable(1);
				Product product = new Product(table);
				product.setVisible(true);
				product.setLocationRelativeTo(null);
			}});
		panel.add(btnTable1);
		
		btnTable2 = new JButton("Table 2");
		btnTable2.setBounds(109, 11, 89, 23);
		btnTable2.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CtrTable table = new CtrTable(2);
				Product product = new Product(table);
				product.setVisible(true);
				product.setLocationRelativeTo(null);
			}});
		panel.add(btnTable2);
		
		btnTable3 = new JButton("Table3");
		btnTable3.setBounds(208, 11, 89, 23);
		btnTable3.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CtrTable table = new CtrTable(3);
				Product product = new Product(table);
				product.setVisible(true);
				product.setLocationRelativeTo(null);
			}});
		panel.add(btnTable3);
		
	}
}
