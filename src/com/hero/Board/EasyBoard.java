package com.hero.Board;

import com.hero.Event.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EasyBoard implements Board {

  // private Box[] tab = new Box[64];
  private List<Box> easyTab = new ArrayList<>();
  public EasyBoard() {
    Box content;
    while (easyTab.size() < 64) {
      double rand = Math.random();

      if (rand < 0.2) {
        content = new Box(new EnemyEvent(1));
      } else if (rand < 0.6) {
        content = new Box(new LifeEvent());
      } else if (rand < 0.9) {
        content = new Box(new StuffEvent());
      } else {
        content = new Box(new EmptyEvent());
      }
      easyTab.add(content);
    }
    Collections.shuffle(easyTab);
    easyTab.set(63, new Box(new EnemyEvent("easy")));
    for (int i = 1; i <= 3; i++) {
      easyTab.set(i, new Box(new LifeEvent()));
    }
    for (int i = 3; i <= 6; i++) {
      easyTab.set(i, new Box(new StuffEvent()));
    }
  }
  public List<Box> getEasyTab() {
    return easyTab;
  }


  @Override
  public Box getBox(int index) {
    if (index >= easyTab.size()) {
      index = easyTab.size() - 1;
    }
    return easyTab.get(index);

  }

  /**
   * affiche la taille du plateau
   *
   * @return tab.length
   */
  public int size() {
    return easyTab.size();
  }
}
