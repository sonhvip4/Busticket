package busticket.utils;

public class CalculationHelper {

	public CalculationHelper() {
		// TODO Auto-generated constructor stub
	}

	public static int rouding(int numberFilm,int row)
	{
		int result;
		if(numberFilm%row!=0)
		{
			result=numberFilm/row+1;
		}
		else
		{
			result=numberFilm/row;
		}
		return result;
		
	}
}
