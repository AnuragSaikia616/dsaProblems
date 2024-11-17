import java.util.HashMap;

/**
 * test
 */
public class test {

  public static void main(String[] args) {
    HashMap<String, Integer> hm = new HashMap<>();
    hm.put("anr", 10);
    hm.put("anr", hm.get("anr") + 1);
    System.out.println(hm);

  }
}
