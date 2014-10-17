package is.kvaldik.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


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

	@Test
	public void testTwoNumbers()
	{
		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
	public void testThreeNumbers()
	{
		assertEquals(6, StringCalculator.add("1,2,3"));
	}

	@Test
	public void testSixNumbers()
	{
		assertEquals(21, StringCalculator.add("1,2,3,4,5,6"));
	}

	@Test
	public void testCommaAndLineBreak()
	{
		assertEquals(21, StringCalculator.add("1,2\n3,4\n5,6"));
	}

	@Test
	public void testLineBreak()
	{
		assertEquals(10, StringCalculator.add("1\n2\n3\n4"));
	}

	@Test
	public void testDelimiterSemiColon()
	{
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}

	@Test
	public void testDelimiterStar()
	{
		assertEquals(6, StringCalculator.add("//*\n1*2*3"));
	}

 	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNegativeNumber()
	{
	    thrown.expect(IllegalArgumentException.class);
	    thrown.expectMessage("Negatives not allowed: -1");
		StringCalculator.add("-1");
	}

	@Test
	public void testNegativeNumbers()
	{
	    thrown.expect(IllegalArgumentException.class);
	    thrown.expectMessage("Negatives not allowed: -1,-3");
		StringCalculator.add("-1,4,5\n-3,6");
	}

	@Test
	public void testBigNumber()
	{
		assertEquals(0, StringCalculator.add("1001"));
	}

	@Test
	public void testBigNumbers()
	{
		assertEquals(5, StringCalculator.add("1001,2,3\n2000"));
	}

	@Test
	public void testLongDelimiterSemiColon()
	{
		assertEquals(6, StringCalculator.add("//[;;;]\n1;;;2;;;3"));
	}

	@Test
	public void testLongDelimiterStar()
	{
		assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
	}
}