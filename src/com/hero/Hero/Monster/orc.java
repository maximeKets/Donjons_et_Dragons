package com.hero.Hero.Monster;

import com.hero.Hero.Hero;

public class orc extends Hero {
  public orc(){
    super("orc", 8, 3, 550);
  }

  public orc (int level){
    this.setName("orc");
    this.setLife(8+level);
    this.setDamage(3+level);
    this.setXp(550 + level*100);
  }
}
