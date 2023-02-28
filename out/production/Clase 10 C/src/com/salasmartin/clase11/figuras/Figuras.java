package com.salasmartin.clase11.figuras;

public abstract class Figuras {
  private Enum<FigureType> typeEnum;
  private String color;


  public Figuras(Enum<FigureType> typeEnum, String color) {
    this.typeEnum = typeEnum;
    this.color = color;
  }

  public abstract String toString();

  public Enum<FigureType> getTypeEnum() {
    return typeEnum;
  }

  public void setTypeEnum(Enum<FigureType> typeEnum) {
    this.typeEnum = typeEnum;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


}
