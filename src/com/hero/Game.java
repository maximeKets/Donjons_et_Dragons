package com.hero;

import com.hero.Board.*;
import com.hero.Exception.WrongAnswer;
import com.hero.Hero.Hero;
import com.hero.Hero.Champion.Warrior;
import com.hero.Hero.Champion.Wizzard;
import com.hero.Exception.PersonnageHorsPlateauException;

import java.util.Scanner;


public class Game {
  private Thimble t;
  private Hero player;
  private Board board;
  private Scanner clavier;
  private Menu menu;

  public Game() {
    t = new Thimble();
    menu = new Menu();
    clavier = new Scanner(System.in);
  }

  /**
   * Start the party
   */
  public void start() {
    board = createBoard(menu.choiceLever());
    try {
      player = createHero(menu.choiceClass());
    } catch (WrongAnswer e) {
      System.out.println(e);
    }
    player.setName(menu.choiceName());
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
    } else if (classe.equals("Warrior")) {
      player = new Warrior();
    } else {
      throw new WrongAnswer();
    }
    return player;
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
      menu.continueGame();
    }
  }
  /**
   * permet de choisir la difficulté du plateau
   *
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

  /**
   * fonction pour relancer une partie
   */
  public void playGame() {
    if (menu.startParty().equals("O")) {
      start();
      int end = 0;
      while ( end < 1)
        switch (menu.actionMenu()) {
          case 1:
            System.out.println(player);
            break;

          case 2:
            System.out.print("Quel nom donnez vous à votre personnage ? ");
            player.setName(clavier.nextLine());
            break;

          case 3:
            end = 1;
            startGame();
            break;
        }

      play();
      playGame();

    } else if (menu.startParty().equals("N")) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    Game party = new Game();
    party.playGame();
  }

}

