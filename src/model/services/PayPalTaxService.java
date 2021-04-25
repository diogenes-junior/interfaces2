package model.services;

public class PayPalTaxService implements TaxService{
	public double tax(double amount, int quota) {
		return (amount + amount * 0.01 * quota) * 1.02;
	}
}
