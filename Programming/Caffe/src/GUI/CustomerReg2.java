package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.CtrCus;
import Model.Customer;

public class CustomerReg2 extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JButton btnUpdate;
	private JButton btnFind;
	private JButton btnBack;
	private JButton btnAdd;
	private CustomerReg2 win;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 36, 59, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 59, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(10, 85, 238, 24);
		contentPane.add(lblError);
		
		name = new JTextField();
		name.setBounds(66, 8, 182, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setBounds(66, 33, 182, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(64, 62, 184, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().length() > 0 && address.getText().length() < 15 && phone.getText().length() == 8)
				{
					CtrCus ctrCus = new CtrCus();
					int x = ctrCus.createCustomer(name.getText(), address.getText(), phone.getText());
					if (x != -1)
					{
						lblError.setText("customer added");
					}
				}
				else
				{
					lblError.setText("fill all fiels correctly");
				}
			}
		});
		btnAdd.setBounds(260, 8, 89, 23);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dispose();
			}
		});
		btnBack.setBounds(258, 86, 89, 23);
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
				}
				else
				{
					lblError.setText("fill phone field");
				}
			}
		});
		btnFind.setBounds(260, 33, 89, 23);
		contentPane.add(btnFind);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().length() > 0 && address.getText().length() > 0 && phone.getText().length() > 0)
				{
					CtrCus ctrCus = new CtrCus();
					int x = ctrCus.updateCustomer(name.getText(), address.getText(), phone.getText());
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
		btnUpdate.setBounds(260, 59, 89, 23);
		contentPane.add(btnUpdate);
		
	}
	public void setWindow(CustomerReg2 win)
	{
		this.win = win;
	}
}
