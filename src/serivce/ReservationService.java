package serivce;

import java.lang.IllegalArgumentException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Date;
import java.util.Collection;
import model.*;

public class ReservationService {

    private final static ReservationService rService = new ReservationService();

    private ReservationService() {
 
    }
 // singleton black space magic to allow access to a class that creates itself
    public static ReservationService getInstance(){
        return rService;
    }
    
//store room number, each reservation is the date reserved
    Map<IRoom, LinkedList<Reservation>> reservationInventory = new HashMap<IRoom, LinkedList<Reservation>>(); 

    public void addRoom(IRoom room) {
        //add room object to collection of rooms
        reservationInventory.put(room, new LinkedList<Reservation>());
    }

    public IRoom getARoom(String roomId) {
        for (IRoom i : reservationInventory.keySet()) {
            if (roomId == i.getRoomNumber()) {
                return i;
            }
        }
        System.out.println("There are no available rooms with that number."); //in case the number is not found
        return null;
    }

    //find rooms available for specific dates
    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) { 
        LinkedList<IRoom> retRooms = new LinkedList<IRoom>();
        for (IRoom i :reservationInventory.keySet()) {
            retRooms.add(i);
        }
        return retRooms;
    }
    

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        /*
        search reservations for room number
        when found, search that entry for dates
         * check if room is empty for given dates
         */
        //using https://stackoverflow.com/questions/325933/determine-whether-two-date-ranges-overlap
        for (Reservation i : reservationInventory.get(room)) {
            if (checkInDate.before(i.getCheckOutDate()) && checkOutDate.after(i.getCheckInDate())) {
                throw new IllegalArgumentException("This date is currently taken.");
            }
        }
        Reservation ret = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationInventory.get(room).add(ret);
        return ret;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        LinkedList<Reservation> ret = new LinkedList<Reservation>();
        //find reservation in collection using customer name
        for (LinkedList<Reservation> i : reservationInventory.values()) {
            for (Reservation r : i) { //for each reservation in reservationInventory
                if (r.getCustomer() == customer) {
                    ret.add(r); //add reservations with specified customer
                }
            }
        }
        return ret;
    }

    public void getAllRooms(){
        /*LinkedList<IRoom> retRooms = new LinkedList<IRoom>();
            for (Map<IRoom> r : reservationInventory.values()) {
                 retRooms.add(r);
            }
            return retRooms;
        }; This is what I wanted to do BUT java will not cooperate with me >:[ */ 
        System.out.println(reservationInventory.values());
    }

    public void printAllReservation() {
        for (LinkedList<Reservation> i : reservationInventory.values()) {
            for (Reservation r : i) { //for each reservation in reservationInventory
                System.out.println(r); //print it real good
            }
        }
    }

}
