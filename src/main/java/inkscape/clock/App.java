package inkscape.clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class App {
	
	private SimpleDateFormat dateFormat;
	private static Calendar calendar;

	public App() {
		dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
		calendar = new GregorianCalendar();
	}
	
	public static void main(String[] args) {
		App a = new App();
		System.out.println("The current date/time is:" + calendar.getTime());
		System.out.println("seconds diplayed here");
		System.out.println("first row displayed here");
		System.out.println("second row displayed here");
		System.out.println("third row displayed here");
		System.out.println("fourth row displayed here");
	}
}
