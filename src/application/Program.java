package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

       Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String carModel = scanner.nextLine();
        System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
        Date pickupDate = sdf.parse(scanner.nextLine());
        System.out.print("Return (dd/MM/yyyy hh:ss): ");
        Date returnDate = sdf.parse(scanner.nextLine());
        System.out.print("Enter price per hour: ");
        double pricePerHour = scanner.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = scanner.nextDouble();

        CarRental vehicleRental = new CarRental(pickupDate, returnDate,new Vehicle(carModel) );
        RentalService rentalService =
                new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(vehicleRental);

        System.out.println();
        System.out.println("INVOICE:");
        System.out.printf("BasicPayment: %.2f", vehicleRental.getInvoice().getBasicPayment());
        System.out.printf("\nTax: %.2f", vehicleRental.getInvoice().getTax());
        System.out.printf("\nTotal payment: %.2f", vehicleRental.getInvoice().getTotalPayment());
    }
}
