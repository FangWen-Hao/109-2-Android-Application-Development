Android fundamentals 07.3: Broadcast receivers
=======

Answer these questions
-----------

1. Question 1: What is a system broadcast?
* A message that your app sends and receives when an event of interest occurs in the app.
* A message that is sent from an app to a different component of the same app.
* A message that the Android system sends when a system event occurs.
* A message that the Android system receives when an event of interest occurs in your app.


**Answer:**
* A message that the Android system sends when a system event occurs.


2. Question 2: Which pair of methods do you use to register and unregister your broadcast receiver dynamically?
* `registerBroadcast()` and `unRegisterBroadcast()`.
* `registerComponentCallbacks()` and `unRegisterComponentCallbacks()`.
* `registerBroadcastReceiver()` and `unRegisterBroadcastReceiver()`.
* `registerReceiver()` and `unRegisterReceiver()`.

**Answer:**
* `registerReceiver()` and `unRegisterReceiver()`.


3. Question 3: Which of the following are true?
* Broadcast receivers can't see or capture the intents used to start an activity.
* Using a broadcast intent, you can't find or start an activity.
* You can use a broadcast intent to start an activity.
* You can receive the intent used to start activity in your broadcast receiver.


**Answer:**
* Broadcast receivers can't see or capture the intents used to start an activity.
* Using a broadcast intent, you can't find or start an activity.


4. Question 4: Which class is used to mitigate the security risks of broadcast receivers when the broadcasts are not cross-application (that is, when broadcasts are sent and received by the same app)?
* SecureBroadcast
* LocalBroadcastManager
* OrderedBroadcast
* SecureBroadcastManager

**Answer:**
* LocalBroadcastManager