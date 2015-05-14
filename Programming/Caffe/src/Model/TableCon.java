package Model;

import java.util.ArrayList;

public class TableCon {

	private ArrayList<TableInfo> tableArray = new ArrayList<TableInfo>();
	public TableCon()
	{
		TableInfo table = new TableInfo(0);
		tableArray.add(table);
		tableArray.add(table);
		tableArray.add(table);
		tableArray.add(table);
	}
	public void addTable(int num, TableInfo table)
	{
		tableArray.add(num, table);
	}
	public TableInfo getTable(int num)
	{
		TableInfo table = tableArray.get(num);
		return table;
	}
}
