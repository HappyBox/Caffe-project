package GUI;

import Control.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Product extends JFrame {
	private JButton btnPotato;
	private JButton btnPica;
	private JButton btnCola;
	private JButton btnBack;
	private CtrProduct ctrProduct = new CtrProduct();
	public Product(CtrTable table) {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 400, 200);
		this.setTitle("Product list");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnPotato = new JButton("Potato");
		btnPotato.setBounds(10, 11, 89, 23);
		btnPotato.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//table.add(ctrProduct.get("product_name"));
			}
		});
		panel.add(btnPotato);
		
		btnPica = new JButton("Pica");
		btnPica.setBounds(109, 11, 89, 23);
		btnPica.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(btnPica);
		
		btnCola = new JButton("Cola");
		btnCola.setBounds(208, 11, 89, 23);
		btnCola.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(btnCola);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 45, 89, 23);
		btnBack.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(btnBack);
	}

}
