package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.CtrProduct;
import Control.CtrTPU;
import Model.TPU;

public class TransportPriceUpdate extends JFrame{
	private JTextField textPrice;
	private JButton btnFind;
	private JButton btnUpdate;
	private CtrProduct CtrProduct = new CtrProduct();
	public TransportPriceUpdate() {

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 317, 152);
		this.setTitle("Transport price update");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPrice.setBounds(6, 16, 71, 38);
		panel.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setBounds(72, 22, 106, 32);
		panel.add(textPrice);
		textPrice.setColumns(10);
		
		btnFind = new JButton("Find");
		btnFind.setBounds(189, 6, 106, 38);
		panel.add(btnFind);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(190, 49, 106, 38);
		panel.add(btnUpdate);
		
		final JLabel lblError = new JLabel("");
		lblError.setBounds(6, 85, 305, 38);
		panel.add(lblError);
		
		btnUpdate.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if( textPrice.getText().length()>0)
				{
					CtrTPU.updatePrice(textPrice.getText());
					lblError.setText("Price updated");
				}
				else
				{
					lblError.setText("Price field can't be empty");
				}
			}
			
		});
		btnFind.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					TPU Tpu = CtrTPU.findPrice();
					textPrice.setText(Tpu.getPrice());
			}
			
		});	
	}

	public static void main(String[] args) {
		TransportPriceUpdate start = new TransportPriceUpdate();
		start.setVisible(true);
		start.setLocationRelativeTo(null);


	}
}
