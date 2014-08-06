
public class Carta implements Carte{
	private String semeCarta;
	private char valoreCarta;
	private int puntiCarta;
	
	public Carta(int numeroSeme, int sceltaValore){
		semeCarta=seme[numeroSeme];
		valoreCarta=valore[sceltaValore];
		puntiCarta= sceltaValore;
		
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

}
