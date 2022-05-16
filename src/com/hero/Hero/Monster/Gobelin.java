package com.hero.Hero.Monster;

import com.hero.Hero.Hero;

public class Gobelin extends Hero {
  public Gobelin(){
  super("Gobelin", 6, 1, 350);
}

  public Gobelin (int level){
    this.setName("Gobelin");
    this.setLife(6+level);
    this.setDamage(1+level);
    this.setXp(350 + level*100);
  }
}
