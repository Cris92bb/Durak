import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;


public class provaCarte extends JFrame {
    private MyCanvas myCanvas;

    public provaCarte(Mazzo deck){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cnt = getContentPane();
        setPreferredSize(new Dimension(800,600));
        setSize(new Dimension(800,600));
        myCanvas = new MyCanvas(deck);
        cnt.add(myCanvas, BorderLayout.CENTER);
        setVisible(true);
        setResizable(false);

    }


    public class MyCanvas extends JPanel implements MouseListener,MouseMotionListener{
        private Mazzo mazzo;
        private Carta first;
        private Carta visualizzata;
        private int dx,dy;
        private ArrayList<cartaPosFinale> carteSpostate = new ArrayList<cartaPosFinale>();



        public MyCanvas(Mazzo m){
            mazzo=m;
            setBackground(Color.green);
            addMouseMotionListener(this);
            addMouseListener(this);
            pescaPrima();


        }
        public Dimension getPreferredSize(){
            return new Dimension(800,600);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            AffineTransform DEFAULT = g2.getTransform();
                if(first!=null && !mazzo.isEmpty())
                    first.drawCartaBack(g2);

            if(!carteSpostate.isEmpty()){
                Iterator<cartaPosFinale> it = carteSpostate.iterator();
                while(it.hasNext()){
                    cartaPosFinale  c = it.next();
                    int x= c.pos[0];
                    int y= c.pos[1];
                    AffineTransform at = AffineTransform.getTranslateInstance(x,y);
                    g2.setTransform(at);
                    c.carta.drawCarta(g2);
                }
            }
            if(visualizzata!=null){
                AffineTransform at = AffineTransform.getTranslateInstance(dx,dy);
                g2.setTransform(at);
                visualizzata.drawCarta(g2);
            }

            g2.setTransform(DEFAULT);



        }
        public void pescaPrima(){
            first=mazzo.prima_Carta();
        }
        public void daVisualizzare(){
            visualizzata = first;
            first=mazzo.prima_Carta();
        }



        @Override
        public void mouseClicked(MouseEvent mouseEvent) {







        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            if(mouseEvent.getX()<100 && mouseEvent.getY() < 140)
                daVisualizzare();
            else visualizzata=null;

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            if(visualizzata!=null) {
                int[] pos = {dx, dy};

                carteSpostate.add(new cartaPosFinale(visualizzata, pos));

            }
            repaint();



        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }




        @Override
        public void mouseDragged(MouseEvent mouseEvent) {

            System.out.println("dragged");
            dx=mouseEvent.getX();
            dy=mouseEvent.getY();
            repaint();




        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {


        }
    }
    public static void main(String[] args){
        Mazzo deck = new Mazzo();
        deck.shuffle_Carte();
        new provaCarte(deck);

    }
}
