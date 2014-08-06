import java.util.Vector;
public class Mazzo implements def_Mazzo{
	
	Vector<Carta> mazzo= new Vector();
	
	public Mazzo(){
		ResetMazzo();
	}
	
	@Override
	public int numero_Carte() {
		// TODO Auto-generated method stub
		return mazzo.size();
	}

	@Override
	public Carta prima_Carta() {
		Carta prima = mazzo.elementAt(0);
		mazzo.remove(0);
		return prima;
		
	}
	

	@Override
	public void shuffle_Carte() {
		Vector<Carta> Mazzo_def = mazzo;
		Vector<Carta> Mazzo_shuffled = new Vector<Carta>();
		while(Mazzo_def.size()>0){
			int index = (int)(Math.random()*Mazzo_def.size());
			Carta carta_random = Mazzo_def.elementAt(index);
			Mazzo_shuffled.add(carta_random);
			Mazzo_def.removeElementAt(index);
		}
		mazzo=Mazzo_shuffled;
		
		
	}
	public boolean isEmpty(){
		if(mazzo.size()==0)
			return true;
		else
			return false;
	}
	

	@Override
	public void ResetMazzo() {
		for(int seme =0; seme < 4;seme++){
			for (int valore=0; valore<13;valore++){
				mazzo.addElement(new Carta(seme,valore));
			}
		}
	}

}
