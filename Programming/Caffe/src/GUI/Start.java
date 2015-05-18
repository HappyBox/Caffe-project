package GUI;
import Control.*;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Control.CtrEmployee;
import Model.Employee;

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
				// TODO Auto-generated method stub
				int code = e.getKeyCode();
				if(code == 10)
				{
					try
					{
						CtrEmp ctrEmp = new CtrEmp();
						Employee employee = ctrEmp.findByPassword(password.getText());
						String text = password.getText();
						System.out.println(text);
						if(employee.getPassword().intern() == password.getText().intern())
						{
							CustomerReg cusReg = new CustomerReg();
							cusReg.setVisible(true);
							cusReg.setLocationRelativeTo(null);
						}
						if(text.intern() == "2")
						{
							CustomerReg cusReg = new CustomerReg();
							cusReg.setVisible(true);
							cusReg.setLocationRelativeTo(null);
						}
						if(text.intern() == "3")
						{
							ManagerGUI manager = new ManagerGUI();
							manager.setVisible(true);
							manager.setLocationRelativeTo(null);
						
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
