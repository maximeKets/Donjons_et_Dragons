package com.hero;

import com.hero.Board.*;
import com.hero.Hero.Hero;
import com.hero.Hero.Champion.Warrior;
import com.hero.Hero.Champion.Wizzard;
import com.hero.Exception.PersonnageHorsPlateauException;
import com.hero.Exception.WrongAnswer;

import java.util.Scanner;

public class Game {
  private Thimble t;
  private Hero player;
  private Board board;
  private Scanner clavier;

  public Game() {
    t = new Thimble();
    clavier = new Scanner(System.in);
  }

  /**
   * Start the party
   */
  public void start() {
    String input;
    System.out.print("choisisez le niveau de dificulté : 'easy', 'medium', 'hard'");
    input = clavier.nextLine();
    board = createBoard(input);
    System.out.print("quel type de personnage vous voulez créer ? 'Wizzard' ou 'Warrior' ");
    input = clavier.nextLine();
    try {
      player = createHero(input);
    }
    catch (WrongAnswer e){
      System.out.println(e);;
    }

    System.out.print("Quel nom donnez vous à votre personnage ? ");
    player.setName(clavier.nextLine());
    menuRepeat();
  }

  /**
   * Function pour choisir la classe du persponnage
   *
   * @param classe
   * @return player
   */
  public Hero createHero(String classe) throws WrongAnswer {
    if (classe.equals("Wizzard")) {
      player = new Wizzard();
    }
    if (classe.equals("Warrior")) {
      player = new Warrior();
    }
    else {
      throw new WrongAnswer();
    }
    return player;
  }

  /**
   * Menu d'option
   *
   * @param choice
   * @return void
   */
  public void actionMenu(String choice) {
    if (choice.equals("I")) {
      System.out.println(player);
      menuRepeat();
    }
    if (choice.equals("C")) {
      System.out.print("Quel nom donnez vous à votre personnage ? ");
      player.setName(clavier.nextLine());
      System.out.println();
      menuRepeat();
    }
    if (choice.equals("Q")) {
      System.out.println("Nous espérons vous revoir très vite !!! ");
      System.exit(0);
    }
    if (choice.equals("S")) {
      startGame();
    }
  }

  /**
   * Permet d'afficher le menu tant que la partie n'est pas lancé ni quitté
   */
  public void menuRepeat() {
    Scanner clavier = new Scanner(System.in);
    System.out.println("");
    System.out.println("Tapez 'I' pour afficher les informations du joueur, 'C' pour modifier le nom,  'Q' pour quitter et 'S' pour commencer la partie");
    String choice = clavier.nextLine();
    actionMenu(choice);
  }

  /**
   * place le joueur a la case 0 et lance la partie
   */
  public void startGame() {
    System.out.println("la Partie Commence !");
    System.out.println(player.getName() + " est a la case 0 !");
  }

  /**
   * joue une partie
   */
  public void play() {
    int boardplace = 0;
    boolean fini = false;
    while (!fini) {
      t.throwDice();
      System.out.println(player.getName() + " Lance le dé et avance de : " + t.getValue() + " cases !");
      boardplace += t.getValue();
      try {
        Box box = board.getBox(boardplace);
        System.out.println(player.getName() + " est à la case " + boardplace + " et tombe sur : " + box);
        box.interagir(player);
      } catch (PersonnageHorsPlateauException e) {
        fini = true;
        System.out.println(e);
      }
      System.out.println("Voulez vous continuer ? 'oui' ou 'non'");

      if (clavier.nextLine().equalsIgnoreCase("o")){
        continue;
      }
      if (clavier.nextLine().equalsIgnoreCase("n")){
        replay();
      }

    }

  }

  /**
   * fonction pour relancer une partie
   */
  public void replay() {
    System.out.println("Voulez vous Commencer une partie ? 'O' pour oui, 'N' pour non. ");
    if (clavier.nextLine().equalsIgnoreCase("O")) {
      start();
      play();
      replay();

    } else if (clavier.nextLine().equals("N")) {
      System.exit(0);
    }
  }

  /**
   * permet de choisir la difficulté du plateau
   * @param input
   * @return newBoard
   */
  public Board createBoard(String input) {
    Board newBoard = null;
    if (input.equals("easy")) {
      newBoard = new EasyBoard();
    }
    if (input.equals("medium")) {
      newBoard = new MediumBoard();
    }
    if (input.equals("hard")) {
      newBoard = new HardBoard();
    }
    return newBoard;
  }

  public static void main(String[] args) {
    Game party = new Game();
    party.replay();

  }

}

