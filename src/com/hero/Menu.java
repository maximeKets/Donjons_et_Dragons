package com.hero;

import com.hero.Board.Thimble;

import java.util.Scanner;


public class Menu {
  private Scanner clavier;
  private Thimble t;



  public Menu() {
    t = new Thimble();
    clavier = new Scanner(System.in);
  }

   /* -----------------------------------G & S ------------------------------------------ */


  /*-----------------------------------function ------------------------------------------ */
  /**
   * Menu d'option
   *
   * @return int
   */
  public int actionMenu() {
    int choix = 0;
    System.out.println("Tapez 'I' pour afficher les informations du joueur, 'C' pour modifier le nom,  'Q' pour quitter et 'S' pour commencer la partie");
    String choice = clavier.nextLine();
    if (choice.equals("I")) {
      choix = 1;
    }
    if (choice.equals("C")) {
      choix = 2;
    }
    if (choice.equals("Q")) {
      System.out.println("Nous espérons vous revoir très vite !!! ");
      System.exit(0);
    }
    if (choice.equals("S")) {
      choix = 3;
    }
    return choix;
  }


  public void continueGame() {
    System.out.println("Voulez vous continuer ? 'oui' ou 'non'");

    if (clavier.nextLine().equalsIgnoreCase("o")) {
      System.out.println("la partie continue !");
    }
    if (clavier.nextLine().equalsIgnoreCase("n")) {
      System.exit(0);
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

  public String startParty (){
    System.out.println("Voulez vous Commencer une partie ? 'O' pour oui, 'N' pour non. ");
    return clavier.nextLine();
  }
}
