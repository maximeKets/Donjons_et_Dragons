package com.hero.Board;

import com.hero.Exception.PersonnageHorsPlateauException;

public interface Board {
  public Box getBox(int index) throws PersonnageHorsPlateauException;

  int size();
}
