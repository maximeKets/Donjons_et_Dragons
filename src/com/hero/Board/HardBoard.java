package com.hero.Board;

import com.hero.Exception.PersonnageHorsPlateauException;

public class HardBoard implements Board {
  private Box[] tab = new Box[126];

  public HardBoard() {
    for (int i = 0 ; i<tab.length ; i++) {
      tab[i] = new Box();
    }
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



  public int size(){
    return tab.length ;
  }
}
