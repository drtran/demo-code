# Verifying the installation
This project contains code that verify the software installation for the 3-day AEP class.

Linksys: Linksys35327

## Verifying Tomcat 8 installation

### Verifying Jenkins-CI
### Verifying Jtrac application

## Verifying SonarQUBE installation

## Verifying HSQL database installation

## Verifying FitNesse Wiki install

## Verifying HSQL database install

## Network utility test:
Run network utility as a JUit test like this:
	
	mvn clean -Dtest=com.bemach.aep.verifier.util.NetworkInfoTest test

Run network utility as a Java app like this:

	java -cp ./verifier-0.1.jar com.bemach.aep.verifier.util.NetworkInfoTest

## Skipping all JUnit tests:
	mvn clean -DskipTests

## NOTES:
- Problem of using CDI-Unit along with using selenium webdriver.