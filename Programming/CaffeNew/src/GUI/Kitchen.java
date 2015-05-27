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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Kitchen extends JFrame{
	
	private ArrayList<Dish> dishList;
	private JPanel contentPane;
	private JList list;
	private JButton btnRefresh;
	private DefaultListModel listControl = new DefaultListModel();
	private CtrDish ctrDish = new CtrDish();
	private JPanel panel;
	private JScrollPane scrollPane;
	public Kitchen() {
		setTitle("Kitchen");
		setResizable(false);
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 177);
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CtrDish ctrDish = new CtrDish();
				print();
			}
		});
		btnRefresh.setBounds(297, 11, 89, 23);
		panel.add(btnRefresh);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 279, 124);
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
		            dishList.get(index).setAvailable(1);
		            ctrDish.updateOrder(dishList.get(index).getId(), dishList.get(index).getName(), dishList.get(index).getPrice(), dishList.get(index).getAvailable());
		            print();
		        }
		    }
		});
		print();
	}
	public void print()
	{
		listControl.clear();
		dishList = ctrDish.findOne(0);
		for(int i = 0; i<dishList.size(); i++)
		{
			listControl.addElement(dishList.get(i).getName());
		}
	}
}
