package com.hero.Event;

import com.hero.Hero.Champion.Warrior;
import com.hero.Hero.Champion.Wizzard;
import com.hero.Hero.Hero;
import com.hero.Stuff.*;

public class StuffEvent implements Event {
  Stuff loot = null;

  public StuffEvent() {
    int random = (int) (Math.random() * 4) + 1;
    if (random == 1) {
      loot = new Blade();
    }
    if (random == 2) {
      loot = new Fireball();
    }
    if (random == 3) {
      loot = new Hammer();
    }
    if (random == 4) {
      loot = new Storm();
    }
  }

  @Override
  public void interagir(Hero hero) {
    System.out.println("Vous trouvez " + loot.getName() + ", cette arme augmente la force de " + loot.getDamage() + " points.");
    if (hero.getLeftHand() != null) {
      int previousLootDamage = hero.getLeftHand().getDamage();
        if (previousLootDamage < loot.getDamage()) {
          testClassloot(loot, hero);
        } else {
          System.out.println("cette arme est inutilisable, Passe ton chemin");
        }
      }
     else {
      testClassloot(loot, hero);
    }
  }

  public void testClassloot (Stuff loot, Hero hero){
    if (loot.getFamilly().equals(hero.getClass().getSimpleName())) {
      hero.setLeftHand(loot);
      System.out.println("Votre force est désormais de " + hero.getDamage() + "+" + hero.getLeftHand().getDamage());
    } else {
      System.out.println("Votre classe ne permet pas d'équiper cette arme :(");
    }
  }
}


