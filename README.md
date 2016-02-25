# address-book
## Running the app
The app can be launched by **mvn spring-boot:run**.
Code analysis can be done by **mvn sonar:sonar** assuming you have a local sonar instance on *localhost:9000*
(http://www.sonarqube.org/).

## Architectural & Design decissions
I decided to use Spring Boot for convenience or running and pre-bundled dependencies.
I tried to make code robust, tested and easy to mantain although sometimes it's not the simplest and direct solution.

## Date parsing
In the implementation provided any assumption was made about the years belonging to XX or XXI centuries so the following default behaviour applies:

From: *https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html*

```
For parsing with the abbreviated year pattern ("y" or "yy"), SimpleDateFormat must interpret the abbreviated year relative to some century.
It does this by adjusting dates to be within 80 years before and 20 years after the time the SimpleDateFormat instance is created.
```
