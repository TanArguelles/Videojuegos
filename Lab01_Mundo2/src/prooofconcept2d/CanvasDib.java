/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author servkey
 */
public class CanvasDib extends Canvas{
    
    public int x = 10;
    public int y = 10;
    private int x_personaje = 300;
    private int y_personaje = 170;
    private int con_per = 1;
    private BufferedImage sample;
    private BufferedImage personaje;
    
    private BufferedImage cargarImagen(String file){
        BufferedImage img = null;
        try{
            URL image = getClass().getResource(file);
            img = ImageIO.read(image);
        }catch(Exception e){
        }
         return img;
    }
    
    @Override
    public void paint(Graphics g)
    {       
         //g.setColor(Color.BLUE);     //Activa el color azul
         //g.fillOval(getX(), getY(), 60, 60); //Dibuja un óvalo
         if (sample == null) sample = cargarImagen("./images/fondo4.png");
        
         g.drawImage(sample, x, 0, this);
         personaje = cargarImagen("./images/"+getCon_per()+".png");
         g.drawImage(personaje, x_personaje, y_personaje, this);  
         setCon_per(getCon_per());
         
    }   

    @Override
    public void update(Graphics g)
    {
       
    super.update(g);
        paint(g);
        musicafondo();
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the con_per
     */
    public int getCon_per() {
        return con_per;
    }

    /**
     * @param con_per the con_per to set
     */
    public void setCon_per(int con_per) {
        this.con_per = con_per+1;
        
        if(this.con_per>5){
            this.con_per=1;
        }
       // System.out.println("x"+con_per);
        
    }
      public void musicafondo() {

       try
    {
       AudioClip sonidoFondo = Applet.newAudioClip(getClass().getResource("./audio/forest.wav"));
        sonidoFondo.play();
      
    }
      
    catch(Exception e)
    {
      System.err.println(e);
    }
        }
      
      
      public void mover(){
          if(x_personaje < 650){
              x=x-10;
              x_personaje=x_personaje+20;
              
              if(con_per==5) con_per=1;
              con_per++;
              
                personaje = cargarImagen("./images/"+getCon_per()+".png");

          }
      }
      
      public void brincar(){
          
          if(y_personaje > 100){
              y=y+10;
              y_personaje=y_personaje+20;
              
              if(con_per==5) con_per=1;
              con_per++;
              
                personaje = cargarImagen("./images/"+getCon_per()+".png");

          }
      }
      
      
      public void moverAtras(){
          
          if(x_personaje > 0){
              x=x+10;
              x_personaje=x_personaje-20;
              
              if(con_per==5) con_per=1;
              con_per++;
              
                personaje = cargarImagen("./images/"+getCon_per()+".png");

          }
      }
       
}
