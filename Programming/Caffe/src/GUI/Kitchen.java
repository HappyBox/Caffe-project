package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Control.CtrTable;
import Model.Dish;
import Model.Customer;

public class Kitchen extends JFrame{
private JPanel contentPane;
private JList list;
private CtrTable ctrTable;
private Menu win;
private JMenuBar menuBar;
private JMenu mnStarters;
private JMenuItem mntmFriedBread;
private JMenuItem mntmCheese;
private JMenu mnSoups;
private JMenuItem mntmDaySoup;
private JMenuItem mntmMushrooms;
private JMenu mnPizzas;
private JMenuItem mntmMargarita;
private JMenuItem mntmHavaii;
private JMenuItem mntmFormagio;
private JMenuItem mntmCola;
private JMenuItem mntmVine;
private JMenuItem mntmBeer;
private JMenu mnDeserts;
private JMenu mnDrinks;
private JMenuItem mntmIceCream;
private DefaultListModel listControl = new DefaultListModel();
private JButton btnBack;
private JMenuItem mntmDrink;
private JMenu mnMealOfA;
private JLabel label;
private JButton btnPay;
private JButton btnOk;
private Integer bill;
private ArrayList<Dish> newList = new ArrayList<Dish>();

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			/*
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Menu frame = new Menu();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			*/
		}
		/**
		 * Create the frame.
		 */
	/*	
	 * public Kitchen(Customer.getOrders()) {
			Order order = ctrOrder.getOrder(tableNumber);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		public void actionPerformed(ActionEvent e) {
			Dish dish = new Dish();
			dish.setName("Day soup");
			dish.setPrice(25);
			dish.setAvailable(0);
			newList.add(dish);
			//cus.addDish(dish);
			print(cus);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 266);
		contentPane.add(scrollPane);
		list = new JList(listControl);
		list.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent evt) {
		        //JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            // Double-click detected
		            int index = list.locationToIndex(evt.getPoint());
		            if(index >= cus.getOrders().size())
		            {
		            	index -= cus.getOrders().size();
		            	newList.remove(index);
		            }
		            else
		            {
		            	cus.removeDish(index);
		            }
		            print(cus);
		        }
		    }
		});
		scrollPane.setViewportView(list);
	}
	
	*/
	

}
