package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Control.CtrTable;
import Model.Employee;
import Model.Manager;

public class ManagerGUI extends JFrame{
	public static String title="Manager";
	private CtrTable ctrTable= new CtrTable();
	public ManagerGUI() {
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 225, 313);
		this.setTitle(title);
		
		JButton btnManageAnEmployee = new JButton("Manage an employee");
		btnManageAnEmployee.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnManageAnEmployee.setBounds(6, 0, 213, 58);
		getContentPane().add(btnManageAnEmployee);
		
		JButton btnManageADish = new JButton("Manage dish");
		btnManageADish.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnManageADish.setBounds(6, 70, 213, 52);
		getContentPane().add(btnManageADish);
		
		JButton btnUpdateTheCompany = new JButton("Update the company information");
		btnUpdateTheCompany.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnUpdateTheCompany.setBounds(0, 129, 225, 71);
		getContentPane().add(btnUpdateTheCompany);
		
		JButton buttonOrder = new JButton("Order");
		buttonOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonOrder.setBounds(0, 212, 225, 71);
		getContentPane().add(buttonOrder);
	
	/*
	 * Buttons Functionality
	 */
	btnManageAnEmployee.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		ManageAnEmployee ManageAnEmployee = new ManageAnEmployee();
		ManageAnEmployee.setVisible(true);
		ManageAnEmployee.setLocationRelativeTo(null);
			
		}
	});
	
	btnManageADish.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			ManageADish ManageADish = new ManageADish();
			ManageADish.setVisible(true);
			ManageADish.setLocationRelativeTo(null);
		}
	});
	
	
	btnUpdateTheCompany.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			UpdateTheCompany UpdateTheCompany = new UpdateTheCompany();
			UpdateTheCompany.setVisible(true);
			UpdateTheCompany.setLocationRelativeTo(null);
		}
	});
	buttonOrder.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event) {
			Employee emp = new Employee();
			CustomerReg customerReg = new CustomerReg(emp ,ctrTable);
			customerReg.setVisible(true);
			customerReg.setLocationRelativeTo(null);
		}
	});
	}
	
	public static void main(String[] args) {

		ManagerGUI start = new ManagerGUI();
		start.setVisible(true);
		start.setLocationRelativeTo(null);
	}
}
