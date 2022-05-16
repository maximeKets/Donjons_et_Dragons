package com.hero.Stuff;

public class Stuff {
  public String name;
  public int damage;
  public String familly;



  public Stuff(String name, int damage, String familly) {
    this.name = name;
    this.damage = damage;
    this.familly = familly;
  }
  public Stuff(){};

  public int getDamage() {
    return damage;
  }

  public String getName() {return name;}

  public String getFamilly() {
    return familly;
  }
}
