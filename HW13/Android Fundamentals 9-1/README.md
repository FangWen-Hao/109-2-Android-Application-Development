Android fundamentals 09.1: Shared preferences
=======

Answer these questions
-----------

1. Question 1: In which lifecycle method do you save the app state to shared preferences?

**Answer:**
In the onPause() part of the lifecycle


2. Question 2: In which lifecycle method do you restore the app state?

**Answer:**
In the onCreate() part of the lifecycle.


3. Question 3: Can you think of a case where it makes sense to have both shared preferences and instance state?

**Answer:**
In a web browser application, one can use shared preferences to save the user pages when navigating normally while one uses instance states when the user is navigating in private tab: that way the web pages the user browses are stored when the user quits the app but the web pages browsed in private browsing are destroyed if the user quits the app.