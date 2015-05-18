package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Control.CtrCus;
import Model.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerReg2 extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JLabel lblError;
	private JButton btnUpdate;
	private JButton btnFind;
	private JButton btnBack;
	private JButton btnAdd;
	private CustomerReg2 win;
	private JTextField city;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerReg2 frame = new CustomerReg2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerReg2() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 354, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 36, 60, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 90, 46, 14);
		contentPane.add(lblPhone);
		
		name = new JTextField();
		name.setBounds(66, 8, 183, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setBounds(66, 33, 183, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setBounds(10, 116, 239, 20);
		contentPane.add(lblError);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 64, 46, 14);
		contentPane.add(lblCity);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(66, 60, 183, 20);
		contentPane.add(city);
		
		phone = new JTextField();
		phone.setBounds(66, 87, 183, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().length() > 0 && address.getText().length() > 0 && city.getText().length() > 0 && phone.getText().length() > 0)
				{
					CtrCus ctrCus = new CtrCus();
					int x = ctrCus.createCustomer(name.getText(), address.getText(), city.getText(), phone.getText());
					if (x != -1)
					{
						lblError.setText("customer added");
					}
				}
				else
				{
					lblError.setText("fill all fiels");
				}
			}
		});
		btnAdd.setBounds(248, 8, 89, 23);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dispose();
			}
		});
		btnBack.setBounds(248, 87, 89, 23);
		contentPane.add(btnBack);
		
		btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phone.getText().length() > 0)
				{
					CtrCus ctrCus = new CtrCus();
					Customer cus = ctrCus.findCustomer(phone.getText());
					lblError.setText("here you go");
					name.setText(cus.getName());
					address.setText(cus.getAddress());
					city.setText(cus.getCity());
				}
				else
				{
					lblError.setText("fill phone field");
				}
			}
		});
		btnFind.setBounds(248, 33, 89, 23);
		contentPane.add(btnFind);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().length() > 0 && address.getText().length() > 0 && city.getText().length() > 0 && phone.getText().length() > 0)
				{
					CtrCus ctrCus = new CtrCus();
					int x = ctrCus.updateCustomer(name.getText(), address.getText(), city.getText(), phone.getText());
					if (x != -1)
					{
						lblError.setText("customer updated");
					}
				}
				else
				{
					lblError.setText("fill all fiels");
				}
			}
		});
		btnUpdate.setBounds(248, 61, 89, 23);
		contentPane.add(btnUpdate);
		
	}
	public void setWindow(CustomerReg2 win)
	{
		this.win = win;
	}
}
