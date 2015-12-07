package inkscape.clock;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TimeRendererTest {

	public static final String RED_SYMBOL = "R";
	public static final String YELLOW_SYMBOL = "Y";
	public static final String UNLIT_SYMBOL = ".";
	private static final String FIRST_ROW_TEST_VALUE = "R...";
	private static final String SECOND_ROW_TEST_VALUE = "....";
	private static final String THIRD_ROW_TEST_VALUE = "YYRY.......";
	private static final String FOURTH_ROW_TEST_VALUE = "Y...";
	
	private Calendar datetime;
	private TimeRenderer timeRenderer;
	
	public TimeRendererTest() {
		datetime = new GregorianCalendar(1985, 10, 26, 1, 21, 33);
		timeRenderer = new TimeRenderer(datetime);
	}
	
	@Test
	public void testGetRedSymbol() {
		assertTrue(timeRenderer.getRedSymbol().equals(RED_SYMBOL));
	}

	@Test
	public void testGetYellowSymbol() {
		assertTrue(timeRenderer.getYellowSymbol().equals(YELLOW_SYMBOL));
	}

	@Test
	public void testGetUnlitSymbol() {
		assertTrue(timeRenderer.getUnlitSymbol().equals(UNLIT_SYMBOL));
	}

	@Test
	public void testGetSecondsDisplay() {
		assertTrue(timeRenderer.getSecondsDisplay().equals(YELLOW_SYMBOL));
	}

	@Test
	public void testGetFirstRowDisplay() {
		String firstRow = timeRenderer.getFirstRowDisplay();
		assertEquals(firstRow, FIRST_ROW_TEST_VALUE);
	}

	@Test
	public void testGetSecondRowDisplay() {
		String secondRow = timeRenderer.getSecondRowDisplay();
		assertEquals(secondRow, SECOND_ROW_TEST_VALUE);
	}

	@Test
	public void testGetThirdRowDisplay() {
		String thirdRow = timeRenderer.getThirdRowDisplay();
		assertEquals(thirdRow, THIRD_ROW_TEST_VALUE);
	}

	@Test
	public void testGetFourthRowDisplay() {
		String fourthRow = timeRenderer.getFourthRowDisplay();
		assertEquals(fourthRow, FOURTH_ROW_TEST_VALUE);
	}
	
}
