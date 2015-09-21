# log4j
log4j appender 

날짜별 Rolling 폴더 파일을 동시에 Rolling 가능

	<appender name="TEST" class="kr.co.killers.log4j.appender.DailyRollingFolderAndFileAppender">
		<param name="file" value="test.log" />
		<param name="DatePattern" value="'.'yyyy-MM-dd-HH-mm" />
		<param name="folderDatePattern" value="yyyyMMdd" />
		<param name="filePath" value="/Users/sanaes/logs" />
		<param name="Append" value="true" />
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="%d %-5p %c{1} - %m%n" />
		</layout>
	</appender>
	
기존 DailyRollingFileAppender를 수정 하여 만듬 

1.2 버전을 위한 Appender 

logback은 위처럼 롤링 하는 것이 있음 아래 설정


	<appender name="TEST" class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>/logs/test.out</file>
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<fileNamePattern>/logs/%d{yyyyMMdd, aux}/redis.%d{yyyy-MM-dd_HH}.out</fileNamePattern>
		</rollingPolicy>
		<encoder>
			<charset>UTF-8</charset>
			<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %msg%n</pattern>
		</encoder>
	</appender>
	
	
	
