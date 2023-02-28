package com.salasmartin.clase11.figuras;

public class Square extends Figuras{

  public Square(String color) {
    super(FigureType.CUADRADO, color);
  }

  @Override
  public String toString() {
    return "Square";
  }
}
