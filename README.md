# address-book

In the implementation provided any assumption was made about the years belonging to XX or XXI centuries so the following default behaviour applies:

From: *https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html*

```
For parsing with the abbreviated year pattern ("y" or "yy"), SimpleDateFormat must interpret the abbreviated year relative to some century.
It does this by adjusting dates to be within 80 years before and 20 years after the time the SimpleDateFormat instance is created.
```
