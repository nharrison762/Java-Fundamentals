package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import serivce.CustomerService;
import serivce.ReservationService;

import java.util.Date;
import java.util.Collection;

public class HotelResource {
    
    public Customer getCustomer(String email) {
        return CustomerService.getInstance().getCustomer(email);
    }

    public void createACustomer(String firstName, String lastName, String email) {
        CustomerService.getInstance().addCustomer(firstName, lastName, email);
    }

    public IRoom getRoom(String roomNumber) {
        return ReservationService.getInstance().getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate) {
        return ReservationService.getInstance().reserveARoom(getCustomer(customerEmail), room, checkInDate, CheckOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer customer = CustomerService.getInstance().getCustomer(customerEmail);
        return ReservationService.getInstance().getCustomersReservation(customer);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return ReservationService.getInstance().findARoom(checkIn, checkOut);
    }
}