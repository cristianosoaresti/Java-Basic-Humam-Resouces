package humanResources.entities;

import java.util.Date;

public class HourContract {
	
	private Date date;
	private Double valuePerHour = 0.0d;
	private Integer hour = 0;
	
	public HourContract() {
	}
	
	public HourContract(Date date, Double valuePerHour, Integer hour) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hour = hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}
	
	public Double totalValue() {
		return valuePerHour * hour; 
	}

}