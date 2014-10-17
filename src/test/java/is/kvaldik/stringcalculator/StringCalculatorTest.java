package is.kvaldik.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class StringCalculatorTest
{
	@Test
	public void testEmptyString()
	{
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void testOneNumber()
	{
		assertEquals(1, StringCalculator.add("1"));
	}
}