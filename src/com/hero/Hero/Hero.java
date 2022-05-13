package com.hero.Hero;

import com.hero.Stuff.Stuff;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
  private String name;
  private int life;
  private int maxLife;
  private int damage;
  private int maxDamage;
  private Stuff leftHand;
  private String rightHand;


  private int level;

  private int xp;

  public Hero(int level, String name, int life, int maxLife, int damage, int maxDamage) {
    this.name = name;
    this.life = life;
    this.maxLife = maxLife;
    this.damage = damage;
    this.maxDamage = maxDamage;
    this.level = level;
  }

  public Hero() {
  }

  public Hero(String name, int life, int damage, int xp) {
    this.name = name;
    this.life = life;
    this.damage = damage;
    this.xp = xp;
  }


  /*--------------------------------------------------------------------------Getter & Setter------------------------------------------------------------------------*/

  // NAME
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // DAMAGE
  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  // LIFE
  public int getLife() {
    return life;
  }
  public void setLife(int life) {
    this.life = life;
  }

  public int getMaxDamage() {
    return maxDamage;
  }
  public void setMaxDamage(int maxDamage) {
    this.maxDamage = maxDamage;
  }

  public int getMaxLife() {
    return maxLife;
  }
  public void setMaxLife(int maxLife) {
    this.maxLife = maxLife;
  }

  // lEFT HAND
  public Stuff getLeftHand() {
    return leftHand;
  }
  public void setLeftHand(Stuff leftHand) {
    this.leftHand = leftHand;
  }

  // RIGHT HAND
  public String getRightHand() {
    return rightHand;
  }
  public void setRightHand(String rightHand) {
    this.rightHand = rightHand;
  }

  // LEVEL
  public int getLevel() {
    return level;
  }
  public void setLevel(int level) {
    this.level = level;
  }

  // XP
  public int getXp() {
    return xp;
  }
  public void setXp(int xp) {
    this.xp = xp;
  }

  /*-------------------------------------------------------------------------function-------------------------------------------------------------------------- */

  /**
   * Affiche le nom du Hero avec ses points de vie et sa force
   * return information champion
   */
  public String toString() {
    return "Votre Héro est un " + getClass().getSimpleName() + ", Nommé = " + this.name + " = point de vie : " + this.life + " | point de domage : " + this.damage;
  }


}
