package com.hero;

import com.hero.Board.Board;
import com.hero.Board.Thimble;
import com.hero.Champ.Hero;
import com.hero.Champ.Warrior;
import com.hero.Champ.Wizzard;
import java.util.Scanner;

public class Game {
  private Thimble t;
  private Hero player;
  private Board board;

  public Game() {
    t = new Thimble();
    board = new Board();
  }

  /**
   * Start the party
   */
  public void start() {
    String classe;
    Scanner clavier = new Scanner(System.in);
    System.out.print("quel type de personnage vous voulez créer ? 'Wizzard' ou 'Warrior' ");
    classe = clavier.nextLine();
    player = createHero(classe);
    System.out.print("Quel nom donnez vous à votre personnage ? ");
    player.setName(clavier.nextLine());
    menuRepeat();
  }

  /**
   * Function pour choisir la classe du persponnage
   *
   * @param classe
   * @return
   */
  public Hero createHero(String classe) {
    if (classe.equals("Wizzard")) {
      player = new Wizzard();
    } else if (classe.equals("Warrior")) {
      player = new Warrior();
    }
    return player;
  }

  /**
   * Menu d'option
   *
   * @param choice
   * @return
   */
  public void actionMenu(String choice) {
    Scanner clavier = new Scanner(System.in);
    if (choice.equals("I")) {
      System.out.println();
      menuRepeat();
    }
    if (choice.equals("C")) {
      System.out.print("Quel nom donnez vous à votre personnage ? ");
      player.setName(clavier.nextLine());
      System.out.println();
      menuRepeat();
    }
    if (choice.equals("Q")){
      System.out.println("Nous espérons vous revoir très vite !!! ");
      System.exit(0);
    }
    if (choice.equals("S")){
      startGame();
    }
  }

  /**
   * Permet d'afficher le menu tant que la partie n'est pas lancé ni quitté
   */
  public void menuRepeat(){
    Scanner clavier = new Scanner(System.in);
    System.out.println("");
    System.out.println("Tapez 'I' pour afficher les informations du joueur, 'C' pour modifier le nom,  'Q' pour quitter et 'S' pour commencer la partie" );
    String choice = clavier.nextLine();
    actionMenu(choice);
  }

  public void startGame(){
    System.out.println("la Partie Commence !");
    System.out.println(player.getName() + " est a la case " + board.getBox(0));
  }

  public void play() {
    while(true) { // tant que le jeu n'est pas terminé
      // jouer
    }
  }

  public static void main(String[] args) {
    Game party = new Game();
    party.start();
    party.play();
  }

}

