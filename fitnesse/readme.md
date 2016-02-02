# Module 5 - Acceptance Tests with FitNesse
This is a demo project for FitNesse framework


```
@jtrac-login-scenario
Scenario: Logging into jtrac application
	Given I am at the website "http://pidev4:8080/jtrac/app/login"
	When I enter user id "admin" and password "admin"
	And I click on the Submit button
	Then I should see a main page display "DASHBOARD" as a part of the 
```

MS Windows:
To start a fitnesse wiki page: lanuch fitnesse.cmd from c:/csd-work/win/cmd folder.

Linux:
cd apps
java -jar fitnesse-standalone.jar -p 9090 

- Visit fitnesse wiki page: http://localhost:9090/
- Choose Add / Test Page
- Page Name: Jtrac_Login_Test
- Help text: jtrac login
- Tags: jtrac_login

The content of the table should be as follows:

## MS-Windows

!path c:/csd-work/shared/demo-code/fitnesse/target/fitnesse-1.0.0.jar
	
| com.bemach.aep.fitnesse.JtracLoginTest|
| websiteUrl                            | userName | password | dashboardName? |
| http://localhost:8080/jtrac/app/login | admin    | admin    | DASHBOARD      |


## Raspberry Pi:
If running on the raspberry pi, use this windows command to transfer file to the host:
Need to make sure there is a /home/pi/finesse folder on the Pi

pscp -l pi -pw raspberry source c:/csd-work/shared/demo-code/fitnesse/target/fitnesse-1.0.0.jar pi-ip:./fitnesse/.

!path /home/pi/fitnesse/fitnesse-1.0.0.jar
	
| com.bemach.aep.fitnesse.JtracLoginTest|
| websiteUrl                            | userName | password | dashboardName? |
| http://localhost:8080/jtrac/app/login | admin    | admin    | DASHBOARD      |
