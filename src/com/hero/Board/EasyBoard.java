package com.hero.Board;

import com.hero.Event.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EasyBoard implements Board {
  // private Box[] tab = new Box[64];
  private List<Box> tab = new ArrayList<>();

  public EasyBoard() {
    Box content;
    while (tab.size() < 64) {
      double rand = Math.random();

      if (rand < 0.2) {
        content = new Box(new EnemyEvent());
      } else if (rand < 0.6) {
        content = new Box(new LifeEvent());
      } else if (rand < 0.9) {
        content = new Box(new StuffEvent());
      } else {
        content = new Box(new EmptyEvent());
      }
      tab.add(content);
    }

    Collections.shuffle(tab);
    tab.set(63, new Box(new EnemyEvent(1)));
    for (int i = 1; i <= 3; i++) {
      tab.set(i, new Box(new LifeEvent()));
    }
    for (int i = 3; i <= 6; i++) {
      tab.set(i, new Box(new StuffEvent()));
    }
  }

  @Override
  public Box getBox(int index) {
    if (index >= tab.size()) {
      index = tab.size() - 1;
    }
    return tab.get(index);

  }

  /**
   * affiche la taille du plateau
   *
   * @return tab.length
   */
  public int size() {
    return tab.size();
  }
}
