package com.hero.Potion;

public abstract class Potion {
private int potion;
private String name ;

  Potion(String name, int potion){
    this.name = name;
    this.potion =potion;
}

  public int getPotion() {
    return potion;
  }

  public String getName() {
    return name;
  }

}
