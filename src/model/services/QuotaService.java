package model.services;

import java.util.Calendar;

import model.entities.Contract;
import model.entities.Quota;

public class QuotaService {
	private Integer quantityQuotas;
	
	private TaxService taxService;
	
	public QuotaService() {}

	public QuotaService(Integer quantityQuotas, TaxService taxService) {
		this.quantityQuotas = quantityQuotas;
		this.taxService = taxService;
	}

	public Integer getQuantityQuotas() {
		return quantityQuotas;
	}

	public void setQuantityQuotas(Integer quantityQuotas) {
		this.quantityQuotas = quantityQuotas;
	}
	
	public void processQuota(Contract contract) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getDate());
		double quotaValue = contract.getContractValue() / quantityQuotas;
		
		for(int i=1; i<=quantityQuotas; i++) {
			cal.add(Calendar.DAY_OF_MONTH, 30);
			contract.addQuotas(new Quota(cal.getTime(), taxService.tax(quotaValue, i)));			
		}
	}
}
