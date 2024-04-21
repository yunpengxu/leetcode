package completed;

import java.util.HashMap;
import java.util.Map;

public class Problem359 {

  static class Logger {

    private Map<String, Integer> timeMap = new HashMap<>();
    public Logger() {
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
      int nextTimestamp = timeMap.getOrDefault(message, 0);
      if (nextTimestamp<= timestamp) {
        timeMap.put(message, timestamp+ 10);
        return true;
      }
      return false;
    }
  }

  public static void main(String[]args) {
    Logger logger = new Logger();
    System.out.println(logger.shouldPrintMessage(1, "foo"));
    System.out.println(logger.shouldPrintMessage(2, "bar"));
    System.out.println(logger.shouldPrintMessage(3, "foo"));
    System.out.println(logger.shouldPrintMessage(8, "bar"));
    System.out.println(logger.shouldPrintMessage(10, "foo"));
    System.out.println(logger.shouldPrintMessage(11, "foo"));
  }
}
