package com.hero.Board;

public class Board {
  private Box[] tab = new Box[64];

  public Board() {
    for (int i = 0 ; i<tab.length ; i++) {
      tab[i] = new Box();
      int random = (int) ((Math.random() * 3) + 1);
      switch (random) {
        case 1:
          tab[i].setContent("gobelin"); break;
        case 2:
          tab[i].setContent("treasure"); break;
        case 3:
          tab[i].setContent("empty"); break;
        default:
          // never
      }
    }
  }

  public Box getBox(int index) {
    return tab[index];
  }
}
