package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Quota;
import model.services.PayPalTaxService;
import model.services.QuotaService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int numberContract = input.nextInt(); 
		System.out.print("Date (dd/MM/yyyy): ");
		input.nextLine();
		Date date = sdf.parse(input.nextLine());
		System.out.print("Contract value: ");
		double contractValue = input.nextDouble();
		System.out.print("Enter number of installments: ");
		int quotas = input.nextInt();
		
		Contract contract = new Contract(numberContract, date, contractValue);
		QuotaService qs = new QuotaService(quotas, new PayPalTaxService());
		qs.processQuota(contract);
		
		System.out.println("Installments:");
		for(Quota q : contract.getQuotas()) {
			System.out.println(sdf.format(q.getDue()) + " - " + String.format("%.2f", q.getValue()));
		}
	
		input.close();
	}

}
