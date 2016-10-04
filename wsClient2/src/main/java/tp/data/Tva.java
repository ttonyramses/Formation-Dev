package tp.data;

public class Tva {

	private double ht;
	private double tauxPct;
	private double tva;
	private double ttc;
	
	public Tva() {
		// TODO Auto-generated constructor stub
	}

	public Tva(double ht, double tauxPct, double tva, double ttc) {
		super();
		this.ht = ht;
		this.tauxPct = tauxPct;
		this.tva = tva;
		this.ttc = ttc;
	}

	public double getHt() {
		return ht;
	}

	public void setHt(double ht) {
		this.ht = ht;
	}

	public double getTauxPct() {
		return tauxPct;
	}

	public void setTauxPct(double tauxPct) {
		this.tauxPct = tauxPct;
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	public double getTtc() {
		return ttc;
	}

	public void setTtc(double ttc) {
		this.ttc = ttc;
	}

	@Override
	public String toString() {
		return "Tva [ht=" + ht + ", tauxPct=" + tauxPct + ", tva=" + tva + ", ttc=" + ttc + "]";
	}
	
	

}
