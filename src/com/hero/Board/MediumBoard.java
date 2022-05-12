package com.hero.Board;

import com.hero.Event.EmptyEvent;
import com.hero.Event.EnemyEvent;
import com.hero.Event.LifeEvent;
import com.hero.Event.StuffEvent;
import com.hero.Exception.PersonnageHorsPlateauException;

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
  }

  @Override
  public Box getBox(int index)  throws PersonnageHorsPlateauException {
    if (index < tab.size()) {
      return tab.get(index);
    }
    else {
      throw new PersonnageHorsPlateauException();
    }
  }

  /**
   * affiche la taille du plateau
   * @return tab.length
   */
  public int size(){
    return tab.size() ;
  }
}
