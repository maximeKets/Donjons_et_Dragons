package com.hero.Board;

public class Thimble {
  private int value;

  public Thimble() {
  }

  public void throwDice() {
    this.value = (int) (Math.random() * 6) + 1;
  }

  public int getValue(){
    return this.value;
  }



}
