/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

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
    
    private int x = 10;
    private int y = 10;
    private int x_personaje = 100;
    private int y_personaje = 570;
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
         if (sample == null) sample = cargarImagen("./images/fondo3.png");
        
         g.drawImage(sample, x, 0, this);
         personaje = cargarImagen("./images/"+getCon_per()+".png");
         g.drawImage(personaje, x_personaje, y_personaje, this);  
         setCon_per(getCon_per());
         
    }   

    @Override
    public void update(Graphics g)
    {
       //
    super.update(g);
        paint(g);
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
    
        
}
