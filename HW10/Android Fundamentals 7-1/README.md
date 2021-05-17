Android fundamentals 07.1: AsyncTask
=======

Answer these questions
-----------

1. Question 1: For a `ProgressBar`:
	1. How do you determine the range of values that a `ProgressBar` can show?
	2. How do you change how much of the progress bar is filled in?

**Answer:**
 1. The range of values that a `ProgressBar` can show can be determined and changed through the ProgressBar attribute `android:max` in the `layout.xml` file.
 2. The ammount the progress bar is filled in can be changed by either setting the value directly through `setProgress(int)` or by incrementing the progress through `incrementProgressBy(int).


2. Question 2: If an `AsyncTask` is defined as follows:
>> ` private class DownloadFilesTask extends AsyncTask<URL, Integer, Long>`
	1. What is the type of the value that is passed to `doInBackground()` in the AsyncTask?
	2. What is the type of the value that is passed to the callback that reports the progress of the task?
	3. What is the type of the value that is passed to the callback that is executed when the task completes?

**Answer:**
	1. The type of the value that is passed to `doInBackground()` will be an URL type of value.
	2. The type of the value that is passed to the callback that reports the progress of the task will be an Integer type of value.
	3. The type of the value that is passed to the callback that is executed when the task completes will be a Long integer type of value.


3. Question 3: To report progress of the work executed by an `AsyncTask`, what callback method do you implement, and what method do you *call* in your `AsyncTask` subclass?

* `Implement publishProgress(). Call publishProgress().`
* `Implement publishProgress(). Call onProgressUpdate().`
* `Implement onProgressUpdate(). Call publishProgress().`
* `Implement onProgressUpdate(). Call onProgressUpdate().`

**Answer:**
* `Implement publishProgress(). Call onProgressUpdate().`
