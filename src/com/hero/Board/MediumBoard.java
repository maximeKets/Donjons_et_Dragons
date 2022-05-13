package com.hero.Board;

import com.hero.Event.EmptyEvent;
import com.hero.Event.EnemyEvent;
import com.hero.Event.LifeEvent;
import com.hero.Event.StuffEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediumBoard implements Board {
  private List<Box> tab = new ArrayList<>();

  public MediumBoard() {
    Box content;
    while (tab.size() < 96){
      double rand = Math.random();

      if (rand < 0.4){
        content = new Box(new EnemyEvent());
      }
      else if (rand < 0.6 ){
        content =new Box(new LifeEvent());
      }
      else if (rand < 0.8){
        content = new Box(new StuffEvent());
      }
      else {
        content = new Box(new EmptyEvent());
      }
      tab.add(content);
    }

    Collections.shuffle(tab);
    tab.set(96, new Box(new EnemyEvent(2)));
  }

  @Override
  public Box getBox(int index)   {
      return tab.get(index);
  }

  /**
   * affiche la taille du plateau
   * @return tab.length
   */
  public int size(){
    return tab.size() ;
  }
}
