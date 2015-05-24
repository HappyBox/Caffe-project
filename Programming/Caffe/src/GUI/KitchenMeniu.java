package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import Control.CtrDish;
import Model.Dish;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Window.Type;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class KitchenMeniu extends JFrame{
	
	private ArrayList<Dish> dishList;
	private JPanel contentPane;
	private JList list;
	private JButton btnRefresh;
	private DefaultListModel listControl = new DefaultListModel();
	private CtrDish ctrDish = new CtrDish();
	private JScrollPane scrollPane;
	public KitchenMeniu() {
		setTitle("Ready");
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 265, 172);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CtrDish ctrDish = new CtrDish();
				print();
			}
		});
		btnRefresh.setBounds(160, 11, 89, 23);
		panel.add(btnRefresh);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 140, 122);
		panel.add(scrollPane);
		
		list = new JList(listControl);
		scrollPane.setViewportView(list);
		list.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent evt) {
		        //JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            // Double-click detected
		            int index = list.locationToIndex(evt.getPoint());
		            ctrDish.deleteOrder(dishList.get(index).getId());
		            print();
		        }
		    }
		});
		print();
	}
	public void print()
	{
		listControl.clear();
		dishList = ctrDish.findOne(1);
		for(int i = 0; i<dishList.size(); i++)
		{
			listControl.addElement(dishList.get(i).getName());
		}
	}
}
