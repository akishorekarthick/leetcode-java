package binary_search;

public class KokoEatingBananas {
  public static void main(String[] args) {
    int[] A = {312884470};
    System.out.println(new KokoEatingBananas().minEatingSpeed(A, 968709470));
  }

  public int minEatingSpeed(int[] piles, int H) {
    int max = 0;
    for (int i = 0; i < piles.length; i++) {
      max = Math.max(max, piles[i]);
    }
    if (H == piles.length) return max;
    int h = max, l = 1;
    int answer = H;
    while (l <= h) {
      int m = l + (h - l) / 2;
      boolean status = check(piles, H, m);
      if (status) {
        answer = m;
        h = m - 1;
      } else {
        l = m + 1;
      }
    }
    return answer;
  }

  private boolean check(int[] piles, int H, int k) {
    for (int p : piles) {
      if (p <= k) {
        H--;
      } else {
        int q = p / k;
        if ((p % k) > 0) {
          q++;
        }
        H -= q;
      }
      if (H < 0) {
        return false;
      }
    }
    return true;
  }
}