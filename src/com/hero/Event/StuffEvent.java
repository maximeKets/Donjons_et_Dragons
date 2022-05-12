package com.hero.Event;

import com.hero.Hero.Champion.Warrior;
import com.hero.Hero.Champion.Wizzard;
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
    System.out.println("Vous trouvez " + loot.getName() + ", cette arme augmente la force de " +loot.getDamage()+ " points.");
    if ((hero instanceof Warrior && loot instanceof Blade) || (hero instanceof Warrior  && loot instanceof Hammer))
    {
      hero.setLeftHand(loot);
      System.out.println("Votre force est désormais de "+ hero.getDamage() + "+" + hero.getLeftHand().getDamage());
    }
    else if ((hero instanceof Wizzard && loot instanceof Storm) || (hero instanceof Wizzard  && loot instanceof Fireball))
    {
      hero.setLeftHand(loot);
      System.out.println("Votre force est désormais de "+ hero.getDamage() + "+" + hero.getLeftHand().getDamage());
    }
    else{
      System.out.println("Votre classe ne permet pas d'équiper cette arme :(");
    }
  }
}

