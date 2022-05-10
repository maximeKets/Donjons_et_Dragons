package com.hero.Event;

import com.hero.Hero.Hero;
import com.hero.Potion.Potion;
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
    System.out.println("Vous trouvez " + loot.getName() + ", cette arme augmente votre force de " +loot.getDamage()+ " points.");
    hero.setLeftHand(loot);
    System.out.println("Votre force est désormais de "+ hero.getDamage() + "+" + hero.getLeftHand().getDamage());
  }
}

