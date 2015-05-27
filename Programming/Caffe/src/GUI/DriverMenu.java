package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DriverMenu extends JFrame {
private static String address;
private JTextField textAddress;

public DriverMenu(){
		
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 416, 122);
		getContentPane().setLayout(null);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(6, 6, 61, 16);
		getContentPane().add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setBounds(65, 0, 307, 28);
		getContentPane().add(textAddress);
		textAddress.setColumns(10);	
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(145, 40, 117, 29);
		
		btnOk.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
					{
					address = textAddress.getText();
					Driver driver = new Driver();
					driver.email(address);
					}
			});
		getContentPane().add(btnOk);
	}
		public static String getAddress()
			{
				return address;
			}
		 public static void main(String[] args) {
			 	DriverMenu menu = new DriverMenu();
			 	menu.setVisible(true);
			 	menu.setLocationRelativeTo(null);
		 }
}
