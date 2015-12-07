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

	public String getRedSymbol() {
		return redSymbol;
	}

	public String getYellowSymbol() {
		return yellowSymbol;
	}

	public String getUnlitSymbol() {
		return unlitSymbol;
	}

	public String getSecondsDisplay() {
		int seconds = datetime.get(Calendar.SECOND);
		int remainder = seconds % 2;
		return remainder > 0 ? yellowSymbol : unlitSymbol;
	}

	public String getFirstRowDisplay() {
		// this is in 24hr format
		int hourOfDay = datetime.get(Calendar.HOUR_OF_DAY);
		int hourDividedByFive = hourOfDay / 5;
		String firstRowDisplay = "";
		for (int i = 0; i < hourDividedByFive; i++) {
			firstRowDisplay += redSymbol;
		}
		// now add unlit fields
		for (int i = firstRowDisplay.length(); i < FIRST_FIELD_ROW_LENGTH; i++) {
			firstRowDisplay += unlitSymbol;
		}
		return firstRowDisplay;
	}

	public String getSecondRowDisplay() {
		int hourOfDay = datetime.get(Calendar.HOUR_OF_DAY);
		int hourRemainder = hourOfDay % 5;
		String secondRowDisplay = "";
		for (int i = 0; i < hourRemainder; i++) {
			secondRowDisplay += redSymbol;
		}
		// now add unlit fields
		for (int i = secondRowDisplay.length(); i < SECOND_FIELD_ROW_LENGTH; i++) {
			secondRowDisplay += unlitSymbol;
		}
		return secondRowDisplay;
	}

	public String getThirdRowDisplay() {
		int minute = datetime.get(Calendar.MINUTE);
		int minutesDividedByFive = minute / 5;
		String thirdRowDisplay = "";
		int redLightCounter = 0;
		for (int i = 0; i < minutesDividedByFive; i++) {
			redLightCounter++;
			if (redLightCounter >= 3) {
				thirdRowDisplay += redSymbol;
				redLightCounter = 0;
			} else {
				thirdRowDisplay += yellowSymbol;
			}
		}
		// now add unlit fields
		for (int i = thirdRowDisplay.length(); i < THIRD_FIELD_ROW_LENGTH; i++) {
			thirdRowDisplay += unlitSymbol;
		}
		return thirdRowDisplay;
	}

	public String getFourthRowDisplay() {
		int minute = datetime.get(Calendar.MINUTE);
		int minutesRemainder = minute % 5;
		String fourthRowDisplay = "";
		for (int i = 0; i < minutesRemainder; i++) {
			fourthRowDisplay += yellowSymbol;
		}
		// now add unlit fields
		for (int i = fourthRowDisplay.length(); i < FOURTH_FIELD_ROW_LENGTH; i++) {
			fourthRowDisplay += unlitSymbol;
		}
		return fourthRowDisplay;
	}

}
