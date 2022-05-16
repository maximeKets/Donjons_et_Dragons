package com.hero.Hero.Monster;

import com.hero.Hero.Hero;

public class Sorcier extends Hero {
  public Sorcier(){
    super("Sorcier", 9, 2, 500);
  }
  public Sorcier (int level) {
    this.setName("Sorcier");
    this.setLife(9 + level);
    this.setDamage(2 + level);
    this.setXp(500 + level * 100);
  }
}
