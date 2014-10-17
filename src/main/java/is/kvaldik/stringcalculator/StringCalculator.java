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
				String text2 = text.substring(text.indexOf("\n")+1);
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
			int value = 0;
			if (!number.equals("")) 
				value = Integer.parseInt(number);
			if (value < 0)
				exceptionMessage += number + ",";
			else if (value <= 1000)
				returnValue += value;
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
				String returnDelimiter = "[";
				String delimiter;
				String subText;
				// Check for a long delimiter or multiple delimiters
				if (text.charAt(2) == '[')
				{
					delimiter = text.substring(3, text.indexOf("]"));
					returnDelimiter += Pattern.quote(delimiter);

					// Deal with multiple delimiters
					subText = text.substring(text.indexOf("]")+1);
					while (subText.indexOf("]") >= 0)
					{
						delimiter = subText.substring(1, subText.indexOf("]"));
						returnDelimiter += Pattern.quote(delimiter);
						subText = subText.substring(subText.indexOf("]")+1);
					}
					
				}
				else
				{
					delimiter = text.substring(2, text.indexOf("\n"));
					returnDelimiter += Pattern.quote(delimiter);
				}
				return returnDelimiter + "]";
			}
		}

		// Else return the default delimiter
		return "[,\n]";
	}
}