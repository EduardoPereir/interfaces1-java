package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;

    private TaxServices taxService;

    public RentalService(Double pricePerHour, Double pricePerDay,TaxServices service) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = service;
    }

    public void processInvoice(CarRental carRental){
        long t1 = carRental.getStartDate().getTime();
        long t2 = carRental.getEndDate().getTime();
        double hours = (double)(t2 - t1) / 1000 / 60 / 60;

        double basicPayment;

        if(hours <= 12.0){
             basicPayment = Math.ceil(hours) * pricePerHour;
        }
        else{
            basicPayment = Math.ceil(hours / 24) * pricePerDay;
        }

        double tax =  taxService.tax(basicPayment);

        carRental.setInvoice( new Invoice(basicPayment, tax));
    }
}
