package mediabot;

/**
 * This app fetches my Youtube, Twitter, & Instagram follower counts using
 * simple webscraping and stores them in a csv file.
 * 
 * @author Jack Donofrio
 * @version 1.2
 */

public class Main
{
  public static void main(String[] args) throws Exception
  {
    Client client = new Client();
    String results =
      client.getDate() + "," + client.getYTSubscribers() + ","
        + client.getTwitterFollowers() + "," + client.getInstaFollowers();
    WriteFile entry = new WriteFile("output.csv", true);
    entry.writeToFile(results);
  }
}
