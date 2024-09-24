package trading;

import java.util.List;

public class OperazioniTrading {

	public static double calcolaValorePipette(double prezzoApertura,double lottoApertura) {
		return (double) (0.000001/prezzoApertura*lottoApertura*100000);
	}
	public static double calcolaValorePip(double prezzoApertura,double lottoApertura) {
		return (double) ((0.0001/prezzoApertura)*lottoApertura*100000);
	}
	

    // Metodo per controllare se la lista è mediamente crescente
    public static boolean isMediamenteCrescente(List<Double> values) {
        int countIncrease = 0;
        int countDecrease = 0;

        // Ciclo per verificare se i valori stanno crescendo o decrescendo
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) > values.get(i - 1)) {
                countIncrease++;
            } else if (values.get(i) < values.get(i - 1)) {
                countDecrease++;
            }
        }

        // Se gli incrementi superano i decrementi, possiamo considerarla mediamente crescente
        return countIncrease > countDecrease;
    }

 // Metodo per calcolare guadagno o perdita in pipette per buy o sell
    public static int calcolaProfittoPerditaInPipette(double prezzoApertura, double prezzoAttuale, String posizione) {
        // Calcola la differenza tra il prezzo attuale e il prezzo di apertura
        double differenza = prezzoAttuale - prezzoApertura;

        // Calcola il numero di pipette (1 pipette = variazione alla sesta cifra decimale)
        int pipette = (int) (differenza * 1000000); // moltiplica per 10^6 per ottenere pipette

        // Determina guadagno o perdita in base al tipo di posizione (buy o sell)
        if (posizione.equalsIgnoreCase("BUY")) {
            if (pipette > 0) {
                return pipette;
            } else if (pipette < 0) {
                return -pipette;
            } else {
                return 0;
            }
        }
        if (posizione.equalsIgnoreCase("SELL")) {
            if (pipette < 0) {
                return pipette;
            } else if (pipette > 0) {
                return - pipette;
            } else {
                return 0;
            }
        }
        return 0;
    }

}
