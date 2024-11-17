import java.util.Arrays;

public class assignCookies {
  public static int findContentChildren(int[] g, int[] s) {
    Arrays.sort(s);
    Arrays.sort(g);
    int ng = g.length;
    int ns = s.length;
    int sizeInd = 0;
    int greedInd = 0;

    int contentKids = 0;
    while (greedInd < ng) {
      if (greedInd == ng)
        return contentKids;
      if (sizeInd == ns)
        return contentKids;
      while (g[greedInd] > s[sizeInd]) {
        sizeInd++;
        if (sizeInd == ns)
          return contentKids;
      }
      contentKids++;
      greedInd++;
      sizeInd++;
    }

    return contentKids;
  }

  public static void main(String[] args) {
    int g[] = { 10, 9, 8, 7 };
    int s[] = { 5, 6, 7, 8 };

    int output = findContentChildren(g, s);
    System.out.println(output);

  }
}
