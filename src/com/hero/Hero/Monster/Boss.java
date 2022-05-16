package com.hero.Hero.Monster;

import com.hero.Hero.Hero;

public class Boss extends Hero {


  public Boss (String name, int life, int damage, int xp){
    this.setName(name);
    this.setLife(life);
    this.setDamage(damage);
    this.setXp(xp);
  }
}


