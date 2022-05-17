package com.hero.Board;

import com.hero.Event.EmptyEvent;
import com.hero.Event.EnemyEvent;
import com.hero.Event.LifeEvent;
import com.hero.Event.StuffEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HardBoard implements Board {
  private List<Box> hardTab;

  public HardBoard() {
    hardTab = new ArrayList<>();
    MediumBoard mediumTab = new MediumBoard();
    Box content;
    while (hardTab.size() < 32){
      double rand = Math.random();

      if (rand < 0.45){
        content = new Box(new EnemyEvent(3));
      }
      else if (rand < 0.675 ){
        content =new Box(new LifeEvent());
      }
      else if (rand < 0.9){
        content = new Box(new StuffEvent());
      }
      else {
        content = new Box(new EmptyEvent());
      }
      hardTab.add(content);
    }


    Collections.shuffle(hardTab);
    hardTab.addAll(96, mediumTab.getMediumTab());
    hardTab.set(127, new Box(new EnemyEvent("hard")));
  }

  @Override
  public Box getBox(int index)   {
    if (index >= hardTab.size()) {
      index = hardTab.size() - 1;
    }
    return hardTab.get(index);
  }

  /**
   * affiche la taille du plateau
   * @return tab.length
   */
  public int size(){
    return hardTab.size() ;
  }
}
