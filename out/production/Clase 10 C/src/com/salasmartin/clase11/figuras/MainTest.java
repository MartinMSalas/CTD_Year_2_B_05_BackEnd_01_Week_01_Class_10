package com.salasmartin.clase11.figuras;

import com.heading.example.jdbc.animalitos.model.Animalito;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
/*
Instrucciones
Les pedimos que, de manera individual, creen una tabla de figuras donde se guarden los tipos de figuras. Por ejemplo:
Figura: circulo
Color: rojo
Pista: No nos olvidemos que el ID es obligatorio.
Por lo tanto, les pedimos que:
Creen una conexión a la base de datos.
Inserten 2 círculos y 3 cuadrados de distinto color.
Creen una query para ver los círculos color rojo.
Mostrar todas las figuras en pantalla con un ResultSet y un System.out.println.
¡Manos a la obra!

 */
class MainTest {
  public static Logger logger = Logger.getLogger(Main.class);
  @Test
  public void testDataBaseConnected(){
    // Given
    try {
      Class.forName("org.h2.Driver");
    }
    catch(ClassNotFoundException ex) {
      logger.error("Error: unable to load driver class! " + ex.getMessage());
      System.exit(1);
    }

    String URL = "jdbc:h2:~/test";
    String USER = "sa";
    String PASS = "";

    String SQL_INSERT1 = "INSERT INTO backend01_class10figuras(ID, FIGURA, COLOR) VALUES(1, 'CIRCLE', 'BLUE');";
    String SQL_INSERT2 = "INSERT INTO backend01_class10figuras(ID, FIGURA, COLOR) VALUES(2, 'CIRCLE', 'PASSION');";
    String SQL_INSERT3 = "INSERT INTO backend01_class10figuras(ID, FIGURA, COLOR) VALUES(3, 'SQUARE', 'LIFE');";
    String SQL_INSERT4 = "INSERT INTO backend01_class10figuras(ID, FIGURA, COLOR) VALUES(4, 'SQUARE', 'RED');";
    String SQL_INSERT5 = "INSERT INTO backend01_class10figuras(ID, FIGURA, COLOR) VALUES(5, 'SQUARE', 'ORANGE');";

    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
         Statement stmt = conn.createStatement()){

      logger.info("Creating table in given database...");
      String createTable = "CREATE TABLE backend01_class10figuras(ID INT PRIMARY KEY, FIGURA VARCHAR(255), COLOR VARCHAR(255));";

      //[4a] - Utilizar el statement creado para insertar datos en la base de datos
      //stmt.execute(createTable);
      int registros = stmt.executeUpdate(SQL_INSERT1);
      registros = stmt.executeUpdate(SQL_INSERT2);
      registros = stmt.executeUpdate(SQL_INSERT3);
      registros = stmt.executeUpdate(SQL_INSERT4);
      registros = stmt.executeUpdate(SQL_INSERT5);
      logger.info("Se insertaron " + registros + " registros");//Se recomienda para INSERT, UPDATE y DELETE
//            int registros = stmt.executeUpdate(SQL_INSERT3); //Se recomienda para INSERT, UPDATE y DELETE
//            logger.info("Se insertaron " + registros + " registros");

      //[4b] - Utilizar ResultSet para obtener los datos provenientes de una consulta SQL

      ResultSet rs = stmt.executeQuery("SELECT * FROM backend01_class10figuras");

      System.out.println(rs);

      List<Figuras> figuras = new ArrayList<>();

      while (rs.next()){
        Figuras a = null;
        switch (rs.getString("FIGURA")){
          case "CIRCLE" :  a = new Circle(rs.getString("COLOR"));
                          break;
          case "SQUARE" :  a = new Square(rs.getString("COLOR"));
            break;

          default:
            throw new IllegalStateException("Unexpected value: " + rs.getString("FIGURA"));
        }



        figuras.add(a);
      }

      figuras.forEach(a -> System.out.println(a));

    } catch (SQLException ex) {
      logger.error(ex.getMessage());
    }

    // WHEN

    // Then

  }
}