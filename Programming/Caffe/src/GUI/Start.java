package GUI;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Control.CtrEmp;
import Control.CtrMngr;
import Control.CtrTable;
import Model.Employee;
import Model.Manager;

public class Start extends JFrame {
	private JPasswordField password;
	private JLabel lblError;
	public Start() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 200, 100);
		this.setTitle("Login");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 11, 69, 20);
		panel.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(93, 11, 81, 20);
		password.addKeyListener(new java.awt.event.KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				
				int code = e.getKeyCode();
				if(code == 10)
				{
					try
						{
							CtrEmp ctrEmp = new CtrEmp();
							Employee employee = ctrEmp.findByPassword(password.getText());
							if(employee.getPassword().intern() == password.getText().intern())
							{
								CtrTable ctrTable1 = new CtrTable();
								CtrTable ctrTable2 = new CtrTable();
								CtrTable ctrTable3 = new CtrTable();
								ctrTable1.addEmployee(employee);
								CustomerReg cusReg = new CustomerReg(employee, ctrTable1, ctrTable2, ctrTable3);
								cusReg.setVisible(true);
								cusReg.setLocationRelativeTo(null);	
							}
						}
						catch(Exception as)
							{
								lblError.setText("Wrong password");
							}
					try 
						{
							CtrMngr ctrMngr = new CtrMngr();
							Manager manager = ctrMngr.findByPassword(password.getText());
							String text = password.getText();
							System.out.println(text);
							
							if(manager.getPassword().intern() == password.getText().intern())
							{
								ManagerGUI managerGUI = new ManagerGUI();
								managerGUI.setVisible(true);
								managerGUI.setLocationRelativeTo(null);
							
							}
					}
					catch(Exception as)
					{
						lblError.setText("Wrong password");
					}
					
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel.add(password);
		
		lblError = new JLabel("");
		lblError.setBounds(10, 37, 164, 14);
		panel.add(lblError);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Code starts here!");
		Start start = new Start();
		start.setVisible(true);
		start.setLocationRelativeTo(null);
	}
}
