package kr.co.killers.log4j.appender;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.core.annotation.Order;

import junit.framework.Test;
import junit.framework.TestCase;

public class DailyRollingFolderAndFileAppenderTEST extends TestCase {
	
	String filePath = "logs";
	String file = "temp.log";
	String datePattern = "'.'yyyy-MM-dd-HH-mm";
	String folderDatePattern = "yyyyMMddHH";

	Logger logger = Logger.getLogger(Test.class);
	
	@Order(value=1)
	public void testAppender1() {
		DailyRollingFolderAndFileAppender wa = new DailyRollingFolderAndFileAppender();
		wa.setName("test");
		wa.setFile(file);
		wa.setFilePath(filePath);
		wa.setLayout(new PatternLayout("%d %-5p %c{1} - %m%n"));
		wa.setAppend(true);
		wa.setDatePattern(datePattern);
		//FolderDatePattern을 넣지 않으면 기본적으로 일자로 생김
		wa.setFolderDatePattern(folderDatePattern);
		wa.activateOptions();
		logger.addAppender(wa);
	}

	@Order(value=2)
	public void testAppender2() {

		for (int i = 0; i < 100; i++) {
			logger.info("test-log");
		}


		try {
			//폴더 롤링을 확인하기 위해서 60초 동안 대기
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 100; i++) {
			logger.info("test-log");
		}

	}

}
