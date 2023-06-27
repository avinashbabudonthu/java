package com.java;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatFileAppender extends FileAppender {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//    private boolean separate = false;

    /**
     * The default constructor does nothing.
     */
    public DateFormatFileAppender() {
    }

    /**
     * Instantiate a <code>DailyRollingFileAppender</code> and open the
     * file designated by <code>filename</code>. The opened filename will
     * become the ouput destination for this appender.
     */
    public DateFormatFileAppender(Layout layout, String filename) throws IOException {
        super(layout, filename, true);
    }

//    public void setFile(String file) {
//        super.setFile(file);
//    }

    /**
     * If true each LoggingEvent causes that file to close and open.
     * This is useful when the file is a pattern that would often
     * produce a different filename.
     */
//    public void setSeparate(boolean separate) {
//        this.separate = separate;
//    }

//    protected void subAppend(LoggingEvent event) {
//        if (separate) {
//            try {//First reset the file so each new log gets a new file.
//                setFile(getFile(), getAppend(), getBufferedIO(), getBufferSize());
//            } catch (IOException e) {
//                LogLog.error("Unable to reset fileName.");
//            }
//        }
//        super.subAppend(event);
//    }



    // fileName = logs/app.log
    public synchronized void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize) throws IOException {
        String dateStr = sdf.format(new Date());
        String actualFileName = fileName.substring(0, fileName.indexOf(".")) + "-" + dateStr + fileName.substring(fileName.indexOf("."));
        // makeDirs(actualFileName);
        super.setFile(actualFileName, append, bufferedIO, bufferSize);
    }

    /**
     * Ensures that all of the directories for the given path exist.
     * Anything after the last / or \ is assumed to be a filename.
     */
//    private void makeDirs(String path) {
//        int indexSlash = path.lastIndexOf("/");
//        int indexBackSlash = path.lastIndexOf("\\");
//        int index = Math.max(indexSlash, indexBackSlash);
//        if (index > 0) {
//            String dirs = path.substring(0, index);
//            File dir = new File(dirs);
//            if (!dir.exists()) {
//                boolean success = dir.mkdirs();
//                if (!success) {
//                    LogLog.error("Unable to create directories for " + dirs);
//                }
//            }
//        }
//    }

}
