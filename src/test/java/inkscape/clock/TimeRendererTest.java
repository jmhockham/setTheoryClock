package inkscape.clock;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TimeRendererTest {

	public static final String RED_SYMBOL = "R";
	public static final String YELLOW_SYMBOL = "Y";
	public static final String UNLIT_SYMBOL = ".";
	
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
		assertTrue(false);
	}

	@Test
	public void testGetFirstRowDisplay() {
		assertTrue(false);
	}

	@Test
	public void testGetSecondRowDisplay() {
		assertTrue(false);
	}

	@Test
	public void testGetThirdRowDisplay() {
		assertTrue(false);
	}

	@Test
	public void testGetFourthRowDisplay() {
		assertTrue(false);
	}
	
}
