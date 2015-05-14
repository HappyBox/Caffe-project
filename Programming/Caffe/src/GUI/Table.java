package GUI;

import Control.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Table extends JFrame {
	private JButton btnTable1;
	private JButton btnTable2;
	private JButton btnTable3;
	private String customerPh;
	private JButton btnBack;
	private Table table;
	private ArrayList<String> tableList1 = new ArrayList();
	private ArrayList<String> tableList2 = new ArrayList();
	private ArrayList<String> tableList3 = new ArrayList();
	private CtrTable ctrTable;
	public Table(CtrTable ctrTable) {
		this.ctrTable = ctrTable;
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
				ctrTable.setTable(1);
				Menu menu = new Menu(ctrTable, 1);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
				menu.setList(tableList1);
			}});
		panel.add(btnTable1);
		
		btnTable2 = new JButton("Table 2");
		btnTable2.setBounds(109, 11, 89, 23);
		btnTable2.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ctrTable.setTable(2);
				Menu menu = new Menu(ctrTable, 2);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
				menu.setList(tableList2);
			}});
		panel.add(btnTable2);
		
		btnTable3 = new JButton("Table3");
		btnTable3.setBounds(208, 11, 89, 23);
		btnTable3.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ctrTable.setTable(3);
				Menu menu = new Menu(ctrTable, 3);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
				menu.setList(tableList3);
			}});
		panel.add(btnTable3);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.dispose();
			}
		});
		btnBack.setBounds(285, 128, 89, 23);
		panel.add(btnBack);
		
	}
	public void setTable(Table table)
	{
		this.table = table;
	}
	public void setPhone(String phone)
	{
		customerPh = phone;
	}
}
