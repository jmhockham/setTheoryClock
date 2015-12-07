package inkscape.clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class App {

	private SimpleDateFormat dateFormat;
	private Calendar calendar;

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public App() {
		dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
		calendar = new GregorianCalendar();
	}

	public static void main(String[] args) {
		App a = new App();
		System.out.println("The current date/time is:" + a.getDateFormat().format(a.getCalendar().getTime()));
		TimeRenderer timeRenderer = new TimeRenderer(a.getCalendar());
		System.out.println(timeRenderer.getSecondsDisplay());
		System.out.println(timeRenderer.getFirstRowDisplay());
		System.out.println(timeRenderer.getSecondRowDisplay());
		System.out.println(timeRenderer.getThirdRowDisplay());
		System.out.println(timeRenderer.getFourthRowDisplay());
	}
}
