package completed;

import java.util.*;
public class Problem1166 {

  static class FileSystemNode {
    Map<String, FileSystemNode> subNodes = new HashMap<>();
    Integer value;
    FileSystemNode() {
    }
    FileSystemNode(int val) {
      value = val;
    }

    boolean create(String path, int value) {
      if(path.contains("/")) {
        String firstPathString = path.split("/")[1];
        if(firstPathString.length()>0) {
          for(Character c: firstPathString.toCharArray()) {
            if(c>'z'|| c<'a') {
              return false; // invalid name;
            }
          }
          if(path.length() == 1+ firstPathString.length()) {
            if(subNodes.containsKey(firstPathString)) {
              return false;
            } else {
              subNodes.put(firstPathString, new FileSystemNode(value));
              return true;
            }
          } else {
            if(!subNodes.containsKey(firstPathString)) {
              return false;
            } else {
              String remaining = path.substring(1+firstPathString.length());
              return subNodes.get(firstPathString).create(remaining, value);
            }
          }
        }
      }
      return false;
    }

    int get(String path) {
      if(path.contains("/")) {
        String firstPathString = path.split("/")[1];
        if(firstPathString.length()>0) {
          if(!subNodes.containsKey(firstPathString)) {
            return -1;
          }
          if(path.length() == 1+ firstPathString.length()) {
            return subNodes.get(firstPathString).value;
          }
          String remaining = path.substring(1+firstPathString.length());
          return subNodes.get(firstPathString).get(remaining);
        }
      }
      return -1;
    }

  }
  static class FileSystem {

    FileSystemNode root = new FileSystemNode();
    public FileSystem() {

    }

    public boolean createPath(String path, int value) {
      return root.create(path, value);
    }

    public int get(String path) {
      return root.get(path);
    }
  }

  public static void main(String[] args) {
    FileSystem instance = new FileSystem();
    System.out.println(instance.createPath("/leet", 1));
    System.out.println(instance.createPath("/leet/code", 2));
    System.out.println(instance.get("/leet"));
    System.out.println(instance.get("/leet/code"));
    System.out.println(instance.createPath("/c/d", 1));
    System.out.println(instance.get("/c"));

//    instance.createPath("/a", 1);
//    System.out.println(instance.get("/a"));
  }
}
