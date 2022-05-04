package com.hero;

import com.hero.Champ.Hero;
import com.hero.Champ.Warrior;
import com.hero.Champ.Wizzard;

import java.util.Scanner;

public class Game {

  public static void main(String[] args) {

    Game party = new Game();
    party.start();
  }

  /**
   * Start the party
   */
  public void start() {
    String classe;
    String choice;
    Hero newHero;
    Scanner clavier = new Scanner(System.in);
    System.out.print("quel type de personnage vous voulez créer ? 'Wizzard' ou 'Warrior' ");
    classe = clavier.nextLine();
    newHero = chooseClass(classe);
    System.out.print("Quel nom donnez vous à votre personnage ? ");
    newHero.setName(clavier.nextLine());
    System.out.println("Tapez 'I' pour afficher les informations du joueur ou 'C' pour modifier le nom");
    choice = clavier.nextLine();
    showOrModify(choice, newHero);
  }

  /**
   * Function pour choisir la classe du persponnage
   *
   * @param classe
   * @return
   */
  public static Hero chooseClass(String classe) {
    Hero choice = null;
    if (classe.equals("Wizzard")) {
      choice = new Wizzard();
    } else if (classe.equals("Warrior")) {
      choice = new Warrior();
    }
    return choice;
  }

  /**
   * Menu d'option
   *
   * @param choice
   * @param newHero
   * @return
   */
  public static Hero showOrModify(String choice, Hero newHero) {
    Scanner clavier = new Scanner(System.in);
    if (choice.equals("I")) {
      System.out.println(newHero);
    } else if (choice.equals("C")) {
      System.out.print("Quel nom donnez vous à votre personnage ? ");
      newHero.setName(clavier.nextLine());
      System.out.println(newHero);
    }
    return newHero;
  }


}

