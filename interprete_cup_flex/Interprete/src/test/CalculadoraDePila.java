package test;

import java.util.LinkedList;

public class CalculadoraDePila {
  
  private LinkedList<Integer> mPila = new LinkedList<Integer>();
  
  public CalculadoraDePila() {
  }
  
  public void add() {
    try {
      
      mPila.push( mPila.pop() + mPila.pop() );      
      
    } catch (Exception ex) {
      
      System.out.println("===> Error push( pop() + pop() ha fallado, pila inconsistente");
      System.out.println("Volcado de Pila ");
      System.out.println( mPila.toString() );
      System.out.println("===> Fin Error");
      
    } finally {
    }    
  }
  
  public void sub() {
    try {
      
      mPila.push( mPila.pop() - mPila.pop() );      
      
    } catch (Exception ex) {
      
      System.out.println("===> Error push( pop() - pop() ha fallado, pila inconsistente");
      System.out.println("Volcado de Pila ");
      System.out.println( mPila.toString() );
      System.out.println("===> Fin Error");
      
    } finally {
    }    
  }
  
  public void mult() {
    try {
      
      mPila.push( mPila.pop() * mPila.pop() );      
      
    } catch (Exception ex) {
      
      System.out.println("===> Error push( pop() - pop() ha fallado, pila inconsistente");
      System.out.println("Volcado de Pila ");
      System.out.println( mPila.toString() );
      System.out.println("===> Fin Error");
      
    } finally {
    }    
  }
  
  public void div() {
    try {
      
      mPila.push( mPila.pop() / mPila.pop() );
      
    } catch (Exception ex) {
      
      System.out.println("===> Error push( pop() / pop() ha fallado, pila inconsistente");
      System.out.println("Volcado de Pila ");
      System.out.println( mPila.toString() );
      System.out.println("===> Fin Error");
      
    } finally {
    }    
  }
  
  public void print() {
    try {
      
      System.out.println( mPila.pop() );
      
    } catch (Exception ex) {
      
      System.out.println("===> Error print( pop() ) ha fallado");
      System.out.println("Volcado de Pila ");
      System.out.println( mPila.toString() );
      System.out.println("===> Fin Error");
      
    } finally {
    }    
  }
  
  public void push( Integer pNumber )
  {
      mPila.push( pNumber );
  }
  
}
