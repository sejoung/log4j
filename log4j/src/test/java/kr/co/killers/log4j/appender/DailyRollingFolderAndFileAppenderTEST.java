package kr.co.killers.log4j.appender;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import junit.framework.Test;
import junit.framework.TestCase;

public class DailyRollingFolderAndFileAppenderTEST extends TestCase {

	public void testAppender1() {
		String filePath = "logs";
		String file = "temp.log";
		String datePattern = "'.'yyyy-MM-dd-HH-mm";
		String folderDatePattern = "yyyyMMdd";
		Date now = new Date();
		now.setTime(System.currentTimeMillis());

		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		SimpleDateFormat fsdf = new SimpleDateFormat(folderDatePattern);

		String scheduledFoldername = fsdf.format(new Date(now.getTime()));
		String scheduledFolderPath = filePath + File.separatorChar + scheduledFoldername;

		String scheduledFilename = scheduledFolderPath + File.separatorChar + file + sdf.format(new Date(now.getTime()));

		File Folder = new File(scheduledFolderPath);

		if (Folder.exists()) {
			System.out.println(Folder.list().length);
		}

		DailyRollingFolderAndFileAppender wa = new DailyRollingFolderAndFileAppender();
		wa.setFile(file);
		wa.setFilePath(filePath);
		wa.setLayout(new PatternLayout("%d %-5p %c{1} - %m%n"));
		wa.setAppend(true);
		wa.setDatePattern(datePattern);
		wa.setFolderDatePattern(folderDatePattern);
		wa.activateOptions();

		Logger logger = Logger.getLogger(Test.class);
		logger.addAppender(wa);

		for (int i = 0; i < 100; i++) {
			logger.info("test-log");
		}

		System.out.println(scheduledFilename);

		File lastFolder = new File(scheduledFolderPath);
		if (lastFolder.exists()) {
			System.out.println(lastFolder.list().length);
		}

		assertTrue(new File(scheduledFilename).exists());

	}

}
