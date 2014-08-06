import java.util.Vector;


public class Giocatore implements def_Giocatori{
	Vector<Carta> carteInMano = new Vector<Carta>(0);
	
	@Override
	public void pescaCarta(Carta prima) {
		carteInMano.add(prima);
		
	}

	@Override
	public void prendiDalTavolo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carta mettiSulTavolo(int i) {
		Carta inUscita= carteInMano.elementAt(i);
		carteInMano.remove(i);
		return inUscita;
	}
	
	public String toString(){
		String carte ="";
		for(int i=0; i<carteInMano.size();i++){
			carte+=i+") "+carteInMano.elementAt(i).toString()+" ";
		}
		return carte;
	}
}
