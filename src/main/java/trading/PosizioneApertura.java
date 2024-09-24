package trading;

public class PosizioneApertura {
	
	private int id;
	private double prezzoApertura;
	private double prezzoAttuale;
	private double guadagnoRimessa;
	private double lottoApertura;
	private String tipoOperazione;
	private Double valorePipette;
	
	
	
	public PosizioneApertura(int id,String tipoApertura,double prezzoApertura, double guadagnoRimessa, double lottoApertura, double takeProfit) {
		super();
		this.prezzoApertura = prezzoApertura;
		this.prezzoAttuale = prezzoApertura;
		this.guadagnoRimessa = guadagnoRimessa;
		this.lottoApertura = lottoApertura;
		this.tipoOperazione=tipoApertura;
		this.valorePipette=OperazioniTrading.calcolaValorePipette(prezzoApertura, lottoApertura);

	}
	public double getPrezzoApertura() {
		return prezzoApertura;
	}
	public void setPrezzoApertura(double prezzoApertura) {
		this.prezzoApertura = prezzoApertura;
	}
	public double getGuadagnoRimessa() {
		return guadagnoRimessa;
	}
	public void setGuadagnoRimessa(double guadagnoRimessa) {
		this.guadagnoRimessa = guadagnoRimessa;
	}
	public double getLottoApertura() {
		return lottoApertura;
	}
	public void setLottoApertura(double lottoApertura) {
		this.lottoApertura = lottoApertura;
	}
	public void aggiornaPosizione(double newPrice) {
		this.prezzoAttuale = newPrice;
		OperazioniTrading.calcolaProfittoPerditaInPipette(this.prezzoApertura, newPrice, this.tipoOperazione);
		
	}
	 

}
