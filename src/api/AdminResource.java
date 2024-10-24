package api;

import model.Customer;
import model.IRoom;
import serivce.CustomerService;
import serivce.ReservationService;
import java.util.LinkedList;

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
        for (IRoom r : rooms) {
            ReservationService.getInstance().addRoom(r);
        }
    }

    public void displayAllRooms(){
        ReservationService.getInstance().getAllRooms();
    }

    public void displayAllCustomers(){
        System.out.println(CustomerService.getInstance().getAllCustomers());
    }

    public void displayAllReservations(){
        ReservationService.getInstance().printAllReservation();
    }

}
