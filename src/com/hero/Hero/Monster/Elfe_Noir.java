package com.hero.Hero.Monster;

import com.hero.Hero.Hero;

public class Elfe_Noir extends Hero {
  public Elfe_Noir(){
    super("orc", 10, 6,  1000);
  }

  public Elfe_Noir (int level){
    this.setName("orc");
    this.setLife(10+level);
    this.setDamage(6+level);
    this.setXp(100 + level*100);
  }
}
