package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import Control.*;
import Model.Customer;
import Model.Employee;
import Model.Manager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerReg extends JFrame {

	private JPanel contentPane;
	private JButton btnContinue;
	private JButton btnAdd;
	private JButton btnSkip;
	private JLabel label;
	private JTextField textField;
	private JLabel lblPhone;
	private CtrCus ctrCustomer = new CtrCus();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerReg frame = new CustomerReg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
	}

	/**
	 * Create the frame.
	 */
	public CustomerReg(Employee emp, CtrTable ctrTable) {
		setTitle("Logged in as " + emp.getName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 286, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(66, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 14, 46, 14);
		contentPane.add(lblPhone);
		
		btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrCus ctrCus = new CtrCus();
				try
				{
					Customer cus = ctrCus.findByPhone(textField.getText());
					if(cus.getPhone().intern() == textField.getText().intern())
					{
						Table table = new Table(emp, cus, ctrTable);
						table.setVisible(true);
						table.setLocationRelativeTo(null);
						table.setTable(table);	    // to dispose window
					}
					System.out.println(cus.getPhone());
				}
				catch(Exception as)
				{
					label.setText("customer was not found");
				}
				
			}
		});
		btnContinue.setBounds(162, 10, 89, 23);
		contentPane.add(btnContinue);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerReg2 customerReg2 = new CustomerReg2();
				customerReg2.setVisible(true);
				customerReg2.setLocationRelativeTo(null);
				customerReg2.setWindow(customerReg2);								// to dispose window
				}
		});
		btnAdd.setBounds(10, 64, 89, 23);
		contentPane.add(btnAdd);
		
		btnSkip = new JButton("Skip");
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cus = new Customer();
				cus.setName("none");
				cus.setPhone("00000000");
				cus.setAddress("Sofiendalsvej60");
				Table table = new Table(emp, cus, ctrTable);
				table.setVisible(true);
				table.setLocationRelativeTo(null);
				table.setTable(table);	    // to dispose window
			}
		});
		btnSkip.setBounds(162, 64, 89, 23);
		contentPane.add(btnSkip);
		
		label = new JLabel("");
		label.setBounds(10, 39, 241, 14);
		contentPane.add(label);
	}
	
}
