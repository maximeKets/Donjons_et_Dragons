package com.hero.Champ;

import com.hero.Stuff.Stuff;

public class Hero {
  private String name;
  private int life;
  private int maxLife;
  private int damage;
  private int maxDamage;
  private Stuff leftHand ;
  private String rightHand;

  public Hero(String name, int life,  int maxLife, int damage, int maxDamage) {
    this.name = name;
    this.life = life;
    this.maxLife = maxLife;
    this.damage = damage;
    this.maxDamage = maxDamage;
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

  /*-------------------------------------------------------------------------function-------------------------------------------------------------------------- */
  /**
   * Affiche le nom du Hero avec ses points de vie et sa force
   */
  public String toString() {
    return "Votre Héro est un "+ getClass()  + ", Nommé = " +this.name + " = " + "point de vie : " + this.life + " | " + "point de domage : "+ this.damage;
  }
}
