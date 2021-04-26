package model.services;

public class PayPalService implements OnlinePaymentService{

	public static final double PAYMENT_FEE = 0.02;
	public static final double MONTHLY_INTEREST = 0.01;
	
	@Override
	public double interest(double amount, int months) {
		return amount * MONTHLY_INTEREST * months;
	}
	
	@Override
	public double paymentFee(double amount) {
		return amount * PAYMENT_FEE;
	}
}
