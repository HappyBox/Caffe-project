package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.CtrTable;
import Model.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
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
	private JList list;
	private DefaultListModel listControl = new DefaultListModel();
	private JButton btnBack;
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
	public Menu(Customer cus) {
		print(cus);
		setTitle("Customer: " + cus.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dispose();
			}
		});
		btnBack.setBounds(335, 228, 89, 23);
		contentPane.add(btnBack);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		mnStarters = new JMenu("Starters");
		menuBar.add(mnStarters);
		
		mntmFriedBread = new JMenuItem("Fried bread");
		mntmFriedBread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cus.addDish("Fried bread", 20);
				print(cus);
			}
		});
		mnStarters.add(mntmFriedBread);
		
		mntmCheese = new JMenuItem("Cheese");
		mntmCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnStarters.add(mntmCheese);
		
		mnSoups = new JMenu("Soups");
		menuBar.add(mnSoups);
		
		mntmDaySoup = new JMenuItem("Day soup");
		mntmDaySoup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnSoups.add(mntmDaySoup);
		
		mntmMushrooms = new JMenuItem("Mushrooms");
		mntmMushrooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnSoups.add(mntmMushrooms);
		
		mnPizzas = new JMenu("Pizzas");
		menuBar.add(mnPizzas);
		
		mntmMargarita = new JMenuItem("Margarita");
		mntmMargarita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPizzas.add(mntmMargarita);
		
		mntmHavaii = new JMenuItem("Havaii");
		mntmHavaii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPizzas.add(mntmHavaii);
		
		mntmFormagio = new JMenuItem("Formagio");
		mntmFormagio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPizzas.add(mntmFormagio);
		
		mnDrinks = new JMenu("Drinks");
		menuBar.add(mnDrinks);
		
		mntmCola = new JMenuItem("Cola");
		mntmCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnDrinks.add(mntmCola);
		
		mntmVine = new JMenuItem("Vine");
		mntmVine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnDrinks.add(mntmVine);
		
		mntmBeer = new JMenuItem("Beer");
		mntmBeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnDrinks.add(mntmBeer);
		
		mnDeserts = new JMenu("Deserts");
		menuBar.add(mnDeserts);
		
		mntmIceCream = new JMenuItem("Ice cream");
		mntmIceCream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnDeserts.add(mntmIceCream);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 414, 190);
		contentPane.add(scrollPane);
		
		list = new JList(listControl);
		scrollPane.setViewportView(list);
	}
	public String format(String old)
	{
		while(old.length()<20)
		{
			old += " ";
		}
		return old;
	}
	public void print(Customer cus)
	{
		ArrayList<String> orders = cus.getOrders();
		listControl.clear();
		for(String order:orders)
		{
			listControl.addElement(order);
		}
	}
	public void setWindow(Menu win)
	{
		this.win = win;
	}
}
