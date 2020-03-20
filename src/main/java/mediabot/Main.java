package mediabot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;

/**
 * This app fetches my Youtube, Twitter, & Instagram follower counts using
 * simple webscraping and stores them in a csv file.
 * 
 * @author Jack Donofrio
 * @version 1.1
 */

public class Main
{
  public static void main(String[] args) throws Exception
  {
    String youtubeChannelLink =
      "";
    String twitterHandle = "";
    String instagramHandle = "";
    String instagramPassword = "";
    Client client =
      new Client(youtubeChannelLink, twitterHandle, instagramHandle,
        instagramPassword);

    String results =
      client.getDate() + "\n" + "Youtube Subscribers: "
        + client.getYTSubscribers() + "\n" + "Twitter Followers: "
        + client.getTwitterFollowers() + "\n" + "Instagram Followers: "
        + client.getInstaFollowers();
    WriteFile entry =
      new WriteFile(
        "C:\\Users\\jackd\\OneDrive\\Desktop\\textfiles\\scrape.csv", true);
    entry.writeToFile(results);
  }
}
