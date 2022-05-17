package com.hero;

import com.hero.Hero.Hero;

import java.util.Scanner;


public class Menu {
  private Scanner clavier;




  public Menu() {
    clavier = new Scanner(System.in);
  }

  /**
   * Menu d'option
   *
   * @return int
   */
  public int actionMenu() {
    int choix = 0;
    System.out.println("Tapez 'I' pour afficher les informations du joueur, 'C' pour modifier le nom,  'Q' pour quitter et 'S' pour commencer la partie");
    String choice = clavier.nextLine();
    if (choice.equalsIgnoreCase("I")) {
      choix = 1;
    }
    else if (choice.equalsIgnoreCase("C")) {
      choix = 2;
    }
    else if (choice.equalsIgnoreCase("Q")) {
      System.out.println("Nous espérons vous revoir très vite !!! ");
      System.exit(0);
    }
    else if (choice.equalsIgnoreCase("S")) {
      choix = 3;
    }
    else {
      System.out.println("Réponse non valide.");
      actionMenu();
    }
    return choix;
  }


  public void continueGame() {
    System.out.println("Voulez vous continuer ? 'o' oui ou 'n' non");

    if (clavier.nextLine().equalsIgnoreCase("o")) {
      System.out.println("la partie continue !");
    }
    else if (clavier.nextLine().equalsIgnoreCase("n")) {
      System.exit(0);
    }
    else if (!clavier.nextLine().equalsIgnoreCase("o") ||!clavier.nextLine().equalsIgnoreCase("n")){
      System.out.println("Réponse non valide.");
      continueGame();
    }
  }

  public String choiceLever (){
    System.out.print("choisisez le niveau de dificulté : 'easy', 'medium', 'hard'");
    return clavier.nextLine();
  }
  public String choiceClass (){
    System.out.print("quel type de personnage vous voulez créer ? 'Wizzard' ou 'Warrior' ");
    return clavier.nextLine();
  }

  public String choiceName (){
    System.out.print("Quel nom donnez vous à votre personnage ? ");
return clavier.nextLine();
  }

  public void startParty (){
    System.out.println("Voulez vous Commencer une partie ? 'O' pour oui, 'N' pour non. ");
    String answer = clavier.nextLine();
    if (answer.equalsIgnoreCase("O")){
      System.out.println("");
    }
    else if (answer.equalsIgnoreCase("N")){
      System.exit(0);
    }
    else {
      System.out.println("Réponse non valide.");
      startParty();
    }

  }

  public void changeName (Hero hero ){
    System.out.print("Quel nom donnez vous à votre personnage ? ");
    hero.setName(clavier.nextLine());
  }

}
