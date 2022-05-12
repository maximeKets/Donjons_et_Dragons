package com.hero.Board;

import com.hero.Exception.PersonnageHorsPlateauException;

import java.util.ArrayList;
import java.util.Collections;

public class EasyBoard implements Board {
  private Box[] tab = new Box[64];
  // private List<Box> tab = new ArrayList<>()

  public EasyBoard() {
    for (int i = 0 ; i<tab.length ; i++) {
      tab[i] = new Box();
    }
    // Collections.shuffle(tab);
  }

  @Override
  public Box getBox(int index)  throws PersonnageHorsPlateauException {
    if (index < tab.length) {
      return tab[index];
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
    return tab.length ;
  }
}
