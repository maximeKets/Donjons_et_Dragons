package com.hero.Board;

public class Dice {
  private int value;

  public Dice() {
  }

  /**
   * Lancer les dés
   */
  public void throwDice() {
    this.value = (int) (Math.random() * 6) + 1;
  }

  /**
   * recuperer la valeur du lancé de dés
   * @return value
   */
  public int getValue(){
    return this.value;
  }



}
