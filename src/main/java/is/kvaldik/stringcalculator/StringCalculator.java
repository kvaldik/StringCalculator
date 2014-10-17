package is.kvaldik.stringcalculator;


public class StringCalculator
{
	public static int add(String text)
	{
		if (text == "")
			return 0;
		else
			return Integer.parseInt(text);
	}
}