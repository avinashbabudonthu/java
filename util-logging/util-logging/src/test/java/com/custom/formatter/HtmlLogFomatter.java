package com.custom.formatter;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class HtmlLogFomatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<tr>\n");

		// add color if error level >= WARNING
		//		if(record.getLevel())

		return null;
	}

}
