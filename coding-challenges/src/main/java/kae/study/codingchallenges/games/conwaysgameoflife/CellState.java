package kae.study.codingchallenges.games.conwaysgameoflife;

/**
 *
 */
public enum CellState {

  ALIVE() {
    @Override
    public String toString() {
      return "+";
    }
  },

  DEAD() {
    @Override
    public String toString() {
      return "-";
    }
  }

}
