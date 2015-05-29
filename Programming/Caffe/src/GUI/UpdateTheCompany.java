package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class UpdateTheCompany extends JFrame{
	private JButton btnFind;
	private JButton btnUpdate;
	private String company = "There is wrote company informations!";
	public UpdateTheCompany() {

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 444, 206);
		this.setTitle("Update the company informations");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnFind = new JButton("Find");
		btnFind.setBounds(332, 6, 106, 38);
		panel.add(btnFind);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(332, 56, 106, 38);
		panel.add(btnUpdate);
		
		final JLabel lblError = new JLabel("");
		lblError.setBounds(6, 144, 323, 34);
		panel.add(lblError);
		
		JTextArea text = new JTextArea();
		text.setBounds(10, 6, 310, 133);
		panel.add(text);
		
		btnFind.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(company);
			}
			
		});	
		
		btnUpdate.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if( text.getText().length()>0)
				{
					company = text.getText();
					lblError.setText("Informations updated");
				}
				else
				{
					lblError.setText("Informations field can't be empty");
				}
			}
			
		});
		
	}

	public void main(String[] args) {
		UpdateTheCompany start = new UpdateTheCompany();
		start.setVisible(true);
		start.setLocationRelativeTo(null);


	}
}
