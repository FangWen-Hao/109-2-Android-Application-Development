Android fundamentals 04.2: Input controls
=======

Answer these questions
-----------

1. Question 1: What is the name of the file in which you create options menu items? Choose one:

* menu.java
* menu_main.xml
* activity_main.xml
* content_main.xml

**Answer:**
* menu_main.xml


2. Question 2: Which method is called when an options menu item is clicked? Choose one:

* `onOptionsItemSelected(MenuItem item)`
* `onClick(View view)`
* `onContextItemSelected()`
* `onClickShowAlert()`

**Answer:**
* `onOptionsItemSelected(MenuItem item)`


3. Question 3: Which of the following statements sets the title for an alert dialog? Choose one:

* `myAlertBuilder.setMessage("Alert");`
* `myAlertBuilder.setPositiveButton("Alert");`
* `myAlertBuilder.setTitle("Alert");`
* `AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder("Alert");`

**Answer:**
* `myAlertBuilder.setTitle("Alert");`


4. Question 4: Where do you create a `DialogFragment` for a date picker? Choose one:

* In the `onCreate()` method in the hosting `Activity`.
* In the `onCreateContextMenu()` method in `Fragment`.
* In the `onCreateView()` method in the extension of `DialogFragment`.
* In the `onCreateDialog()` method in the extension of `DialogFragment`.

**Answer:**
* In the `onCreateDialog()` method in the extension of `DialogFragment`.
