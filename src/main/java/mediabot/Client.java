package mediabot;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

  public Client()
  {
  }

  public Client(String youtubeURL, String twitterHandle, String instagramHandle,
    String instagramPassword)
  {
    this.youtubeURL = youtubeURL;
    this.twitterHandle = twitterHandle;
    this.instagramHandle = instagramHandle;
    this.instagramPassword = instagramPassword;
  }

  public String getYTSubscribers()
  {
    String subCount = "";
    try
    {
      Document channel = Jsoup.connect(getYoutubeURL()).get();
      subCount = channel.select("div[id=content]").text();
      subCount =
        subCount.substring(subCount.indexOf("Unsubscribe") + 11,
          subCount.indexOf("Loading"));
    }
    catch (Exception e)
    {
      System.out.println("Error");
      System.out.print(e);
    }
    return subCount;
  }

  public int getTwitterFollowers() throws Exception
  {
    Twitter twitter = TwitterFactory.getSingleton();
    User user = twitter.showUser(getTwitterHandle());
    return user.getFollowersCount();
  }

  public int getInstaFollowers() throws ClientProtocolException, IOException
  {
    Instagram4j instagram =
      Instagram4j.builder().username(getInstagramHandle())
        .password(getInstagramPassword()).build();
    instagram.setup();
    instagram.login();
    InstagramSearchUsernameResult userResult =
      instagram
        .sendRequest(new InstagramSearchUsernameRequest(getInstagramHandle()));
    return userResult.getUser().follower_count;
  }

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

  public void setYoutubeURL(String url)
  {
    youtubeURL = url;
  }

  public String getTwitterHandle()
  {
    return twitterHandle;
  }

  public void setTwitterHandle(String handle)
  {
    twitterHandle = handle;
  }

  public String getInstagramHandle()
  {
    return instagramHandle;
  }

  public void setInstagramHandle(String handle)
  {
    instagramHandle = handle;
  }

  public String getInstagramPassword()
  {
    return instagramPassword;
  }

  public void setInstagramPassword(String password)
  {
    instagramPassword = password;
  }
}
