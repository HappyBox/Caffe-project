package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Control.CtrTable;
import Model.Customer;
import Model.Employee;

public class Table extends JFrame {
	private JButton button_21;
	private JButton button_20;
	private JButton button_19;
	private String customerPh;
	private JButton btnBack;
	private Table table;
	private JButton button_18;
	private JButton button_17;
	private JButton button_16;
	private JButton button_15;
	private JButton btnKitchen;
	private JCheckBox changeOwner;
	private JButton button_14;
	private JButton button_1;
	private JButton button_9;
	private JButton button_5;
	private JButton button_4;
	private JButton button_2;
	private JButton button_3;
	private JButton button_10;
	private JButton button_7;
	private JButton button_6;
	private JButton button_11;
	private JButton button_8;
	private JButton button_12;
	private JButton button_13;
	private JButton btnDriver;
	public Table(Employee emp, Customer cus, CtrTable ctrTable) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 416, 291);
		this.setTitle("Employee: " + emp.getName() + " customer: " + cus.getName());
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.dispose();
			}
		});
		btnBack.setBounds(301, 219, 89, 23);
		panel.add(btnBack);
		
		button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(1) == false)
				{
					ctrTable.addCustomer(1,cus);
				}
				Menu menu = new Menu(1, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_1.setBounds(230, 11, 45, 23);
		panel.add(button_1);
		
		button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(2) == false)
				{
					ctrTable.addCustomer(2,cus);
				}
				Menu menu = new Menu(2, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_2.setBounds(175, 11, 45, 23);
		panel.add(button_2);
		
		button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(3) == false)
				{
					ctrTable.addCustomer(3,cus);
				}
				Menu menu = new Menu(3, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_3.setBounds(120, 11, 45, 23);
		panel.add(button_3);
		
		button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(4) == false)
				{
					ctrTable.addCustomer(4,cus);
				}
				Menu menu = new Menu(4, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_4.setBounds(65, 11, 45, 23);
		panel.add(button_4);
		
		button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(5) == false)
				{
					ctrTable.addCustomer(5,cus);
				}
				Menu menu = new Menu(5, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_5.setBounds(10, 45, 45, 23);
		panel.add(button_5);
		
		button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(6) == false)
				{
					ctrTable.addCustomer(6,cus);
				}
				Menu menu = new Menu(6, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_6.setBounds(10, 79, 45, 23);
		panel.add(button_6);
		
		button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(7) == false)
				{
					ctrTable.addCustomer(7,cus);
				}
				Menu menu = new Menu(7, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_7.setBounds(10, 113, 45, 23);
		panel.add(button_7);
		
		button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(8) == false)
				{
					ctrTable.addCustomer(8,cus);
				}
				Menu menu = new Menu(8, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_8.setBounds(10, 147, 45, 23);
		panel.add(button_8);
		
		button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(9) == false)
				{
					ctrTable.addCustomer(9,cus);
				}
				Menu menu = new Menu(9, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_9.setBounds(10, 181, 45, 23);
		panel.add(button_9);
		
		button_10 = new JButton("10");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(10) == false)
				{
					ctrTable.addCustomer(10,cus);
				}
				Menu menu = new Menu(10, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_10.setBounds(85, 59, 52, 23);
		panel.add(button_10);
		
		button_11 = new JButton("11");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(11) == false)
				{
					ctrTable.addCustomer(11,cus);
				}
				Menu menu = new Menu(11, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_11.setBounds(85, 93, 52, 23);
		panel.add(button_11);
		
		btnKitchen = new JButton("Kitchen");
		btnKitchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KitchenMeniu kitchen = new KitchenMeniu();
				kitchen.setVisible(true);
				kitchen.setLocationRelativeTo(null);
			}
		});
		
		button_12 = new JButton("12");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(12) == false)
				{
					ctrTable.addCustomer(12,cus);
				}
				Menu menu = new Menu(12, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_12.setBounds(85, 127, 52, 23);
		panel.add(button_12);
		
		button_13 = new JButton("13");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(13) == false)
				{
					ctrTable.addCustomer(13,cus);
				}
				Menu menu = new Menu(13, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_13.setBounds(85, 161, 52, 23);
		panel.add(button_13);
		
		button_14 = new JButton("14");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(14) == false)
				{
					ctrTable.addCustomer(14,cus);
				}
				Menu menu = new Menu(14, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_14.setBounds(140, 59, 52, 23);
		panel.add(button_14);
		
		button_15 = new JButton("15");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(15) == false)
				{
					ctrTable.addCustomer(15,cus);
				}
				Menu menu = new Menu(15, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_15.setBounds(140, 93, 52, 23);
		panel.add(button_15);
		
		button_16 = new JButton("16");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(16) == false)
				{
					ctrTable.addCustomer(16,cus);
				}
				Menu menu = new Menu(16, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_16.setBounds(140, 127, 52, 23);
		panel.add(button_16);
		
		button_17 = new JButton("17");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(17) == false)
				{
					ctrTable.addCustomer(17,cus);
				}
				Menu menu = new Menu(17, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
		});
		button_17.setBounds(140, 161, 52, 23);
		panel.add(button_17);
		
		button_18 = new JButton("18");
		button_18.setBounds(340, 79, 50, 23);
		button_18.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(18) == false)
				{
					ctrTable.addCustomer(18,cus);
				}
				Menu menu = new Menu(18, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}});
		panel.add(button_18);
		
		button_19 = new JButton("19");
		button_19.setBounds(340, 45, 50, 23);
		button_19.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(19) == false)
				{
					ctrTable.addCustomer(19,cus);
				}
				Menu menu = new Menu(19, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}});
		panel.add(button_19);
		
		button_20 = new JButton("20");
		button_20.setBounds(340, 79, 50, 23);
		button_20.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(20) == false)
				{
					ctrTable.addCustomer(20,cus);
				}
				Menu menu = new Menu(20, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}});
		panel.add(button_20);

		button_21 = new JButton("21");
		button_21.setBounds(340, 113, 50, 23);
		button_21.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ctrTable.customerIsSet(21) == false)
				{
					ctrTable.addCustomer(21,cus);
				}
				Menu menu = new Menu(21, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
				//menu.setList(tableList1);
			}});
		panel.add(button_21);
		btnKitchen.setBounds(213, 59, 82, 125);
		panel.add(btnKitchen);
		
		btnDriver = new JButton("Driver");
		btnDriver.setBounds(301, 161, 89, 23);
		btnDriver.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(ctrTable.customerIsSet(0) == false)
				{
					ctrTable.addCustomer(0,cus);
				}
				Menu menu = new Menu(0, ctrTable);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				menu.setWindow(menu);
			}
			
		});
		panel.add(btnDriver);
		
		changeOwner = new JCheckBox("Allow to change customer");
		changeOwner.setBounds(10, 219, 278, 23);
		panel.add(changeOwner);
		
	}
	public void setTable(Table table)
	{
		this.table = table;
	}
}
