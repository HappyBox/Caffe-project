package Control;

import Model.*;

public class CtrTable {
	private Integer number;
	private Customer tempCus;
	private TableInfo table;
	private boolean customerSet = false;
	private TableCon tableCon = new TableCon();
	public CtrTable()
	{
		
	}
	public void addCustomer(Customer cus)                  //move all info to model layer
	{
		tempCus = cus;
		setCustomer(true);
	}
	public Customer getCustomer()
	{
		return tempCus;
	}
	public void setCustomer(boolean v)
	{
		customerSet = v;
	}
	public boolean customerIsSet()
	{
		return customerSet;
	}
	public void setTable(int num)
	{
		if (table == null)
		{
			table = new TableInfo(num);
			System.out.println("new table set");
		}
		
		table.setCustomer(tempCus);
		tableCon.addTable(num,table);
	}
	public TableInfo getTable(int num)
	{
		TableInfo table = tableCon.getTable(num);
		return table;
	}
}