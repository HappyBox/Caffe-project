package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import Control.CtrEmp;
import Model.Employee;

public class ManageAEmployee extends JFrame{
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhone;
	private JTextField textPassword;
	private JTextField textOrders;
	private JButton btnAdd;
	private JButton btnFind;
	private JButton btnUpdate;
	private JButton btnDelete;
	private CtrEmp CtrEmp = new CtrEmp();
	private JLabel lblError;
		public ManageAEmployee() {

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 319, 290);
		this.setTitle("Manage a employee");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setName("");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 6, 307, 256);
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(10, 59, 65, 22);
		panel_1.add(label_1);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(74, 59, 140, 23);
		panel_1.add(textName);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(74, 159, 140, 20);
		panel_1.add(textAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 159, 65, 20);
		panel_1.add(lblAddress);
		
		JLabel lblOrders = new JLabel("Orders");
		lblOrders.setBounds(10, 93, 65, 20);
		panel_1.add(lblOrders);
		
		textOrders = new JTextField();
		textOrders.setColumns(10);
		textOrders.setBounds(74, 94, 140, 20);
		panel_1.add(textOrders);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 24, 65, 20);
		panel_1.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(74, 24, 140, 23);
		panel_1.add(textPassword);
		
		btnFind = new JButton("Find");
		btnFind.setBounds(212, 60, 89, 23);
		btnFind.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textPhone.getText()!=null)
				{
					Employee employee = CtrEmp.findByPhone(textPhone.getText());
					//System.out.println("done");
					textPassword.setText(employee.getPassword());
					textName.setText(employee.getName());
					textOrders.setText(employee.getOrder());
					textAddress.setText(employee.getAddress());
					textPhone.setText(employee.getPhoneno());
					
					
					lblError.setText("command completed");
				}
				else
				{
					lblError.setText("insert phone no");
				}
			}
			
		});
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(212, 24, 89, 23);
		btnAdd.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textPassword.getText().length()>0 && textName.getText().length()>0  && textOrders.getText().length()>0 &&  textAddress.getText().length()>0 && textPhone.getText().length()>0 )
				{
					Employee employee = new Employee();
					employee.setPassword(textPassword.getText());
					employee.setName(textName.getText());
					employee.setOrder(textOrders.getText());
					employee.setAddress(textAddress.getText());
					employee.setPhoneno(textPhone.getText());
					CtrEmp.insertNew(employee);
					lblError.setText("employee added");
				}
				else
				{
					lblError.setText("fill all fields");
				}
			}
			
		});
		panel_1.add(btnAdd);
		panel_1.add(btnFind);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(74, 129, 140, 20);
		panel_1.add(textPhone);
		
		JLabel lblPhoneno = new JLabel("PhoneNo");
		lblPhoneno.setBounds(10, 129, 65, 20);
		panel_1.add(lblPhoneno);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(212, 94, 89, 23);
		btnUpdate.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textPassword.getText().length()>0 && textName.getText().length()>0  && textOrders.getText().length()>0 &&  textAddress.getText().length()>0 && textPhone.getText().length()>0 )
				{
					CtrEmp.updateEmp(textPassword.getText(), textName.getText(), textOrders.getText(), textAddress.getText(),textPhone.getText());
					lblError.setText("employee updated");
				}
				else
				{
					lblError.setText("fill all fields");
				}
			}
			
		});
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(212, 129, 89, 23);
		btnDelete.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textPhone.getText().length()>0){
					CtrEmp.delete(textPhone.getText());
					lblError.setText("Employee was deleted");
					textPassword.setText("");
					textName.setText("");
					textOrders.setText("");
					textAddress.setText("");
					textPhone.setText("");
					

				}
				else{
				lblError.setText("Sorry I couldn't delete employee");
				textPassword.setText("");
				textName.setText("");
				textOrders.setText("");
				textAddress.setText("");
				textPhone.setText("");
				

			}
		}
			
		});
		panel_1.add(btnDelete);
		
		lblError = new JLabel("");
		lblError.setBounds(10, 191, 214, 48);
		panel_1.add(lblError);
		
	}

	public static void main(String[] args) {
		ManageAEmployee start = new ManageAEmployee();
		start.setVisible(true);
		start.setLocationRelativeTo(null);


	}
}
