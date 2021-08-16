package classes;




import java.util.Date;

public class Treatment {
	
	private int id;
        private static int count=0;
	private Date date;
	private TreatmentType treatmentType;
	private int toothNumber;
	private double price;
	private boolean isPaid;
	
	
	public Treatment() {
		super();
                id=  count++;
	}
	public Treatment(Date date, TreatmentType treatmentType, int toothNumber, double price, boolean isPaid) {
		super();
		this.id = count++;
		this.date = date;
		this.treatmentType = treatmentType;
		this.toothNumber = toothNumber;
		this.price = price;
		this.isPaid = isPaid;
	}
	public int getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TreatmentType getTreatmentType() {
		return treatmentType;
	}
	public void setTreatmentType(TreatmentType treatmentType) {
		this.treatmentType = treatmentType;
	}
	public int getToothNumber() {
		return toothNumber;
	}
	public void setToothNumber(int toothNumber) {
		this.toothNumber = toothNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	

	
	
}
