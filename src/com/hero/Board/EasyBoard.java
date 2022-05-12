package com.hero.Board;

import com.hero.Event.*;
import com.hero.Exception.PersonnageHorsPlateauException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EasyBoard implements Board {
  // private Box[] tab = new Box[64];
   private List<Box> tab = new ArrayList<>();

  public EasyBoard() {
    Box content;
    while (tab.size() < 64){
      double rand = Math.random();

      if (rand < 0.3){
        content = new Box(new EnemyEvent());
      }
      else if (rand < 0.6 ){
        content =new Box(new LifeEvent());
      }
      else if (rand < 0.9){
        content = new Box(new StuffEvent());
      }
      else {
        content = new Box(new EmptyEvent());
      }
      tab.add(content);
    }

     Collections.shuffle(tab);
    tab.set(64, new Box(new EnemyEvent()));
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
