package com.hero.Exception;

public class WrongAnswer extends Exception {
  public WrongAnswer() {
    System.out.println("Veuillez rentrer un champ valide !");
  }
}
