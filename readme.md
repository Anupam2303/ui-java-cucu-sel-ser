# BDD SERENITY 

BDD SERENITY its a cucumber, java BBD framework using SpringBoot framework.

## Driver Settings in system

Configure driver for Environment any OS (Mac/Windows/Linux)
eg follow link for setUp (ChromeDriver / Geckodriver etc) : 
1. [Windows OS](http://www.automationtestinghub.com/selenium-chromedriver/)
2. [MAC OS](https://www.kenst.com/2015/03/including-the-chromedriver-location-in-macos-system-path)

## Driver Settings in properties while running test
It supports multiple Browsers update values in serenity properties file as:
```webdriver.driver=FIREFOX```

## Running TestCases

Its maven project so use mvn lifecycle

```mvn clean verify```

## Reports
Reports will get generate at ```/target/site/serenity/index.html``` after running above maven command.

## Author
[Anupam Rai](https://www.linkedin.com/in/anupam-rai-42874438/)