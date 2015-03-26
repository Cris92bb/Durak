import java.awt.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;


public class shapeSemi {

    public static Shape getShape(String seme){
        if(seme.equals("quadri")){
            return getQuadri();
        }else if(seme.equals("fiori")){
            return getFiori();
        }else if (seme.equals("picche")) {
            return getPicche();
        }
        else return getCuori();
    }
    public static Color getShapeColor(String seme){
        if(seme.equals("picche") || seme.equals("fiori")){
            return Color.black;
        }else return Color.red;

    }

    private static Shape getQuadri(){
        GeneralPath gp = new GeneralPath();
        gp.moveTo(0,20);
        gp.lineTo(40,20);
        gp.lineTo(20,40);
        gp.lineTo(0,20);
        gp.lineTo(20,0);
        gp.closePath();
        return gp;
    }
    private static Shape getCuori(){

        GeneralPath gp = new GeneralPath();
        gp.moveTo(8,0);
        gp.lineTo(12,0);
        gp.lineTo(20,4);
        gp.lineTo(28,0);
        gp.lineTo(36,0);
        gp.lineTo(40,20);
        gp.lineTo(20,40);
        gp.lineTo(0,20);
        gp.lineTo(8,0);
        gp.closePath();
        return gp;

    }

    private static Shape getPicche(){
        GeneralPath gp = new GeneralPath();
        gp.moveTo(20,0);
        gp.lineTo(40,20);
        gp.lineTo(32,36);
        gp.lineTo(20,32);
        gp.lineTo(24,40);
        gp.lineTo(16,40);
        gp.lineTo(20,32);
        gp.lineTo(12,36);
        gp.lineTo(8,36);
        gp.lineTo(0,20);
        gp.lineTo(20,0);
        gp.closePath();

        return gp;

    }

    private static Shape getFiori(){
        GeneralPath gp = new GeneralPath();
        Ellipse2D cSup = new Ellipse2D.Double(8,0,12,12);
        Ellipse2D cSin = new Ellipse2D.Double(0,12,12,12);
        Ellipse2D cDes = new Ellipse2D.Double(18,12,12,12);
        gp.append(cSup,false);
        gp.append(cSin,false);
        gp.append(cDes,false);
        gp.closePath();
        return gp;
    }
}
