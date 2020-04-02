package mediabot;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile
{
  private String path;
  private boolean append_to_file;

  public WriteFile(String path)
  {
    this.path = path;
    append_to_file = false;
  }

  public WriteFile(String path, boolean append)
  {
    this.path = path;
    append_to_file = append;
  }

  /**
   * Takes String parameter of textLine, which will be the scraped data, and
   * writes it into the file output.csv
   * 
   * @param textLine
   */
  public void writeToFile(String textLine) throws IOException
  {
    FileWriter write = new FileWriter(path, append_to_file);
    PrintWriter print_line = new PrintWriter(write);
    print_line.printf("%s" + "%n", textLine);
    print_line.close();

  }

}
