package com.hero.Board;

import com.hero.Event.EnemyEvent;
import com.hero.Event.Event;
import com.hero.Event.LifeEvent;
import com.hero.Event.StuffEvent;
import com.hero.Hero.Hero;


public class Box implements Board {
  Event content;


  Box() {
  }
  Box (Event content){
    this.content = content;
  }

  public void interagir(Hero player) {
    content.interagir(player);
  }


  @Override
  public String toString() {
    return "" + content.getClass().getSimpleName();
  }

  @Override
  public Box getBox(int index) {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }
}
