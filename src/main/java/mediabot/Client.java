package mediabot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class Client
{
  private String youtubeURL;
  private String twitterHandle;
  private String instagramHandle;
  private String instagramPassword;

  public Client() throws IOException
  {
    loadUsernameData();
  }

  /**
   * This method loads the data in usernames.properties into each instance
   * variable so that they can be used in the methods of the Client class.
   */
  public void loadUsernameData() throws IOException
  {
    File usernamesFile = new File("usernames.properties");
    FileInputStream fileInput = new FileInputStream(usernamesFile);
    Properties userProperties = new Properties();
    userProperties.load(fileInput);
    fileInput.close();
    youtubeURL = userProperties.getProperty("youtube_link");
    twitterHandle = userProperties.getProperty("twitter_handle");
    instagramHandle = userProperties.getProperty("instagram_handle");
    instagramPassword = userProperties.getProperty("instagram_password");
  }

  /**
   * This method gets the number of subsribers for the given YouTube channel URL
   * using pretty cheeky webscraping.
   */

  public String getYTSubscribers()
  {
    String subCount = "";
    try
    {
      Document channel = Jsoup.connect(youtubeURL).get();
      subCount = channel.select("div[id=content]").text();
      subCount =
        subCount.substring(subCount.indexOf("Unsubscribe") + 11,
          subCount.indexOf(" Loading"));
    }
    catch (Exception e)
    {
      System.out.println("Error");
      System.out.print(e);
    }
    return subCount;
  }

  /**
   * This method gets the number of Twitter followers for the handle indicated
   * in usernames.properties using the twitter4j Java library.
   */
  public int getTwitterFollowers() throws Exception
  {
    Twitter twitter = TwitterFactory.getSingleton();
    User user = twitter.showUser(twitterHandle);
    return user.getFollowersCount();
  }

  /**
   * This method gets the number of Instagram followers for the handle/password
   * indicated in usernames.properties using the Instagram4j Java library.
   */
  public int getInstaFollowers() throws ClientProtocolException, IOException
  {
    Instagram4j instagram =
      Instagram4j.builder().username(instagramHandle)
        .password(instagramPassword).build();
    instagram.setup();
    instagram.login();
    InstagramSearchUsernameResult userResult =
      instagram
        .sendRequest(new InstagramSearchUsernameRequest(instagramHandle));
    return userResult.getUser().follower_count;
  }

  /**
   * Simply gets the date/time in MM/dd/yyyy HH:mm:ss format for bookkeeping
   * purposes when storing follower data
   */
  public String getDate()
  {
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date date = new Date();
    String dayRecorded = dateFormat.format(date);
    return dayRecorded;
  }

  public String getYoutubeURL()
  {
    return youtubeURL;
  }

  public String getTwitterHandle()
  {
    return twitterHandle;
  }

  public String getInstagramHandle()
  {
    return instagramHandle;
  }

  public String getInstagramPassword()
  {
    return instagramPassword;
  }

}
