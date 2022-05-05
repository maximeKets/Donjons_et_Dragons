package com.hero.Board;

public class Box {
  private String content;

  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return content;
  }
}
