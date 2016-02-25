# address-book
## Running the app
The app can be launched by **mvn spring-boot:run**.
Code analysis can be done by **mvn sonar:sonar** assuming you have a local sonar instance on *localhost:9000*
(http://www.sonarqube.org/).

## Architectural & Design decissions
-I decided to use Spring Boot for convenience on running and pre-bundled dependencies.

-I tried to make code readable, robust, tested and easy to mantain although sometimes was not the more direct solution.

-I decided to make two different searches in *DaysOlder.findContactByName()* because the code was more readable than using a single stream traverse despite of the performance impact.
```
contacts.stream().filter(c -> c.getName().startsWith(firstName) || c.getName().startsWith(secondName)).
                limit(2).
                collect(Collectors.groupingBy(Contact::getName));
```
-Streams are not reusable so in order to resolve the 3 scenarios of the problem I decided to read the file once, store in a memory collection (List<Contact>) and then stream that collection for each of the scenarios. A more efficient and convoluted solution was possible but I focused on simplicity over performance.


## Date parsing
In the implementation provided any assumption was made about the years belonging to XX or XXI centuries so the following default behaviour applies:

From: *https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html*

```
For parsing with the abbreviated year pattern ("y" or "yy"), SimpleDateFormat must interpret the abbreviated year relative to some century.
It does this by adjusting dates to be within 80 years before and 20 years after the time the SimpleDateFormat instance is created.
```
