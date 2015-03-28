package GUI;
import Control.CtrEmployee;
import Model.Employee;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

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
					CtrEmployee ctrEmployee = new CtrEmployee();
					Employee employee = ctrEmployee.searchByPassword(password.getText());
					if(employee.getPassword().intern() == password.getText().intern())
					{
						System.out.println("Logged on");
						lblError.setText("");
					}
					else
					{
						lblError.setText("Wrong password");
						System.out.println(password.getText()+"*");
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
