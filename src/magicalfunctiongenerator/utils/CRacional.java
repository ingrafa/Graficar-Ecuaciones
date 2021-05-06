/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.utils;

public class CRacional
{
  // Atributos
  private long numerador;
  private long denominador;

  // M�todos
  public void simplificar()
  {
    // M�ximo com�n divisor
    long mcd, temp, resto;
    mcd = Math.abs(numerador);
    temp = Math.abs(denominador);
    while (temp > 0)
    {
      resto = mcd % temp;
      mcd = temp;
      temp = resto;
    }
    // Simplificar
    if (mcd > 1)
    {
      numerador /= mcd;
      denominador /= mcd;
    }
  }

  public CRacional() // constructor
  {
    numerador = 0;
    denominador = 1;
  }

  public CRacional(long num) // constructor
  {
    numerador = num;
    denominador = 1;
  }

  public CRacional(float num)
  {
    String s = num + "";

    numerador = Long.parseLong(s.replaceAll("\\.", ""));

    int ceros = s.length() - s.indexOf(".") - 1;
    s = "1";
    for (int i = 0; i < ceros; i++)
    {
      s += "0";

    }
    denominador = Long.parseLong(s);
    simplificar();
  }

  public CRacional(long num, long den) // constructor
  {
    numerador = num;
    denominador = den;
    if (denominador == 0)
    {
      System.out.println("Error: denominador 0. Se asigna 1.");
      denominador = 1;
    }
    if (denominador < 0)
    {
      numerador = -numerador;
      denominador = -denominador;
    }
    simplificar();
  }

  public CRacional(CRacional r) // constructor copia
  {
    numerador = r.numerador;
    denominador = r.denominador;
  }

// Sumar n�meros racionales
  public CRacional sumar(CRacional r)
  {
    return new CRacional(numerador * r.denominador + denominador * r.numerador, denominador * r.denominador);
  }

// Restar n�meros racionales
  public CRacional restar(CRacional r)
  {
    return new CRacional(numerador * r.denominador - denominador * r.numerador, denominador * r.denominador);
  }

// Multiplicar n�meros racionales
  public CRacional multiplicar(CRacional r)
  {
    return new CRacional(numerador * r.numerador, denominador * r.denominador);
  }

// Dividir n�meros racionales
  public CRacional dividir(CRacional r)
  {
    return new CRacional(numerador * r.denominador, denominador * r.numerador);
  }

// Verificar si dos n�meros racionales son iguales
  public boolean equals(CRacional r)
  {
    return (numerador * r.denominador == denominador * r.numerador);
  }

// Verificar si un racional es menor que otro
  public boolean menor(CRacional r)
  {
    return (numerador * r.denominador < denominador * r.numerador);
  }

// Verificar si un racional es mayor que otro
  public boolean mayor(CRacional r)
  {
    return (numerador * r.denominador > denominador * r.numerador);
  }

// Devolver un n�mero racional como cadena
  public String toString()
  {
    if (numerador == denominador)
    {
      return "1";
    }
    else if (numerador == 0)
    {
      return "0";
    }
    else if (denominador == 1)
    {
      return numerador + "";
    }
    else
    {
      return new String(numerador + "/" + denominador);
    }
  }


// Copiar un racional en otro
  public CRacional copiar(CRacional r)
  {
    numerador = r.numerador;
    denominador = r.denominador;
    return this;
  }

// Verificar si es 0
  public boolean esCero()
  {
    return numerador == 0;
  }

// Incrementar en 1
  public CRacional incrementar()
  {
    numerador += denominador;
    return this;
  }

// Decrementar en 1
  public CRacional decrementar()
  {
    numerador -= denominador;
    return this;
  }

// - unario
  public CRacional cambiadoDeSigno()
  {
    CRacional temp = new CRacional( -numerador, denominador);
    return temp;
  }
}
