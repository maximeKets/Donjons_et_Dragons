package com.hero;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    Game party = new Game();
    // party.playGame();
  levelHero(800, 1);
  }
  public static int levelHero(int xp, int level){
    Map<Integer, Integer> tabLevel = new HashMap< >();
    int palierXp = 600;
    for (int i=1; i<=10 ; i++){
      palierXp += palierXp*0.30;
      tabLevel.put(i, palierXp);
    }
    for (int testLevel : tabLevel.values()){
      if(xp > testLevel){
        level = tabLevel.get(testLevel).intValue();
      }
    }
    System.out.println(level);
    return level;
  }
}
