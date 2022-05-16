package com.hero;

import com.hero.Board.*;
import com.hero.Event.EnemyEvent;
import com.hero.Exception.WrongAnswer;
import com.hero.Hero.Hero;
import com.hero.Hero.Champion.Warrior;
import com.hero.Hero.Champion.Wizzard;


public class Game {
  private Dice t;
  private Hero player;
  private Board board;
  private Menu menu;

  public Game() {
    t = new Dice();
    menu = new Menu();
  }

  /**
   * Start the party
   */
  public void start() {
    board = createBoard(menu.choiceLever());
    while (board == null){
      board = createBoard(menu.choiceLever());
    }
    while (player == null){
      try {
        player = createHero(menu.choiceClass());
      } catch (WrongAnswer e) {
        System.out.println(e);
      }
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
    if (classe.equalsIgnoreCase("Wizzard")) {
      player = new Wizzard();
    } else if (classe.equalsIgnoreCase("Warrior")) {
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
    while (boardplace < board.size()) {
      t.throwDice();
      System.out.println(player.getName() + " Lance le dé et avance de : " + t.getValue() + " cases !");
      boardplace += t.getValue();
        Box box = board.getBox(boardplace);
        if (boardplace >= board.size()){
          boardplace = board.size();
          System.out.println("Vous Arrivez à la dernière case, vous allez combatre le BOSS ");
          box.interagir(player);
        }
        if (boardplace < board.size()){
          System.out.println(player.getName() + " est à la case " + boardplace + " et tombe sur : " + box);
          box.interagir(player);
          menu.continueGame();
        }
    }
    System.out.println("Bravo vous avez gagné !");
  }
  /**
   * permet de choisir la difficulté du plateau
   *
   * @param input
   * @return newBoard
   */
  public Board createBoard(String input) {
    Board newBoard = null;
    if (input.equalsIgnoreCase("easy")) {
      newBoard = new EasyBoard();
    }
    else if (input.equalsIgnoreCase("medium")) {
      newBoard = new MediumBoard();
    }
    else if (input.equalsIgnoreCase("hard")) {
      newBoard = new HardBoard();
    }
    else {
      System.out.println("Veuillez rentrer un champ valide.");
    }
    return newBoard;
  }

  /**
   * fonction pour relancer une partie
   */
  public void playGame() {
    menu.startParty();
      start();
      int end = 0;
      while ( end < 1)
        switch (menu.actionMenu()) {
          case 1:
            System.out.println(player);
            break;

          case 2:
           menu.changeName(player);
            break;

          case 3:
            end = 1;
            startGame();
            break;
        }

      play();
      playGame();

  }
  public void evolutionPlayer (Hero player){
    int newXp = player.levelHero(player.getXp(), player.getLevel());
    int lastLevel = player.getLevel();
    player.setLevel(newXp);
    if (player.getLevel() >= lastLevel) {
      int differenceLevel = player.getLevel() - lastLevel;
      System.out.println(" Félicitation ! Votre héro vient de gagner" + differenceLevel);
      System.out.println("Vous gagnez "+ differenceLevel + " point de dégats Max et " + differenceLevel + " point de vie Max");
      System.out.println("Vous récuperez " + differenceLevel+ " Points de vie");
      int newMaxLife = player.getMaxLife()+ player.getLevel();
      int newMaxDamage = player.getMaxDamage() + player.getLevel();
      int gainhp = player.getLife() +differenceLevel;
      player.setMaxLife(newMaxLife);
      player.setMaxDamage(newMaxDamage);
      player.setLife(gainhp);
    }
  }

}

