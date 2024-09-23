package trading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarketEmulator {

    // Variabili di stato del mercato
    private double currentPrice;  // Prezzo corrente EUR/USD
    private Random random;
    private double capitale;
    private int percentualeDaGuadagnare=2;
    private double margineUtilizzato;
    private double saldo;
    private double lineaSupporto;
    private double lineaResistenza;
    private double intervalloPerApertura;
    private double intervalloPerTakeProfit;
    private double valorePipette;
    private boolean posizioniAperte;
    private List<PosizioneApertura> listaPosizioniAperte;
    private int nPosizioniAperte;
    private double cifraDaGuadagnare;

    // Costruttore
    public MarketEmulator(double startingPrice,int percentualeDaGuadagnare,double capitale) {
        this.currentPrice = startingPrice;
        this.random = new Random();
        this.capitale=capitale;
        this.percentualeDaGuadagnare=percentualeDaGuadagnare;
        this.margineUtilizzato=0;
        this.saldo=capitale;
        this.intervalloPerApertura=0.000250;
        this.posizioniAperte=false;
        listaPosizioniAperte=new ArrayList<PosizioneApertura>();
        this.nPosizioniAperte=0;
        this.cifraDaGuadagnare=capitale/100*percentualeDaGuadagnare;
        
    }
    
    boolean checkStopOut() {
    	if (margineUtilizzato>=capitale/100*80)
    		return true;
    	return false;
    }
    double calcolaObbiettivoGiornaliero() {
    	return capitale/100*percentualeDaGuadagnare;
    }
    
    boolean checkChiusura() {
    	if (saldo-capitale>=calcolaObbiettivoGiornaliero())
    		return true;
    	return false;
    }

    // Metodo per simulare la variazione del prezzo
    private double generateNewPrice() {
        double changePercent;
        
        // Simula un'impennata improvvisa con una probabilit√† del 5%
        if (random.nextDouble() < 0.05) {
            // Impennata improvvisa (o crollo) del 5% - 10% in una sola direzione
            changePercent = (random.nextDouble() - 0.5) * 0.20; // +/- 10% variazione improvvisa
            System.out.println("Impennata improvvisa!");
        } else {
            // Variazione normale del prezzo, +/- 0.5% (variazioni di mercato quotidiane)
            changePercent = (random.nextDouble() - 0.5) * 0.00005; // +/- 0.5% variazione normale
        }
        
        // Calcola la variazione e aggiorna il prezzo corrente
        double change = currentPrice * changePercent;
        currentPrice += change;
        return currentPrice;
    }

    // Metodo per ottenere il prezzo corrente
    private double getCurrentPrice() {
        return currentPrice;
    }
    
    private void startAlgoritmo(double newPrice) {
		
    	// Fissare la prima apertura
    	this.lineaSupporto=newPrice + this.intervalloPerApertura;
    	this.lineaResistenza=newPrice - this.intervalloPerApertura;
    	
	}
    
    private void checkApertura(double newPrice) {
		// TODO Auto-generated method stub
    	if (newPrice <= this.lineaSupporto) {
    		System.out.println("Sfondata Linea Supporto");
    		this.lineaSupporto = this.lineaSupporto + this.intervalloPerTakeProfit;
    		nPosizioniAperte++;
    		this.listaPosizioniAperte.add(new PosizioneApertura(nPosizioniAperte,newPrice,0.1,newPrice+intervalloPerTakeProfit,newPrice+intervalloPerTakeProfit ));
    	}
    	if (newPrice >= this.lineaResistenza) {
    		System.out.println("Sfondata Linea Resistenza");
    		this.lineaResistenza = this.lineaResistenza - this.intervalloPerTakeProfit;
    		nPosizioniAperte++;
    		this.listaPosizioniAperte.add(new PosizioneApertura(nPosizioniAperte,newPrice,0.1,newPrice+intervalloPerTakeProfit,newPrice-intervalloPerTakeProfit ));
    	}
    	
    	
	}
    private boolean chekTakeProfit(double price) {
    	for (int i=0;i<this.listaPosizioniAperte.size()-1;i++) {
    		this.listaPosizioniAperte.get(i).getPrezzoApertura()
    	}
    }

    public  void startMarket(int nTick) {
        // Simula per 100 "tick" di mercato
    	int i=0;
    	boolean guadagnoRaggiunto=false;
    	try {
	        while (i<nTick && !guadagnoRaggiunto && !checkStopOut()) {
	            double newPrice = this.generateNewPrice();
	            System.out.printf("Tick %d: Prezzo EUR/USD: %.5f\n", i+1, newPrice);
	            if (!posizioniAperte)
	            	checkApertura(newPrice);
	            else {
	            	aggiornaAperture(newPrice);
	            	checkTakeProfit();
	            }
	            // Aggiungi un breve ritardo per simulare i tempi del mercato reale
	            try {
	                Thread.sleep(5);  // 500 millisecondi di pausa tra i tick
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            i++;
	        }
    	}catch(Exception e) {
    		System.out.println("Errore : "+e.getMessage());
    	}
    }

	private void aggiornaAperture(double newPrice) {
		for (int i=0;i<this.listaPosizioniAperte.size();i++) {
			this.listaPosizioniAperte.get(i).aggiornaPosizione(newPrice);
		}
		
	}

	private boolean checkTakeProfit() {
		
		//Idealmente dovrebbe chiudere quando una posizione non puÚ rendere di pi˘
		double guadagnoRimessaAttuale=0;;
		for (int i=0;i<this.listaPosizioniAperte.size();i++) {
			guadagnoRimessaAttuale=guadagnoRimessaAttuale+this.listaPosizioniAperte.get(i).getGuadagnoRimessa();
		}
		if (guadagnoRimessaAttuale>=this.cifraDaGuadagnare)
			return true;
		return false;
	}

	
}
