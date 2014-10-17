package is.kvaldik.stringcalculator;


public class StringCalculator
{
	public static int add(String text)
	{
		if (text == "")
			return 0;
		else if (text.contains(","))
		{
			int returnValue = 0;
			String[] numbers = text.split(",");
			for (String number : numbers)
				returnValue += Integer.parseInt(number);
			return returnValue;
		}
		else
			return Integer.parseInt(text);
	}
}