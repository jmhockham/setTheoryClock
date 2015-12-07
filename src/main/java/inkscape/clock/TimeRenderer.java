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
		return createRow(Calendar.MINUTE, false, yellowSymbol, THIRD_FIELD_ROW_LENGTH, redSymbol, 3);
	}

	public String getFourthRowDisplay() {
		return createRow(Calendar.MINUTE, true, yellowSymbol, FOURTH_FIELD_ROW_LENGTH);
	}

	private String createRow(int calendarField, boolean usingModulo, String rowSymbol, int fieldLength){
		return createRow(calendarField, usingModulo, rowSymbol, fieldLength, null, -1);
	}

	private String createRow(int calendarField, boolean usingModulo, String rowSymbol, int fieldLength,
			String alternateSymbol, int alternateThreshold) {
		String row = "";
		int unitOfTime = datetime.get(calendarField);
		unitOfTime = usingModulo ? unitOfTime % 5 : unitOfTime / 5;
		if (alternateSymbol == null || alternateThreshold <= 0) {
			for (int i = 0; i < unitOfTime; i++) {
				row += rowSymbol;
			}
		} else {
			int thresholdCounter = 0;
			for (int i = 0; i < unitOfTime; i++) {
				thresholdCounter++;
				if (thresholdCounter >= alternateThreshold) {
					row += alternateSymbol;
					thresholdCounter = 0;
				} else {
					row += rowSymbol;
				}

			}
		}
		for (int i = row.length(); i < fieldLength; i++) {
			row += unlitSymbol;
		}
		return row;
	}

}
