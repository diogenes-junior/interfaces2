package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private Integer number;
	private Date date;
	private Double contractValue;
	
	List<Quota> quotas = new ArrayList<>();
	
	public Contract() {}

	public Contract(Integer number, Date date, Double contractValue) {
		this.number = number;
		this.date = date;
		this.contractValue = contractValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getContractValue() {
		return contractValue;
	}

	public void setContractValue(Double contractValue) {
		this.contractValue = contractValue;
	}

	public List<Quota> getQuotas() {
		return quotas;
	}
	
	public void addQuotas(Quota quota) {
		quotas.add(quota);
	}
	
	public void removeQuotas(Quota quota) {
		quotas.remove(quota);
	}
}
