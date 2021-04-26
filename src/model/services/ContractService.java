package model.services;

import java.util.Calendar;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getDate());
		double basicQuota = contract.getContractValue() / month;
		
		for(int i=1; i<=month; i++) {
			double updateQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			double fullQuota = updateQuota + onlinePaymentService.paymentFee(updateQuota);
			cal.add(Calendar.MONTH, 1);
			contract.getQuotas().add(new Installment(cal.getTime(), fullQuota));
		}
	}
}
