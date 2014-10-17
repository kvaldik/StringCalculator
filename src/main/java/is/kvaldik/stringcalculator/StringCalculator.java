package is.kvaldik.stringcalculator;

import java.util.regex.Pattern;


public class StringCalculator
{
	public static int add(String text)
	{
		if (text.length() > 2)
			if (text.substring(0,2).equals("//"))
			{
				char delimiter = text.charAt(2);
				String text2 = text.substring(4);
				return addNumbers(text2.split(Pattern.quote(String.valueOf(delimiter))));
			}
		if (text == "")
			return 0;
		else if (text.contains(",") || text.contains("\n"))
		{
			return addNumbers(text.split("[,\n]"));
		}
		else
			return Integer.parseInt(text);
	}

	private static int addNumbers(String[] numbers)
	{
		int returnValue = 0;
		for (String number : numbers)
			returnValue += Integer.parseInt(number);
		return returnValue;
	}
}