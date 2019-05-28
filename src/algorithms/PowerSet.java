package algorithms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PowerSet {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("(h\\w*a\\w*c\\w*k\\w*e\\w*r\\w*r\\w*a\\w*n\\w*k)");
    Matcher matcher = pattern.matcher("hhaacckkekraraannk");
    System.out.println(matcher.matches());
  }
}
