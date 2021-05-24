class Solution {
  /*
  有限状态机
   */
  static class State {
    private int state = 0;

    public boolean nextState(char input) {
      if (state == 0) {
        if (input == '+' || input == '-') state = 1;
        else if (input == '.') state = 2;
        else if (input >= '0' && input <= '9') state = 3;
        else return false;
      } else if (state == 1) {
        if (input == '.') state = 2;
        else if (input >= '0' && input <= '9') state = 3;
        else return false;
      } else if (state == 2) {
        if (input >= '0' && input <= '9') state = 5;
        else return false;
      } else if (state == 3) {
        if (input >= '0' && input <= '9') state = 3;
        else if (input == 'e' || input == 'E') state = 6;
        else if (input == '.') state = 4;
        else return false;
      } else if (state == 4) {
        if (input >= '0' && input <= '9') state = 5;
        else if (input == 'e' || input == 'E') state = 6;
        else return false;
      } else if (state == 5) {
        if (input >= '0' && input <= '9') state = 5;
        else if (input == 'e' || input == 'E') state = 6;
        else return false;
      } else if (state == 6) {
        if (input == '+' || input == '-') state = 7;
        else if (input >= '0' && input <= '9') state = 8;
        else return false;
      } else if (state == 7) {
        if (input >= '0' && input <= '9') state = 8;
        else return false;
      } else if (state == 8) {
        if (input >= '0' && input <= '9') state = 8;
        else return false;
      }
      return true;
    }

    public boolean isInvalid() {
      return state == 3 || state == 4 || state == 5 || state == 8;
    }
  }

  public boolean isNumber(String s) {
    if (s == null) return false;
    State state = new State();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (!state.nextState(s.charAt(i))) return false;
    }
    return state.isInvalid();
  }
}
