package trading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public  class CalcolaTrading {
	
	static Map<Integer, String> operazioni= new HashMap<Integer,String>();
	
	
	public CalcolaTrading () {
		
	}
	
	static public double calcolaMargine() {
		return 0.0;
	}
	static public double calcolaraRenditaComposta (int percentuale,double deposito,int mesi,int giorni) {
		double appoCapitale=deposito;
		for (int i=1; i<mesi*giorni;i++) {
			appoCapitale=appoCapitale+appoCapitale/100*percentuale;
			System.out.println("-----------------------------");
			System.out.println("Mese: "+i+" guadagnato: "+appoCapitale);
			System.out.println("-----------------------------");
		}
		System.out.printf("Idealmente dopo mesi: "+mesi+" il capitale totale dovrebbe essere circa €: %.7f \n",appoCapitale);
		return appoCapitale;
	}
	static public double calcolaMargine(double prezzoApertura,int leva,double lotto) {
		return (prezzoApertura * lotto * 100000)/leva;
	}
	static public double calcolaValorePipette(double prezzoApertura,int leva,double lottoApertura) {
		return (double) (0.000001/prezzoApertura*lottoApertura*100000);
	}
	
	static public Boolean testMassimoMovimentoOscillatorio (double prezzoApertura,double lottoIniziale,double percentualeDesiderata,double deposito,int op) {
		operazioni.put(0, "BUY");
		operazioni.put(1, "SELL");
		
		double margineResiduo=deposito;
		for (int i=1;i<10;i++) {
			System.out.println("-----------------------------");
			System.out.println("Operazione: "+i+" ,apro posizione in "+ operazioni.get(i%2)+" "+"di lotto: "+lottoIniziale);
			margineResiduo=margineResiduo-calcolaValorePipette(prezzoApertura,500,lottoIniziale)*10-calcolaMargine(prezzoApertura,500,lottoIniziale);
			System.out.println("Rimane margine €: "+margineResiduo);
			
			System.out.println("-----------------------------");
			lottoIniziale=lottoIniziale*2;
			if (margineResiduo<=deposito/100*20) {
				System.out.println("Attenzione limite stop out superato!!!!!!!");
				return false;
			}
		}
		return true;
	}
	static public Boolean testMovimentoMercatoCasuale (double prezzoApertura,double lottoIniziale,double percentualeDesiderata,double deposito,int op) {
		int n=200000;
		int volumeMassimoCandela=600;
		int nCandele=24;
		int candela[][] = new int [nCandele][];
		int dimensioneCandela []= new int [24];
		for (int i=0;i<nCandele;i++) {
			dimensioneCandela[i]=ThreadLocalRandom.current().nextInt(10, 30);
			candela[i] = new int [dimensioneCandela[i]];
			int op1=ThreadLocalRandom.current().nextInt(0,1);
			for (int j=0;i<dimensioneCandela[i];j++) {
				candela[i][j]=op1;
			}
		}
			int  movimentoMercatoQuotidiano [];
			movimentoMercatoQuotidiano = new int [n];
		 
		for (int i=0;i<n;i++) {
			movimentoMercatoQuotidiano[i]=(int) ThreadLocalRandom.current().nextInt(0,1);
			
		}
		 
		for  (int i=0;i<nCandele;i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, n-volumeMassimoCandela);
			for (int j=randomNum;j<dimensioneCandela[i];j++) {
				movimentoMercatoQuotidiano[j]=candela[i][j];
				System.out.println(movimentoMercatoQuotidiano[i]);
			}
		}
		 
		return true;
	}
}
