package trading;

public  class CalcolaTrading {
	
	
	
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
}
