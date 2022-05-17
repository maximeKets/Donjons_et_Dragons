package com.hero.Board;

import com.hero.Event.EmptyEvent;
import com.hero.Event.EnemyEvent;
import com.hero.Event.LifeEvent;
import com.hero.Event.StuffEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MediumBoard implements Board {
  private List<Box> mediumTab ;

  public MediumBoard() {
    mediumTab = new ArrayList<>();
    EasyBoard easyTab = new EasyBoard();
    Box content;
    while (mediumTab.size() <32){
      double rand = Math.random();

      if (rand < 0.4){
        content = new Box(new EnemyEvent(2));
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
      mediumTab.add(content);
    }
    Collections.shuffle(mediumTab);
    mediumTab.addAll(0, easyTab.getEasyTab());
    mediumTab.set(95, new Box(new EnemyEvent("medium")));
  }

  @Override
  public Box getBox(int index)   {
    if (index >= mediumTab.size()) {
      index = mediumTab.size() - 1;
    }
      return mediumTab.get(index);
  }
  public List<Box> getMediumTab() {
    return mediumTab;
  }


  /**
   * affiche la taille du plateau
   * @return tab.length
   */
  public int size(){
    return mediumTab.size() ;
  }
}
