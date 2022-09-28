package model.entities;

import java.util.Date;

public class CarRental {

    private Date startDate;
    private Date endDate;
    private Vehicle vehicle;
    private Invoice invoice;

   public CarRental(Date startDate, Date endDate, Vehicle vehicle) {
       this.startDate = startDate;
       this.endDate = endDate;
       this.vehicle = vehicle;
   }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
   }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
