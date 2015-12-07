package inkscape.clock;

import java.util.Calendar;

public class TimeRenderer {
	private static final int FIRST_FIELD_ROW_LENGTH = 4;
	private static final int SECOND_FIELD_ROW_LENGTH = 4;
	private static final int THIRD_FIELD_ROW_LENGTH = 11;
	private static final int FOURTH_FIELD_ROW_LENGTH = 4;
	private final String redSymbol = "R";
	private final String yellowSymbol = "Y";
	private final String unlitSymbol = ".";

	private Calendar datetime;

	public TimeRenderer(Calendar datetime) {
		this.datetime = datetime;
	}

	
}
