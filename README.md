# Social-Media-Tracking
This app fetches my Youtube, Twitter, & Instagram follower counts using
simple webscraping and stores them in a csv file. Instagram functionality is
still being tweaked
# How I got it to work
1) Create a Java project with the Main.java, Main.class and WriteFile.java, WriteFile.class files. You're gonna wanna edit the Main.java file to include your own social media links and to change the entry path from my default one to wherever you want to send this data.

2) Add the [jsoup](https://jsoup.org/download) and [twitter4j](http://twitter4j.org/en/) external jars to the project build path.
The project should look something like this: 
![Project Files](https://i.imgur.com/yrviaJs.png?1)

3) Get a Twitter API Key ([Tutorial](https://themepacific.com/how-to-generate-api-key-consumer-token-access-key-for-twitter-oauth/994/)). It may take some time for Twitter to accept your API application.

5) It's time to export the project. Right click the project in Eclipse, hit Export, and select Runnable Jar. Under Launch configuration, choose the Main.java file. Set the destination to somewhere you can easily access. Under Library handling, choose "Extract required libraries into generated JAR."

6) Locate the .jar file you just created, and open it up with WinRar (or whatever you prefer to use). Inside, place the twitter4j.properties text file I have here. Remember those API keys I had you get? Enter each one into your twitter4j.properties file and save it. 

Your jar file should now look like:
![.jar File](https://i.imgur.com/iPsSrXn.png)

7) Now we're gonna test if it worked. Open up a command prompt and locate the directory your .jar file is stored in. Enter java -jar jarfilename.jar. (Alternatively, you can just double click the jar file, but that tends to not work the first time for me for whatever reason.) Check the file you set as the path in Main.java and it should be updated with your Youtube subs and Twitter follower counts.

8) Make a text file named run.bat in the same folder as your jar file. Inside, type java -jar jarfilename.jar 

# How I automated the data collection
***I have only done this in Windows*** </br>
1) Hit Windows Key + R - then type taskschd.msc and hit enter.

2) Select "Create Task..."

3) Give it a name and a description. It can be whatever you want. Most of the settings here are all up to you.

4) Under Configure for, select your OS.
![General](https://i.imgur.com/IWp0pgB.png)

5) Select Triggers, then New.

6) Configure it however you like (Daily vs. Weekly, what time of day, etc.) and hit OK.
![Triggers](https://i.imgur.com/aU5ZPao.png)

7) Select Actions, then New. In the new window, set the action as Start a program. Browse for your .bat file and select it. Then, make sure to set "Start in" to the path where your .bat and .jar are located.

8) You're pretty much done, but if you want, you can go into Conditions or Settings and play around with some things. One thing I changed was to check the box next to "Start only if the network connection is available."


