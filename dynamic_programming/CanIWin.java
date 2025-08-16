package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {

  private Map<Boolean, Map<Integer, Boolean>> DP;

  public static void main(String[] args) throws Exception {
    System.out.println(new CanIWin().canIWin(5, 15));
  }

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    int sum = 0;
    for (int i = 1; i <= maxChoosableInteger; i++) sum += i;
    if (desiredTotal == 0) return true;
    else if (desiredTotal > sum)
      return false; // if the desiredTotal exceeds the max possible sum return false;
    DP = new HashMap<>();
    DP.put(true, new HashMap<>());
    DP.put(false, new HashMap<>());
    return dp(0, maxChoosableInteger, desiredTotal, true, 0);
  }

  private boolean dp(int state, int M, int D, boolean P, int sum) {
    if (sum >= D) return false;
    Map<Integer, Boolean> map = DP.get(P);
    if (map.containsKey(state)) return map.get(state);
    else {
      map.put(state, false);
      for (int i = 0; i < M; i++) {
        if ((state & (1 << i)) == 0) {
          if (!dp(state | (1 << i), M, D, !P, sum + i + 1)) {
            map.put(state, true);
            break;
          }
        }
      }
    }
    return map.get(state);
  }
}