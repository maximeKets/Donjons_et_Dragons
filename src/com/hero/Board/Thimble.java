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

  public static void main(String[] args) {
    Thimble t = new Thimble();
    for (int i=0; i<1000; i++) {
      t.throwDice();
      if (t.getValue() < 1 || t.getValue() > 6) {
        System.out.println("ERROR "+ t.getValue());
      }
    }
  }

}
