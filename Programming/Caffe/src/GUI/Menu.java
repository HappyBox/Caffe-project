package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import Control.CtrDish;
import Control.CtrTable;
import Model.Customer;
import Model.Dish;

public class Menu extends JFrame {

	private JPanel contentPane;
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
	public Menu(int tableNumber, CtrTable ctrTable) {
		
		bill = 0;
		Customer cus = ctrTable.getCustomer(tableNumber);
		setTitle("Customer: " + cus.getName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Cancel");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newList.size()==0 && cus.getOrders().size()==0)
				{
					ctrTable.setCustomer(tableNumber, false);
					ctrTable.getCustomer(tableNumber).reset();
				}
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
				Dish dish = new Dish();
				dish.setName("Fried bread");
				dish.setPrice(20);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnStarters.add(mntmFriedBread);
		
		mntmCheese = new JMenuItem("Cheese");
		mntmCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Cheese");
				dish.setPrice(10);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnStarters.add(mntmCheese);
		
		mnSoups = new JMenu("Soups");
		menuBar.add(mnSoups);
		
		mntmMushrooms = new JMenuItem("Mushrooms");
		mntmMushrooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Mushrooms");
				dish.setPrice(39);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnSoups.add(mntmMushrooms);
		
		mnPizzas = new JMenu("Pizzas");
		menuBar.add(mnPizzas);
		
		mntmMargarita = new JMenuItem("Margarita");
		mntmMargarita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Margarita");
				dish.setPrice(50);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnPizzas.add(mntmMargarita);
		
		mntmHavaii = new JMenuItem("Havaii");
		mntmHavaii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Havaii");
				dish.setPrice(55);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnPizzas.add(mntmHavaii);
		
		mntmFormagio = new JMenuItem("Formagio");
		mntmFormagio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Formagio");
				dish.setPrice(69);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnPizzas.add(mntmFormagio);
		
		mnDrinks = new JMenu("Drinks");
		menuBar.add(mnDrinks);
		
		mntmCola = new JMenuItem("Cola");
		mntmCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Cola");
				dish.setPrice(15);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnDrinks.add(mntmCola);
		
		mntmVine = new JMenuItem("Vine");
		mntmVine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Vine");
				dish.setPrice(120);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnDrinks.add(mntmVine);
		
		mntmBeer = new JMenuItem("Beer");
		mntmBeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Beer");
				dish.setPrice(25);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnDrinks.add(mntmBeer);
		
		mnDeserts = new JMenu("Deserts");
		menuBar.add(mnDeserts);
		
		mntmIceCream = new JMenuItem("Ice cream");
		mntmIceCream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Ice cream");
				dish.setPrice(49);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnDeserts.add(mntmIceCream);
		
		mnMealOfA = new JMenu("meal of a day");
		menuBar.add(mnMealOfA);
		
		mntmDaySoup = new JMenuItem("Day soup");
		mntmDaySoup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Day soup");
				dish.setPrice(45);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnMealOfA.add(mntmDaySoup);

		mntmDrink = new JMenuItem("Drink");
		mntmDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dish dish = new Dish();
				dish.setName("Drink");
				dish.setPrice(15);
				dish.setAvailable(0);
				newList.add(dish);
				//cus.addDish(dish);
				print(cus);
			}
		});
		mnMealOfA.add(mntmDrink);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 414, 139);
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
		
		btnOk = new JButton("Confirm");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm(cus,ctrTable);
				win.dispose();
			}
		});
		btnOk.setBounds(236, 228, 89, 23);
		contentPane.add(btnOk);
		
		btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm(cus,ctrTable);
				if(tableNumber == 0)
				{
					// send Email
					Driver driver = new Driver(cus);
					driver.email();
				}
				saveInvoice(cus);
				ctrTable.setCustomer(tableNumber, false);
				ctrTable.getCustomer(tableNumber).reset();
				
				win.dispose();
			}
		});
		btnPay.setBounds(10, 228, 126, 23);
		contentPane.add(btnPay);
		
		label = new JLabel("");
		label.setBounds(10, 188, 89, 14);
		contentPane.add(label);
		print(cus);
	}
	public void confirm(Customer cus, CtrTable ctrTable)
	{
		CtrDish ctrDish = new CtrDish();
		oldnew(cus);
		for(Dish dish:newList)
		{
			dish.setId(ctrTable.getGen().genID());
			ctrDish.insertOrder(dish);
		}
	}
	public String format(String name)
	{
		while(name.length()<20)
		{
			name += " ";
		}
		return name;
	}
	public void oldnew(Customer cus) {
		for(Dish dish:newList)
		{
			cus.addDish(dish);
		}
	}
	public void print(Customer cus)
	{
		bill = 0;
		ArrayList<Dish> orders = cus.getOrders();
		listControl.clear();
		for(Dish dish:orders)
		{
			listControl.addElement(dish.getName()+dish.getPrice()+" kr");
		}
		label.setText("In total: " + cus.getBill());
		for(Dish dish:newList)
		{
			bill = bill + dish.getPrice();
			listControl.addElement(format(dish.getName())+dish.getPrice()+" kr");
		}
		bill += cus.getBill();
		label.setText("In total: " + bill);
	}
	public void saveInvoice(Customer cus)
	{
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			PrintWriter writer = new PrintWriter("invoice-"+cus.getPhone()+".txt", "UTF-8");
			writer.println("     Pizza Lounge");
			writer.println();
			writer.println("----------------------");
			for(Dish dish: cus.getOrders())
			{
				writer.println(dish.getName()+dish.getPrice());
			}
			writer.println("----------------------");
			writer.println("Total: "+cus.getBill() + " kr");
			writer.println("----------------------");
			writer.println("Customer: ****"+ cus.getPhone().substring(4, 8));
			writer.println("");
			writer.println(dateFormat.format(date));
			writer.println("");
			writer.println("     Pizza Lounge*");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	public void setWindow(Menu win)
	{
		this.win = win;
	}
}
