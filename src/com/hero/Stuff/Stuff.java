package com.hero.Stuff;

public class Stuff {
  public String name;
  public int damage;



  public Stuff(String name, int damage) {
    this.name = name;
    this.damage = damage;
  }
  public Stuff(){};

  public int getDamage() {
    return damage;
  }

  public String getName() {return name;}
}
