package is.kvaldik.stringcalculator;


public class StringCalculator
{
	public static int add(String text)
	{
		if (text == "")
			return 0;
		else if (text.contains(","))
		{
			String[] numbers = text.split(",");
			return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
		}
		else
			return Integer.parseInt(text);
	}
}