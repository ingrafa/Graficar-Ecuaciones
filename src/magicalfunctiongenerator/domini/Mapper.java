/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.domini;


public class Mapper
{
  public static final float DISTANCIA_MINIMA = 1.0f;
  public static final float DISTANCIA_MAXIMA = 100.0f;
  public static final float XIFRA_MAXIMA = 50.0f;
  public static final float XIFRA_MINIMA = -50.0f;
  private float xminw, xmaxw, yminw, ymaxw; // Coordenades de m�n
  private int xmins, xmaxs, ymins, ymaxs; // Coordenades de pantalla

  public Mapper(float xminw, float xmaxw, float yminw, float ymaxw, int xmins, int xmaxs, int ymins, int ymaxs, Grafica grafica)
  {
    this.xminw = xminw;
    this.xmaxw = xmaxw;
    this.yminw = yminw;
    this.ymaxw = ymaxw;

    this.xmins = xmins;
    this.xmaxs = xmaxs;
    this.ymins = ymins;
    this.ymaxs = ymaxs;
  }

  public float getXMinWorld()
  {
    return xminw;
  }

  public float getXMaxWorld()
  {
    return xmaxw;
  }

  public float getYMinWorld()
  {
    return yminw;
  }

  public float getYMaxWorld()
  {
    return ymaxw;
  }

  public int getXMinScreen()
  {
    return xmins;
  }

  public int getXMaxScreen()
  {
    return xmaxs;
  }

  public int getYMinScreen()
  {
    return ymins;
  }

  public int getYMaxScreen()
  {
    return ymaxs;
  }

  public float getDistX()
  {
    return getDist(xminw, xmaxw);
  }

  public float getDist(float min, float max)
  {
    return Math.abs(max - min);
  }

  public float getDistY()
  {
    return getDist(yminw, ymaxw);
  }

  public int toScreenX(float x)
  {
    float A = (xmins - xmaxs) / (xminw - xmaxw);
    float B = (xminw * xmaxs - xmaxw * xmins) / (xminw - xmaxw);
    return (int)(A * x + B);
  }

  public int toScreenY(float y)
  {
    float A = (ymaxs - ymins) / (yminw - ymaxw);
    float B = (yminw * ymins - ymaxw * ymaxs) / (yminw - ymaxw);
    return (int)(A * y + B);
  }

  public float toWorldX(int x)
  {
    float A = (xminw - xmaxw) / (xmins - xmaxs);
    float B = (xmins * xmaxw - xmaxs * xminw) / (xmins - xmaxs);
    return (A * x + B);
  }

  public float toWorldY(int y)
  {
    float A = (ymaxw - yminw) / (ymins - ymaxs);
    float B = (ymins * yminw - ymaxs * ymaxw) / (ymins - ymaxs);
    return (A * y + B);
  }

  public int toScreenXmin()
  {
    return toScreenX(xminw);
  }

  public int toScreenXmax()
  {
    return toScreenX(xmaxw);
  }

  public int toScreenYmin()
  {
    return toScreenY(yminw);
  }

  public int toScreenYmax()
  {
    return toScreenY(ymaxw);
  }

  public void setWorldCoords(float xminw, float xmaxw, float yminw, float ymaxw)
  {
    boolean xok = true, yok = true;

    if (xminw < this.XIFRA_MINIMA)
    {
      this.xminw = this.XIFRA_MINIMA;
      this.xmaxw = xmaxw + (this.XIFRA_MINIMA - xminw);
      xok = false;
    }
    else if (xmaxw > this.XIFRA_MAXIMA)
    {
      this.xmaxw = this.XIFRA_MAXIMA;
      this.xminw = xminw - (xmaxw - this.XIFRA_MAXIMA);
      xok = false;
    }
    if (yminw < this.XIFRA_MINIMA)
    {
      this.yminw = this.XIFRA_MINIMA;
      this.ymaxw = ymaxw + (this.XIFRA_MINIMA - yminw);
      yok = false;
    }
    else if (ymaxw > this.XIFRA_MAXIMA)
    {
      this.ymaxw = this.XIFRA_MAXIMA;
      this.yminw = yminw - (ymaxw - this.XIFRA_MAXIMA);
      yok = false;
    }

    if(xok)
    {
      this.xminw = xminw;
      this.xmaxw = xmaxw;
    }
    if(yok)
    {
      this.yminw = yminw;
      this.ymaxw = ymaxw;
    }

     if(this.getDist(xminw, xmaxw) > this.DISTANCIA_MAXIMA)
     {
       this.xminw = XIFRA_MINIMA;
       this.xmaxw = XIFRA_MAXIMA;
     }
     if(this.getDist(yminw, ymaxw) > this.DISTANCIA_MAXIMA)
     {
       this.yminw = XIFRA_MINIMA;
       this.ymaxw = XIFRA_MAXIMA;
     }

  }

  public void setScreenCoords(int xmins, int xmaxs, int ymins, int ymaxs)
  {
    this.xmins = xmins;
    this.xmaxs = xmaxs;
    this.ymins = ymins;
    this.ymaxs = ymaxs;
  }

  public boolean isWorld(float xminw, float xmaxw, float yminw, float ymaxw)
  {
    return this.xminw == xminw && this.xmaxw == xmaxw && this.yminw == yminw && this.ymaxw == ymaxw;
  }

  public boolean isScreen(int xmins, int xmaxs, int ymins, int ymaxs)
  {
    return this.xmins == xmins && this.xmaxs == xmaxs && this.ymins == ymins && this.ymaxs == ymaxs;
  }
}
