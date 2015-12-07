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
		return createRow(Calendar.HOUR_OF_DAY, false, redSymbol, FIRST_FIELD_ROW_LENGTH);
	}

	public String getSecondRowDisplay() {
		return createRow(Calendar.HOUR_OF_DAY, true, redSymbol, SECOND_FIELD_ROW_LENGTH);
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
		return createRow(Calendar.MINUTE, true, yellowSymbol, FOURTH_FIELD_ROW_LENGTH);
	}

	private String createRow(int calendarField, boolean usingModulo, String rowSymbol, int fieldLength) {
		String row = "";
		int unitOfTime = datetime.get(calendarField);
		if (usingModulo) {
			unitOfTime = unitOfTime % 5;
		} else {
			unitOfTime = unitOfTime / 5;
		}
		for (int i = 0; i < unitOfTime; i++) {
			row += rowSymbol;
		}
		for (int i = row.length(); i < fieldLength; i++) {
			row += unlitSymbol;
		}
		return row;
	}

}
