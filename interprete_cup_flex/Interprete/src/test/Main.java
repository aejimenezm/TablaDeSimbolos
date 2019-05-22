package test;

import java.io.FileReader;

public class Main {
  public Main() {
  }

  public static void main(String[] args) {

     /* if( args.length == 0 )
      {
          System.out.println("forma de uso java Main archivo.rgt");
          return;
      }*/

    try {

      Yylex lexer = new Yylex(new FileReader("prueba.txt"));

      parser p = new parser( lexer );

      p.parse();

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
    }

  }
}
