package model.entities;

import java.util.Date;

public class Installment {
	private Date due;
	private Double value;
	
	public Installment() {}

	public Installment(Date due, Double value) {
		this.due = due;
		this.value = value;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
