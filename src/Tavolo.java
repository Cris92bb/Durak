import java.util.Vector;


public class Tavolo {
	private Vector<Carta> carteSulTavolo = new Vector();
	
	private int conta=0;
	
	
	
	public void Tavolo(){
		
	}
	public boolean isEmpty(){
		if(carteSulTavolo.size()==0)
			return true;
		else 
			return false;
	}
	public boolean addCarta(Carta x){
		if(isEmpty()){
		carteSulTavolo.addElement(x);
		return true;}
		else if(ricerca(x.punti())){
			carteSulTavolo.addElement(x);
		return true;}
		else return  false;
	}
	public boolean ricerca(int x){
		boolean uguali = false;
		for(int i =0; i<carteSulTavolo.size();i++){
			if(x==carteSulTavolo.elementAt(i).punti())
				uguali = true;
				
		}
		return uguali;
	}
	public boolean attacca(Carta x){
		if(x.punti()>carteSulTavolo.elementAt(conta).punti()){
			carteSulTavolo.addElement(x);
			conta+=2;
			return true;
		}
		else
			return false;
			
		}
			
			
	public void reset(){
		carteSulTavolo.removeAllElements();
	}
	
	public Carta primaCarta(){
		Carta x= carteSulTavolo.elementAt(0);
		carteSulTavolo.removeElementAt(0);
		return x;
	}
	

}
