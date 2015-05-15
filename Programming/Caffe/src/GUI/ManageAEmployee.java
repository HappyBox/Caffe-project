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
import java.awt.Font;

public class ManageAEmployee extends JFrame{
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textCity;
	private JTextField textPhone;
	private JTextField textPassword;
	private JTextField textEmail;
	private JTextField textAccNum;
	private JButton btnAdd;
	private JButton btnFind;
	private JButton btnUpdate;
	private JButton btnDelete;
	private CtrEmp CtrEmp = new CtrEmp();
	private JLabel lblError;

		public ManageAEmployee() {

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 432, 355);
		this.setTitle("Manage a employee");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setName("");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 6, 420, 318);
		panel.add(panel_1);
		
		JLabel lblName = new JLabel("    Name");
		lblName.setBounds(10, 23, 65, 22);
		panel_1.add(lblName);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(74, 22, 244, 23);
		panel_1.add(textName);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(74, 57, 244, 20);
		panel_1.add(textAddress);
		
		JLabel lblAddress = new JLabel("  Address");
		lblAddress.setBounds(10, 57, 65, 20);
		panel_1.add(lblAddress);
		
		JLabel lblCity = new JLabel("     City");
		lblCity.setBounds(10, 93, 65, 20);
		panel_1.add(lblCity);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(74, 93, 244, 20);
		panel_1.add(textCity);
		
		JLabel lblPhoneno = new JLabel("   Phone");
		lblPhoneno.setBounds(10, 129, 65, 20);
		panel_1.add(lblPhoneno);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(74, 129, 244, 20);
		panel_1.add(textPhone);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 159, 65, 20);
		panel_1.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setBounds(74, 161, 244, 23);
		panel_1.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblEmail = new JLabel("   E-mail");
		lblEmail.setBounds(10, 202, 65, 20);
		panel_1.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(74, 200, 244, 23);
		panel_1.add(textEmail);
		
		JLabel lblAccnum = new JLabel("  AccNum");
		lblAccnum.setBounds(10, 234, 65, 20);
		panel_1.add(lblAccnum);
		
		textAccNum = new JTextField();
		textAccNum.setColumns(10);
		textAccNum.setBounds(74, 235, 244, 23);
		panel_1.add(textAccNum);
		
		btnFind = new JButton("Find");
		btnFind.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnFind.setBounds(325, 89, 89, 42);
		btnFind.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textPhone.getText()!=null)
				{
					Employee employee = CtrEmp.findByPhone(textPhone.getText());
					//System.out.println("done");
					textName.setText(employee.getName());
						textAddress.setText(employee.getAddress());
							textCity.setText(employee.getCity());
								textPhone.setText(employee.getPhone_no());
									textPassword.setText(employee.getPassword());
										textEmail.setText(employee.getEmail());
											textAccNum.setText(employee.getAccNum());
					
					
					
					
					lblError.setText("command completed");
				}
				else
				{
					lblError.setText("insert phone no");
				}
			}
			
		});
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdd.setBounds(325, 23, 89, 42);
		btnAdd.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textName.getText().length()>0  && textAddress.getText().length()>0 && textCity.getText().length()>0 && textPhone.getText().length()>0 && textPassword.getText().length()>0 && textEmail.getText().length()>0 && textAccNum.getText().length()>0 )
				{
					Employee employee = new Employee();
						employee.setName(textName.getText());
							employee.setAddress(textAddress.getText());
								employee.setCity(textCity.getText());
									employee.setPhone_no(textPhone.getText());
										employee.setPassword(textPassword.getText());
											employee.setEmail(textEmail.getText());
												employee.setAccNum(textAccNum.getText());
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
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnUpdate.setBounds(325, 143, 89, 42);
		btnUpdate.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textName.getText().length()>0  && textAddress.getText().length()>0 && textCity.getText().length()>0 && textPhone.getText().length()>0 && textPassword.getText().length()>0 && textEmail.getText().length()>0 && textAccNum.getText().length()>0 )
				{
					CtrEmp.updateEmp(textName.getText(), textAddress.getText(), textCity.getText(), textPhone.getText(), textPassword.getText(), textEmail.getText(), textAccNum.getText());
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
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnDelete.setBounds(325, 202, 89, 42);
		btnDelete.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textPhone.getText().length()>0){
					CtrEmp.delete(textPhone.getText());
					lblError.setText("Employee was deleted");
					textName.setText("");
					textAddress.setText("");
					textCity.setText("");
					textPhone.setText("");
					textPassword.setText("");
					textEmail.setText("");
					textAccNum.setText("");
				}
				else{
				lblError.setText("Sorry I couldn't delete employee");
				textName.setText("");
				textAddress.setText("");
				textCity.setText("");
				textPhone.setText("");
				textPassword.setText("");
				textEmail.setText("");
				textAccNum.setText("");

			}
		}
			
		});
		panel_1.add(btnDelete);
		
		lblError = new JLabel("");
		lblError.setBounds(10, 266, 214, 48);
		panel_1.add(lblError);
		
	}

	public static void main(String[] args) {
		ManageAEmployee start = new ManageAEmployee();
		start.setVisible(true);
		start.setLocationRelativeTo(null);


	}
}
