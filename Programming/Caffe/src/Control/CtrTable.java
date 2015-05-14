package Control;

import Model.*;

public class CtrTable {
	private Integer number;
	private Customer tempCus;
	//private TableInfo table;
	private TableCon tableCon = new TableCon();
	public CtrTable()
	{
		
	}
	public void addCustomer(Customer cus)
	{
		tempCus = cus;
	}
	public void setTable(int num)
	{
		
		TableInfo table = new TableInfo(num);
		table.setCustomer(tempCus);
		tableCon.addTable(num,table);
		System.out.println("eina");
	}
	public TableInfo getTable(int num)
	{
		TableInfo table = tableCon.getTable(num);
		return table;
	}
}