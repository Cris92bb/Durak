import java.util.Vector;
import java.util.Scanner;


public class Prova {
	private static Giocatore uno = new Giocatore();
	private static Giocatore due = new Giocatore();
	private static Mazzo mPoker = new Mazzo();
	static Tavolo tavolo = new Tavolo();
	static Scanner tastiera = new Scanner(System.in);
	
	public static void main(String[] args){
		
		
		
		
	}
	public static void difendi(){
		
	}
	public static void attacca(Giocatore x){
		System.out.println(x);
		int sceltaCarta= tastiera.nextInt();
		Carta y=x.mettiSulTavolo(sceltaCarta)	;
		if(tavolo.attacca(y))
			System.out.println("TAVOLO: "+tavolo);
		
		
	}
	
	
	
	

}
