package com.salasmartin.clase11.figuras;

public class Circle extends Figuras{


  public Circle( String color) {
    super(FigureType.CIRCULO, color);
  }

  @Override
  public String toString() {
    return "Circle";
  }
}
