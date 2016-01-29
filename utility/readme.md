# Testing Utility
Avoid including this project in production code.

## NOTES:
- Avoid using easytesting & easetech for FEST assertions. It has conflict with Web Driver.

These two libraries are giving problems to selenium webdrivers:

		<dependency>
			<groupId>org.easytesting</groupId>
			<artifactId>fest-assert</artifactId>
			<version>1.4</version>
		</dependency>
		<dependency>
			<groupId>org.easetech</groupId>
			<artifactId>easytest</artifactId>
			<version>0.6.3</version>
		</dependency>
		
- Stay with the same driver

		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>2.50.0</version>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-firefox-driver</artifactId>
			<version>2.50.0</version>
		</dependency>