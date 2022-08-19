# DAYTONA_Assignment

As per the guidelines
1.Code is structured in two separate packages . Used Page Object Model , created a class "SearchCityPage.java" to create an object repository for storing all web elements. (Path - DAYTONA_Assignment/DaytonaSystems/src/main/java/pages/SearchCityPage.java /) and created a class for Test "WeatherInIndianCity (Path - DAYTONA_Assignment/DaytonaSystems/src/main/java/selenium/WeatherInIndianCity.java /) and refered objects from page class .

2. Code repeatition is not done . The variable names and code is descriptive and meaningful phrases are used.

3. Tests donot have any hard coded values . City name also made as user input using Scanner class inorder to avoid hard coding .User can search for any city .If the city name is not found ,message has been displayed stating City name not found (Covered all negative testcase as well) and will skip the temperature reading since it doesnot exists . If user enters city name in uppercase or in lowercase ,code will convert it into camel case and run inorder to not to be case sensitive .

4. Code is object oriented and strictly adheres to the language conventions .

5. Used Java coding language to build test and TestNG framework is used .

6. Used Maven as build tool

7. City is searched and pinned . Will fetch temperature information in Celsius and Fahrenheit and float/ decimal value is fetched.

8. Screenshot of result in Eclipse console is uploaded as ConsoleOutput file .

9. TestNG reports are uploaded in Git - DAYTONA_Assignment/DaytonaSystems/test-output/testng-results.xml (Reports is HTML , XML and other formats are also there ) . 


Deployment instructions for local execution


1.Import the Project in DaytonaSystems folder into eclipse.

2.To run the program , need to run the testng.xml file .Right click -> Run As -> TestNG Suite .

3.In console , will find the output with city and Temperature readings .

4.In Results of running suite we will find TestNG results .Number of tests run , failed and skipped .
Path - DaytonaSystems/testng.xml


