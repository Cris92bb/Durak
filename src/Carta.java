import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Carta implements Carte{
	private String semeCarta;
	private char valoreCarta;
	private int puntiCarta;
    private Shape semeShape;
    private Color semeCol;

	
	public Carta(int numeroSeme, int sceltaValore){
		semeCarta=seme[numeroSeme];
		valoreCarta=valore[sceltaValore];
		puntiCarta= sceltaValore;
		semeShape=shapeSemi.getShape(semeCarta);
        semeCol= shapeSemi.getShapeColor(semeCarta);
	}
	public int punti(){
		return puntiCarta;
	}
	@Override
	public String display_Seme() {
		return semeCarta;
	}

	@Override
	public char display_Numero() {
		
		return valoreCarta;
	}
	public String toString(){
		return semeCarta+" "+valoreCarta;
	}

    public void drawCarta(Graphics2D g){



        g.draw(new Rectangle2D.Double(0,0,100,140));
        g.setColor(Color.white);
        g.fill(new Rectangle2D.Double(2, 2, 98, 138));
        g.setColor(Color.black);
        g.drawString(""+valoreCarta,20,20);
        g.drawString(""+valoreCarta,20,20);
        g.drawString(""+valoreCarta,80,20);
        g.drawString(""+valoreCarta,20,120);
        g.drawString(""+valoreCarta,80,120);
        AffineTransform af = AffineTransform.getTranslateInstance(30,50);
        g.transform(af);
        g.draw(semeShape);
        g.setColor(semeCol);
        g.fill(semeShape);


    }
    public void drawCartaBack(Graphics2D g){
        g.draw(new Rectangle2D.Double(0,0,100,140));
        g.setColor(Color.blue);
        g.fill(new Rectangle2D.Double(2, 2, 98, 138));

    }

}
