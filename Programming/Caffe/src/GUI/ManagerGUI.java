package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ManagerGUI extends JFrame{
	public static String title="Manager";

	public ManagerGUI() {
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 225, 300);
		this.setTitle(title);
		
		JButton btnManageAEmployee = new JButton("Manage a employee");
		btnManageAEmployee.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnManageAEmployee.setBounds(6, 0, 213, 58);
		getContentPane().add(btnManageAEmployee);
		
		JButton btnManageAProduct = new JButton("Manage a product");
		btnManageAProduct.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnManageAProduct.setBounds(6, 70, 213, 52);
		getContentPane().add(btnManageAProduct);
		
		JButton btnTransportPriceUpdate = new JButton("Transport price update");
		btnTransportPriceUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTransportPriceUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnTransportPriceUpdate.setBounds(6, 134, 213, 55);
		getContentPane().add(btnTransportPriceUpdate);
		
		JButton btnUpdateTheCompany = new JButton("Update the company information");
		btnUpdateTheCompany.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnUpdateTheCompany.setBounds(0, 201, 225, 71);
		getContentPane().add(btnUpdateTheCompany);
	
	/*
	 * Buttons Functionality
	 */
	btnManageAEmployee.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		ManageAEmployee ManageAEmployee = new ManageAEmployee();
		ManageAEmployee.setVisible(true);
		ManageAEmployee.setLocationRelativeTo(null);
			
		}
	});
	
	btnManageAProduct.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			ManageAProduct ManageAProduct = new ManageAProduct();
			ManageAProduct.setVisible(true);
			ManageAProduct.setLocationRelativeTo(null);
		}
	});
	
	btnTransportPriceUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			TransportPriceUpdate TransportPriceUpdate = new TransportPriceUpdate();
			TransportPriceUpdate.setVisible(true);
			TransportPriceUpdate.setLocationRelativeTo(null);
		}
	});
	
	btnUpdateTheCompany.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			UpdateTheCompany UpdateTheCompany = new UpdateTheCompany();
			UpdateTheCompany.setVisible(true);
			UpdateTheCompany.setLocationRelativeTo(null);
		}
	});
	}
	
	public static void main(String[] args) {

		ManagerGUI start = new ManagerGUI();
		start.setVisible(true);
		start.setLocationRelativeTo(null);
	}
}
