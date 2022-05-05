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
  private Scanner clavier;

  public Game() {
    t = new Thimble();
    board = new Board();
    clavier= new Scanner(System.in);
  }

  /**
   * Start the party
   */
  public void start() {
    String classe;
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
    System.out.println(player.getName() + " est a la case 0 !" );
  }

  public void play() {
     int boardplace = 0;
    while (boardplace <64){
      t.throwDice();
      System.out.println(player.getName() + " Lance le dé et avance de : " + t.getValue()+ " cases !");
      boardplace += t.getValue() ;
      System.out.println(player.getName() + "est à la case " + boardplace + " et tombe sur : " + board.getBox(boardplace));
    }
    System.out.println("Bravo !!! Vous avez terminé la partie.");
  }
  public void replay(){
    System.out.println("Voulez vous relancer une partie ?");
    clavier.nextLine();
    if ()
  }

  public static void main(String[] args) {
    Game party = new Game();
    party.start();
    party.play();
  }

}

