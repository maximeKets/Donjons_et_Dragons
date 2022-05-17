package com.hero.Event;

import com.hero.Exception.OverBoardPlayer;
import com.hero.Game;
import com.hero.Hero.Hero;
import com.hero.Hero.Monster.*;


public class EnemyEvent implements Event {
  Hero enemy = null;
  Game party = new Game();


  @Override
  public String toString() {
    return "" + enemy;
  }

  public EnemyEvent (String level){
    if (level.equals("easy")){
      enemy = new Boss("Boss_1", 30, 3, 1000);
    }
    if (level.equals("medium")) {
      enemy = new Boss("Boss_2", 40, 4, 2500);
    }
    if (level.equals("hard")) {
      enemy = new Boss("Boss_3", 50, 5, 3000);
    }
  }

  public EnemyEvent(int level) {
    if (level == 1) {
      int random = (int) (Math.random() * 3) + 1;
      if (random == 1) {
        enemy = new Dragon();
      }
      if (random == 2) {
        enemy = new Gobelin();
      }
      if (random == 3) {
        enemy = new Sorcier();
      }
    }
    if (level == 2){
      int random = (int) (Math.random() * 4) + 1;
      if (random == 1) {
        enemy = new Dragon(1);
      }
      if (random == 2) {
        enemy = new Gobelin(1);
      }
      if (random == 3) {
        enemy = new Sorcier(1);
      }
      if (random == 4){
        enemy = new orc();
      }
    }
    if(level == 3){
      int random = (int) (Math.random() * 5) + 1;
      if (random == 1) {
        enemy = new Dragon(2);
      }
      if (random == 2) {
        enemy = new Gobelin(2);
      }
      if (random == 3) {
        enemy = new Sorcier(2);
      }
      if (random == 4){
        enemy = new orc(1);
      }
      if (random == 5){
        enemy = new Elfe_Noir();
      }
    }
  }


  @Override
  public void interagir(Hero hero)  {
    int degatMonstre = enemy.getDamage();
    int vieHero = hero.getLife();
    int vieMonstre = enemy.getLife();
    String name = enemy.getName();
    int degatHero = hero.getDamage();

    if (hero.getLeftHand() != null) {
      degatHero = hero.getDamage() + hero.getLeftHand().getDamage();
    }

    if (degatHero >= hero.getMaxDamage()) {
      degatHero = hero.getMaxDamage();
    }

    System.out.println("le combat commence !");
    while (vieMonstre > 0 || vieHero < 0) {
      System.out.println("vous attaquez " + name + " et lui enlevez " + degatHero + " point de vie");
      vieMonstre -= degatHero;
      if (vieMonstre <= 0) {
        enemy.setLife(vieMonstre);
        System.out.println("Bravo ! Vous avez tué l'énemie ! ");
        System.out.println("Il vous reste " + vieHero + " points de vie.");
        System.out.println("Vous gagnez " + enemy.getXp() + " Point d'éxpériences");
        hero.setXp(hero.getXp() + enemy.getXp());
        party.evolutionPlayer(hero);
      }
      if (vieMonstre > 0) {
        System.out.println(name + " à encore " + vieMonstre + ", il réplique et vous attaque.");
        hero.setLife(vieHero - degatMonstre);
        vieHero -= degatMonstre;
        System.out.println("vous perdez " + degatMonstre + "point de vie. Il vous reste : " + vieHero + " point de vie..");
      }
      if (vieHero <= 0) {
        System.out.println("vous êtes décédé !");
        party.playGame();
      }
    }
  }
}

