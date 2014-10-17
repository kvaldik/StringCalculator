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
				return addNumbers(text2.split(getDelimiter(text)));
			}
		if (text == "")
			return 0;
		else if (text.contains(",") || text.contains("\n"))
		{
			return addNumbers(text.split(getDelimiter(text)));
		}
		else
			return addNumbers(new String[] {text});
	}

	private static int addNumbers(String[] numbers)
	{
		int returnValue = 0;
		String exceptionMessage = "Negatives not allowed: ";
		for (String number : numbers)
		{
			int value = Integer.parseInt(number);
			if (value < 0)
				exceptionMessage += number + ",";
			else if (value <= 1000)
				returnValue += Integer.parseInt(number);
		}

		if (exceptionMessage.length() > 23)
			throw new IllegalArgumentException(exceptionMessage.substring(0, exceptionMessage.length()-1));

		return returnValue;
	}

	private static String getDelimiter(String text)
	{
		// Check for custom delimiter
		if (text.length() > 2)
		{
			if (text.substring(0,2).equals("//"))
			{
				char delimiter = text.charAt(2);
				return Pattern.quote(String.valueOf(delimiter));
			}
		}

		// Else return the default delimiter
		return "[,\n]";
	}
}