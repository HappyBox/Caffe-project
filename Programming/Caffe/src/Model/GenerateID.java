package Model;

public class GenerateID {
	private Integer i;
	public GenerateID()
	{
		i=1000;
	}
	public Integer genID()
	{
		if(i == 9999)
		{
			i = 1000;
		}
		i++;
		return i;
	}
}
