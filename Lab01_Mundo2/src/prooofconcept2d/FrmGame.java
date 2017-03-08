/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author servkey
 */
public class FrmGame extends JFrame implements KeyListener{
    private Thread t;
    private CanvasDib c;
    public FrmGame(CanvasDib c){
       
        this.c = c;
        this.addKeyListener(this);
        add(c);
        //Iniciar hilo
        t = new Thread(){
              public void run(){
                  updating();
              }
        };
        t.start();
     
        this.getContentPane().setBackground(Color.WHITE);
    }
    
    public void updating(){
       /* while (true){
            try {
                Thread.sleep(200);
                c.repaint();
                c.setX(c.getX()-2);
               
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }*/
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
 if(e.getKeyCode()==39){
       try {
                c.mover();
                Thread.sleep(150);     
                c.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            }    
      if(e.getKeyCode()==38){
           try {
                c.brincar();
                Thread.sleep(150);     
                c.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            } 
      }
        if(e.getKeyCode()==37){
           try {
                c.moverAtras();
                Thread.sleep(150);     
                c.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            } 
      }
 }   
    
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
