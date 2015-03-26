import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;


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


    public class MyCanvas extends JPanel implements MouseListener{
        private Mazzo mazzo;
        private Carta first;
        private Carta visualizzata;
        private int x, y;


        public MyCanvas(Mazzo m){
            mazzo=m;
            setBackground(Color.green);
            addMouseListener(this);

        }
        public Dimension getPreferredSize(){
            return new Dimension(800,600);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            AffineTransform DEFAULT = g2.getTransform();

                if(!mazzo.isEmpty()) {
                    first = mazzo.prima_Carta();
                    first.drawCartaBack(g2);

                }
                if(visualizzata!=null){

                    AffineTransform at = AffineTransform.getTranslateInstance(x,y);
                    g2.setTransform(at);
                    visualizzata.drawCarta(g2);
                    
                    }

            g2.setTransform(DEFAULT);



        }



        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            x=mouseEvent.getX();
            y=mouseEvent.getY();
            visualizzata=first;
            repaint();


        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }




    }
    public static void main(String[] args){
        Mazzo deck = new Mazzo();
        deck.shuffle_Carte();
        new provaCarte(deck);

    }
}
