package com.hero.Board;

import com.hero.Event.EnemyEvent;
import com.hero.Event.Event;
import com.hero.Event.LifeEvent;
import com.hero.Event.StuffEvent;
import com.hero.Hero.Hero;


public class Box {
  Event content;
  int random = (int) (Math.random() * 3) + 1;

  Box() {
    switch (random) {
      case 1:
        content = new StuffEvent();
        break;
      case 2:
        content = new LifeEvent();
        break;
      case 3:
        content = new EnemyEvent();
        break;
      default:
    }
  }

  public void interagir(Hero player) {
    content.interagir(player);
  }


  @Override
  public String toString() {
    return "" + content.getClass().getSimpleName();
  }
}
