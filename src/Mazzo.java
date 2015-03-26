import java.util.ArrayList;

public class Mazzo implements def_Mazzo{
	
	ArrayList<Carta> mazzo= new ArrayList<Carta>();
	
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
		Carta prima = mazzo.get(0);
		mazzo.remove(0);
		return prima;
		
	}
	

	@Override
	public void shuffle_Carte() {
		ArrayList<Carta> Mazzo_def = mazzo;
		ArrayList<Carta> Mazzo_shuffled = new ArrayList<Carta>();
		while(Mazzo_def.size()>0){
			int index = (int)(Math.random()*Mazzo_def.size());
			Carta carta_random = Mazzo_def.get(index);
			Mazzo_shuffled.add(carta_random);
			Mazzo_def.remove(index);
		}
		mazzo=Mazzo_shuffled;
		
		
	}
	
	public boolean isEmpty(){ return (mazzo.size()==0); }

	@Override
	public void ResetMazzo() {
		for(int seme =0; seme < 4;seme++){
			for (int valore=0; valore<13;valore++){
				mazzo.add(new Carta(seme,valore));
			}
		}
	}

}
