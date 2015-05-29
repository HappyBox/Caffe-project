package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import Control.CtrDish;
import Model.Dish;

public class ManageADish extends JFrame{
	private JTextField textName;
	private JTextField textInfo;
	private JTextField textPrice;
	private JButton btnAdd;
	private JButton btnFind;
	private JButton btnUpdate;
	private JButton btnDelete;
	private CtrDish CtrDish = new CtrDish();
	private JLabel lblError;
	private JTextField textCost;
	private JTextField textAvailable;
	private JLabel lblId;
	private JTextField textID;
	public ManageADish() {

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 531, 232);
		this.setTitle("Manage a dish");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setName("");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dish", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 6, 519, 198);
		panel.add(panel_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblName.setBounds(10, 23, 65, 22);
		panel_1.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textName.setColumns(10);
		textName.setBounds(97, 22, 298, 23);
		panel_1.add(textName);
		
		textInfo = new JTextField();
		textInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textInfo.setColumns(10);
		textInfo.setBounds(97, 57, 298, 22);
		panel_1.add(textInfo);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblInfo.setBounds(10, 57, 65, 20);
		panel_1.add(lblInfo);
		
		textCost = new JTextField();
		textCost.setColumns(10);
		textCost.setBounds(97, 122, 89, 20);
		panel_1.add(textCost);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCost.setBounds(10, 121, 65, 20);
		panel_1.add(lblCost);
		
		textAvailable = new JTextField();
		textAvailable.setColumns(10);
		textAvailable.setBounds(306, 127, 28, 20);
		panel_1.add(textAvailable);
		
		JLabel lblAvailable = new JLabel("Available:");
		lblAvailable.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAvailable.setBounds(225, 126, 83, 20);
		panel_1.add(lblAvailable);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(306, 91, 89, 20);
		panel_1.add(textPrice);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPrice.setBounds(238, 91, 56, 20);
		panel_1.add(lblPrice);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblId.setBounds(10, 89, 65, 20);
		panel_1.add(lblId);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(97, 91, 114, 20);
		panel_1.add(textID);
		
		btnFind = new JButton("Find");
		btnFind.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnFind.setBounds(407, 45, 106, 23);
		btnFind.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(textName.getText()!=null)
				{
					Dish dish = CtrDish.findByName(textName.getText());
					//System.out.println("done");
					textID.setText(dish.getId().toString());
					textName.setText(dish.getName());
					textInfo.setText(dish.getInfo());
					textCost.setText(dish.getCost().toString());
					textPrice.setText(dish.getPrice().toString());
					textAvailable.setText(dish.getAvailable().toString());
					lblError.setText("command completed");
				}
				else
				{
					lblError.setText("insert dish name");
				}
			}
			
		});
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAdd.setBounds(407, 22, 106, 23);
		btnAdd.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(textID.getText().length()>0 && textName.getText().length()>0 && textInfo.getText().length()>0 && textCost.getText().length()>0 && textPrice.getText().length()>0 && textAvailable.getText().length()>0)
				{
					Dish dish = new Dish();
					dish.setId(Integer.valueOf(textID.getText()));
					dish.setName(textName.getText());
					dish.setInfo(textInfo.getText());
					dish.setCost(Integer.valueOf(textCost.getText()));
					dish.setPrice(Integer.valueOf(textPrice.getText()));
					dish.setAvailable(Integer.valueOf(textAvailable.getText()));
					CtrDish.insertNew(dish);
					lblError.setText("dish added");
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
		btnUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnUpdate.setBounds(407, 69, 106, 23);
		btnUpdate.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(textID.getText().length()>0 && textName.getText().length()>0  && textInfo.getText().length()>0 && textCost.getText().length()>0 && textPrice.getText().length()>0 && textAvailable.getText().length()>0)
				{
					CtrDish.updateDish(Integer.valueOf(textID.getText()), textName.getText(), textInfo.getText(), Integer.valueOf(textCost.getText()), Integer.valueOf(textPrice.getText()), Integer.valueOf(textAvailable.getText()));
					lblError.setText("dish updated");
				}
				else
				{
					lblError.setText("fill all fields");
				}
			}
			
		});
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnDelete.setBounds(407, 92, 106, 23);
		btnDelete.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(textName.getText().length()>0){
					CtrDish.delete(textName.getText());
					
					lblError.setText("Dish was deleted");
					textID.setText("");
					textName.setText("");
					textInfo.setText("");
					textCost.setText("");
					textPrice.setText("");
					textAvailable.setText("");

				}
				else{
				lblError.setText("Sorry I couldn't delete dish");
				textID.setText("");
				textName.setText("");
				textInfo.setText("");
				textCost.setText("");
				textPrice.setText("");
				textAvailable.setText("");
				

			}
		}
			
		});
		panel_1.add(btnDelete);
		
		lblError = new JLabel("");
		lblError.setBounds(10, 156, 503, 23);
		panel_1.add(lblError);
		
	}

	public static void main(String[] args) {
		ManageADish start = new ManageADish();
		start.setVisible(true);
		start.setLocationRelativeTo(null);


	}
}
