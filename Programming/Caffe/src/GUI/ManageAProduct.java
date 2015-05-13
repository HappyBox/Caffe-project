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

import Control.CtrProduct;
import Model.Product;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class ManageAProduct extends JFrame{
	private JTextField textName;
	private JTextField textDetails;
	private JTextField textPrice;
	private JButton btnAdd;
	private JButton btnFind;
	private JButton btnUpdate;
	private JButton btnDelete;
	private CtrProduct CtrProduct = new CtrProduct();
	private JLabel lblError;
	public ManageAProduct() {

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 531, 249);
		this.setTitle("Manage a product");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setName("");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Product", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 6, 519, 211);
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(10, 23, 65, 22);
		panel_1.add(label_1);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(74, 22, 321, 23);
		panel_1.add(textName);
		
		textDetails = new JTextField();
		textDetails.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textDetails.setColumns(10);
		textDetails.setBounds(74, 60, 321, 38);
		panel_1.add(textDetails);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(10, 60, 65, 20);
		panel_1.add(lblDetails);
		
		btnFind = new JButton("Find");
		btnFind.setBounds(407, 62, 106, 38);
		btnFind.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(textPrice.getText()!=null)
				{
					Product product = CtrProduct.findByName(textName.getText());
					//System.out.println("done");
					textName.setText(product.getName());
					textDetails.setText(product.getDetails());
					textPrice.setText(product.getPrice());

					lblError.setText("command completed");
				}
				else
				{
					lblError.setText("insert product name");
				}
			}
			
		});
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(407, 16, 106, 38);
		btnAdd.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textPrice.getText().length()>0 && textName.getText().length()>0  && textDetails.getText().length()>0 && textPrice.getText().length()>0)
				{
					Product product = new Product();
					product.setName(textName.getText());
					product.setDetails(textDetails.getText());
					product.setPrice(textPrice.getText());
					CtrProduct.insertNew(product);
					lblError.setText("product added");
				}
				else
				{
					lblError.setText("fill all fields");
				}
			}
			
		});
		panel_1.add(btnAdd);
		panel_1.add(btnFind);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(74, 110, 89, 20);
		panel_1.add(textPrice);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 110, 65, 20);
		panel_1.add(lblPrice);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(407, 112, 106, 38);
		btnUpdate.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textName.getText().length()>0  && textDetails.getText().length()>0 && textPrice.getText().length()>0)
				{
					CtrProduct.updateProduct(textName.getText(), textDetails.getText(), textPrice.getText());
					lblError.setText("product updated");
				}
				else
				{
					lblError.setText("fill all fields");
				}
			}
			
		});
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(407, 162, 106, 38);
		btnDelete.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textName.getText().length()>0){
					CtrProduct.delete(textName.getText());
					
					lblError.setText("Product was deleted");
					textName.setText("");
					textDetails.setText("");
					textPrice.setText("");
				

				}
				else{
				lblError.setText("Sorry I couldn't delete product");
				textName.setText("");
				textDetails.setText("");
				textPrice.setText("");
				

			}
		}
			
		});
		panel_1.add(btnDelete);
		
		lblError = new JLabel("");
		lblError.setBounds(10, 142, 385, 48);
		panel_1.add(lblError);
		
	}

	public static void main(String[] args) {
		ManageAProduct start = new ManageAProduct();
		start.setVisible(true);
		start.setLocationRelativeTo(null);


	}
}
