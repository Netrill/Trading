package trading;

public class PosizioneApertura {
	
	private int id;
	private double prezzoApertura;
	private double guadagnoRimessa;
	private double lottoApertura;
	private double takeProfit;
	 
	
	
	
	public PosizioneApertura(int id,double prezzoApertura, double guadagnoRimessa, double lottoApertura, double takeProfit) {
		super();
		this.prezzoApertura = prezzoApertura;
		this.guadagnoRimessa = guadagnoRimessa;
		this.lottoApertura = lottoApertura;
		this.takeProfit = takeProfit;

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
	public double getTakeProfit() {
		return takeProfit;
	}
	public void setTakeProfit(double takeProfit) {
		this.takeProfit = takeProfit;
	}
	 

}
