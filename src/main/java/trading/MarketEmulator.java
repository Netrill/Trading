package trading;

import java.util.Random;

public class MarketEmulator {

    // Variabili di stato del mercato
    private double currentPrice;  // Prezzo corrente EUR/USD
    private Random random;
    private double deposito;
    private int percentualeDaGuadagnare=2;
    private double margineUtilizzato;

    // Costruttore
    public MarketEmulator(double startingPrice,int percentualeDaGuadagnare,double deposito) {
        this.currentPrice = startingPrice;
        this.random = new Random();
        this.deposito=deposito;
        this.percentualeDaGuadagnare=percentualeDaGuadagnare;
    }

    // Metodo per simulare la variazione del prezzo
    private double generateNewPrice() {
        double changePercent;
        
        // Simula un'impennata improvvisa con una probabilità del 5%
        if (random.nextDouble() < 0.05) {
            // Impennata improvvisa (o crollo) del 5% - 10% in una sola direzione
            changePercent = (random.nextDouble() - 0.5) * 0.20; // +/- 10% variazione improvvisa
            System.out.println("Impennata improvvisa!");
        } else {
            // Variazione normale del prezzo, +/- 0.5% (variazioni di mercato quotidiane)
            changePercent = (random.nextDouble() - 0.5) * 0.01; // +/- 0.5% variazione normale
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

	}
    
    private void variaAlgoritmo(double newPrice) {
		// TODO Auto-generated method stub

	}

    public  void startMarket(int nTick) {
        // Simula per 100 "tick" di mercato
    	int i=0;
    	boolean guadagnoRaggiunto=false;
    	
        while (i<nTick && !guadagnoRaggiunto) {
            double newPrice = this.generateNewPrice();
            System.out.printf("Tick %d: Prezzo EUR/USD: %.5f\n", i+1, newPrice);
            variaAlgoritmo(newPrice);
            // Aggiungi un breve ritardo per simulare i tempi del mercato reale
            try {
                Thread.sleep(5);  // 500 millisecondi di pausa tra i tick
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

	
}
