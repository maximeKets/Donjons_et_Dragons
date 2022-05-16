package com.hero.Hero.Monster;

import com.hero.Hero.Hero;

public class Dragon extends Hero {
  public Dragon(){
    super("Dragon", 15, 4, 900);
  }

  public Dragon (int level){
    this.setName("Dragon");
    this.setLife(15+level);
    this.setDamage(4+level);
    this.setXp(900 + level*100);
  }
}
