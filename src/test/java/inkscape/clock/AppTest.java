package inkscape.clock;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class AppTest {
	private App a = new App();
	private static final String DATE_PATTERN_TEST = "yyyy.MM.dd 'at' HH:mm:ss";

	@Test
	public void testGetDateFormat() {
		Calendar today = new GregorianCalendar();
		SimpleDateFormat testDateFormatter = new SimpleDateFormat(DATE_PATTERN_TEST);
		String testFormatterResult = testDateFormatter.format(today.getTime());
		String appFormatterResult = a.getDateFormat().format(today.getTime());
		assertEquals(appFormatterResult, testFormatterResult);
	}

	@Test
	public void testGetCalendar() {
		Calendar today = a.getCalendar();
		assertNotNull(today);
		assertTrue(today instanceof Calendar);
	}
}
