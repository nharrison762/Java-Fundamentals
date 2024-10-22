package api;

import model.Customer;
import model.IRoom;
import serivce.CustomerService;
import serivce.ReservationService;

import java.util.LinkedList;
import java.util.Date;
import java.util.Collection;

public class AdminResource {

    private final static AdminResource resourceInstance = new AdminResource();
    private AdminResource(){

    }

    public static AdminResource getResource(){
        return resourceInstance;
    }

    public Customer GetCustomer(String email){
        return CustomerService.getInstance().getCustomer(email);
    }

    public void addRoom(LinkedList<IRoom> rooms){
        ReservationService.getInstance().addRoom(rooms);
    }

    public Collection<IRoom> getAllRooms(){
        return ReservationService.getInstance().getAllRooms();
    }

    public Collection<Customer> getAllCustomers(){

    }

    public void displayAllReservations(){
        ReservationService.getInstance().printAllReservation();
    }

}
