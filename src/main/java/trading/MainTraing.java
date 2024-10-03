package trading;



public class MainTraing {

	public static void main(String[] args) {
		int numeroPipetteGraveScazzo=40000;
		int obbietivoGionalieroGuadagnoPercentuale=2,numeroMesiTrading=12,numeroGiorniTrading=20;;
		int spread=10;
		int leva=500;
		double margine=0;
		double capitaleDisponibile=1000;
		double lottoApertura=0.04;
		double prezzoAttuale=(double) 1.112100;
		double prezzoApertura=(double) 1.112100;
		double prezzoChiusura=(float) 1.112100;
		double differenzaPrezzo=Math.abs(prezzoApertura-prezzoChiusura);
		
		System.out.println("----------------------");
		System.out.printf("Se apri con: "+lottoApertura+" lotti, ogni pip vale €: %.7f \n",valorePip);
		System.out.println("Ci rimetti generalmente a ogni apertura €: "+spread*valorePipette );
		System.out.printf("Se apri con: "+lottoApertura+" lotti, ogni pipette vale €: %.7f \n",valorePipette);
		System.out.printf("In caso di gravissimo scazzo potresti perdere €: %.7f \n",numeroPipetteGraveScazzo*valorePipette);
		System.out.println("Con il capitale di €: "+capitaleDisponibile+" e l'obbiettivo di guadagno del: "+obbietivoGionalieroGuadagnoPercentuale+"% "
				+ "devi guadagnare € : " + capitaleDisponibile/100*obbietivoGionalieroGuadagnoPercentuale);		
		System.out.println("----------------------");
		
		margine=CalcolaTrading.calcolaMargine (prezzoApertura, leva, lottoApertura);
		System.out.println("Il margine €: "+margine +", ovvero il : "+(margine/capitaleDisponibile)*100 + " %");
		System.out.println("Prima di uno stop out del 20% posso scendere al massimo di €: "+(capitaleDisponibile/100)*80);
		//CalcolaTrading.testMassimoMovimentoOscillatorio(prezzoApertura, lottoApertura, 2, capitaleDisponibile, 0);
		//CalcolaTrading.testMovimentoMercatoCasuale(prezzoApertura, lottoApertura, 2, capitaleDisponibile, 0);
		
		// Inizializza il simulatore con un prezzo iniziale di 1.1000
        MarketEmulator market = new MarketEmulator(1.1000,2,capitaleDisponibile);
        market.startMarket(200000);
	}

}
