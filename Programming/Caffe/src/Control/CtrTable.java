package Control;

import java.util.ArrayList;

import Model.*;

public class CtrTable {
	private Integer number;
	private Customer tempCus;
	private Employee tempEmp;
	private TableInfo table;
	private boolean customerSet = false;
	private ArrayList<TableInfo> tableCon = new ArrayList<TableInfo>();
	public CtrTable()
	{
		for(int i = 0; i<=21;i++)							// 0 for driver
		{
			table = new TableInfo();
			tableCon.add(table);
		}
	}
	public void addEmployee(Employee emp)
	{
		for(int i = 0; i<=21;i++)							// 0 for driver
		{
			tableCon.get(i).addEmp(emp);
		}
	}
	
	public void addCustomer(int i, Customer cus)                  //move all info to model layer
	{
		tableCon.get(i).addCus(cus);
		setCustomer(i, true);
	}
	public Customer getCustomer(int i)
	{
		return tableCon.get(i).getCus();
	}
	public void setCustomer(int i, boolean v)
	{
		tableCon.get(i).setCus(v);
	}
	public boolean customerIsSet(int i)
	{
		return tableCon.get(i).cusIsSet();
	}
	public void setTable(int num)
	{
		if (table == null)
		{
			//table = new TableInfo(num);
			System.out.println("new table set");
		}
		
		//table.setCustomer(tempCus);
		//tableCon.addTable(num,table);
	}
	public TableInfo getTable(int num)
	{
		//TableInfo table = tableCon.getTable(num);
		return table;
	}
}