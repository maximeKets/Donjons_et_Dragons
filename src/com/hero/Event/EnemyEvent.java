package com.hero.Event;

import com.hero.Game;
import com.hero.Hero.Hero;
import com.hero.Menu;
import com.hero.Hero.Monster.Dragon;
import com.hero.Hero.Monster.Gobelin;
import com.hero.Hero.Monster.Sorcier;


public class EnemyEvent implements Event {
  Hero enemy = null;
  Game party = new Game();
  Menu menu = new Menu();

  @Override
  public String toString() {
    return "" + enemy;
  }

  public EnemyEvent() {
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

  @Override
  public void interagir(Hero hero) {
    int degatMonstre = enemy.getDamage();
    int vieHero = hero.getLife();
    int vieMonstre = enemy.getLife();
    String name = enemy.getName();
    int degatHero = hero.getDamage();

    if(hero.getLeftHand() != null){
      degatHero = hero.getDamage()+hero.getLeftHand().getDamage();
    }

     if (degatHero >= hero.getMaxDamage()) {
       degatHero = hero.getMaxDamage();
     }

    System.out.println("le combat commence !");
    while (vieMonstre >= 0 || vieHero <= 0) {
      System.out.println("vous attaquez " + name + " et lui enlevez " + degatHero + " point de vie");
      vieMonstre -= degatHero;
      if (vieMonstre <= 0) {
        enemy.setLife(vieMonstre);
        System.out.println("Bravo ! Vous avez tué l'énemie ! ");
        System.out.println("Il vous reste " + vieHero + " points de vie.");
      }
      if (vieMonstre > 0 ){
        System.out.println(name + " à encore " + vieMonstre + ", il réplique et vous attaque.");
        hero.setLife(vieHero - degatMonstre);
        vieHero -= degatMonstre;
        System.out.println("vous perdez " + degatMonstre + "point de vie. Il vous reste : " + vieHero + " point de vie..");
      }
      if (vieHero <= 0){
        System.out.println("vous êtes décédé !");
        party.playGame();
      }
    }
  }
}

