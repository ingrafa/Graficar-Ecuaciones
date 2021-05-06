/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.domini;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public abstract class Funcio extends Colisionable
{
  protected String expressio;
  protected IRegistrePunts punts;

  public Funcio(Grafica g)
  {
    super(g);
    escala = 0.01f;
    setRandomColor();
  }

  public abstract float getYValue(float xValue);

  public String getExpressio()
  {
    return expressio;
  }

  public String toString()
  {
    return expressio;
  }

  public void setPunts(IRegistrePunts punts)
  {
    this.punts = punts;
  }

  public void addPunt(float x, float y) throws Exception
  {
    Punt p = new Punt(x, y, this);
    punts.add(p);
  }

  public void removePunt(Punt p) throws Exception
  {
    punts.remove(p.getX(), p.getY());
  }

  public int getNumeroPunts()
  {
    return punts.size();
  }

  public ListIterator getPunts()
  {
    return punts.getPunts();
  }

  public void dibuixar(Graphics2D g2)
  {
    if (visible)
    {
      GeneralPath path = new GeneralPath();
      g2.setColor(color);
      g2.setStroke(new BasicStroke(2));
      path.setWindingRule(GeneralPath.WIND_EVEN_ODD);
      
      float xStart = map.getXMinWorld();
      float yStart = getYValue(map.getXMinWorld());
      
      if(Float.isNaN(yStart))
    	  yStart = getYValue(map.getXMinWorld() + escala);
    		  
      path.moveTo(map.toScreenX(xStart), map.toScreenY(yStart));
    		  
      for (float x = xStart; x <= map.getXMaxWorld(); x += escala)
      {
    	  float nextY = getYValue(x);
    	  if(Float.isNaN(getYValue(nextY)))
    		  nextY = getYValue(x + escala);
    	  
    	if(getYValue(x) < 100 && getYValue(x) > -100)    		
    		path.lineTo(map.toScreenX(x), map.toScreenY(nextY));
    	else
    	{
    		g2.draw(path);
    	    path = new GeneralPath();
    	    path.setWindingRule(GeneralPath.WIND_EVEN_ODD);
    	    path.moveTo(map.toScreenX(x), map.toScreenY(nextY) + escala);
    	}
      }

      path.lineTo(map.toScreenX(map.getXMaxWorld()), map.toScreenY(getYValue(map.getXMaxWorld())));
      g2.draw(path);
    }
  }

  public void dibuixarPunts(Graphics2D g2)
  {
    punts.dibuixar(g2);
  }

  protected Shape getShapeColisio()
  {
    GeneralPath gp = new GeneralPath();

    gp.moveTo(map.toScreenX(map.getXMinWorld()), map.toScreenY(getYValue(map.getXMinWorld())));

    for (float x = map.getXMinWorld(); x <= map.getXMaxWorld(); x += escala)
      gp.lineTo(map.toScreenX(x), map.toScreenY(getYValue(x)) - 15);
    gp.lineTo(map.toScreenX(map.getXMaxWorld()), map.toScreenY(getYValue(map.getXMaxWorld())));

    for (float x = map.getXMaxWorld(); x >= map.getXMinWorld(); x -= escala)
      gp.lineTo(map.toScreenX(x), map.toScreenY(getYValue(x)) + 15);
    gp.closePath();

    return gp;
  }

  public boolean equals(Object o)
  {
    if (!(o instanceof Funcio))
    {
      return false;
    }

    return ((Funcio)o).getExpressio().equals(expressio);
  }
}
