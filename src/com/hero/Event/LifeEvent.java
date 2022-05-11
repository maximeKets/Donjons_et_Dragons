package com.hero.Event;

import com.hero.Hero.Hero;
import com.hero.Potion.BigPotion;
import com.hero.Potion.Potion;
import com.hero.Potion.SmallPotion;

public class LifeEvent implements Event{
 Potion potion = null;

  @Override
  public String toString() {
    return ""+ potion ;
  }

  public LifeEvent (){
    int random = (int) (Math.random() * 2) + 1;
    if (random == 1){
      potion = new SmallPotion();
    }
    if (random == 2){
      potion = new BigPotion();
    }
  }

  @Override
  public void interagir(Hero hero) {
    int addLife = hero.getLife() + potion.getPotion();
    System.out.println("Vous trouvez "+ potion.getName() + " qui augmente votre vie de : "+ potion.getPotion()+ " points.");
      if (addLife >= hero.getMaxLife()){
        hero.setLife(hero.getMaxLife());
      }
      else {
      hero.setLife(addLife);
    }
    System.out.println("Vos points vie sont égal à " + hero.getLife() + " .");
  }
}
