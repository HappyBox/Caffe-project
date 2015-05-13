package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Model.Product;

public class ManageAProduct extends JFrame {

	private static String title = "Manage Products menu";
	
	public ManageAProduct() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 244, 227);
		this.setLocationRelativeTo(null);
		this.setTitle(title);
		getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(63, 19, 117, 29);
		getContentPane().add(btnAdd);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(63, 60, 117, 29);
		getContentPane().add(btnFind);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(63, 101, 117, 29);
		getContentPane().add(btnUpdate);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(63, 142, 117, 29);
		getContentPane().add(btnRemove);
	
	/*
	 * Buttons Functionality
	 */
	btnAdd.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
		Product Product = new Product();
		
		}
	});
	} 
}
