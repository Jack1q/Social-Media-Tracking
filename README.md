# Social-Media-Tracking
This app fetches my Youtube, Twitter, & Instagram follower counts using
simple webscraping and stores them in a csv file. 
# How I Use It
I turned the Java project into a runnable jar, and then used Windows Task Scheduling to automate the data collection. Make sure you place your twitter API keys in twitter4j.properties and your usernames in usernames.properties.
The data will be output to 'output.csv'

# How I automated the data collection
***I have only done this in Windows*** </br>
1) Hit Windows Key + R - then type taskschd.msc and hit enter.

2) Select "Create Task..."

3) Give it a name and a description. It can be whatever you want. Most of the settings here are all up to you.

4) Under Configure for, select your version.
![General](https://i.imgur.com/IWp0pgB.png)

5) Select Triggers, then New.

6) Configure it however you like (Daily vs. Weekly, what time of day, etc.) and hit OK.
![Triggers](https://i.imgur.com/aU5ZPao.png)

7) Select Actions, then New. In the new window, set the action as Start a program. Browse for your .bat file and select it. Then, make sure to set "Start in" to the path where your .bat and .jar are located.

8) You're pretty much done, but if you want, you can go into Conditions or Settings and play around with some things. One thing I changed was to check the box next to "Start only if the network connection is available."


