package trading;



public class MainTraing {

	public static void main(String[] args) {
		int numeroPipetteGraveScazzo=40000;
	
		double prezzoAttuale=(double) 1.112100;
		double prezzoApertura=(double) 1.112100;
		double prezzoChiusura=(float) 1.112100;
		double differenzaPrezzo=Math.abs(prezzoApertura-prezzoChiusura);
		int scala=500;
		double lottoApertura=0.4;
		double valorePip=(double) ((0.0001/prezzoApertura)*lottoApertura*100000);
		double valorePipette=(double) (0.000001/prezzoApertura*lottoApertura*100000);
		System.out.printf("Se apri con: "+lottoApertura+" lotti, ogni pip vale €: %.7f ",valorePip);
		System.out.println();
		System.out.printf("Se apri con: "+lottoApertura+" lotti, ogni pipette vale €: %.7f ",valorePipette);
		System.out.println("Numero pipette grave scazzo: "+numeroPipetteGraveScazzo);
		System.out.printf("In caso di gravissimo scazzo potresti perdere €: %.7f ",numeroPipetteGraveScazzo*valorePipette);
	}

}
