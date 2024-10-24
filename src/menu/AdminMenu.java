package menu;

import java.util.Enumeration;
import java.util.Scanner;

import model.IRoom;
import model.Room;
import model.RoomType;
import api.AdminResource;
import serivce.CustomerService;
import serivce.ReservationService;

public class AdminMenu {

    public static void doMenu(Scanner scanner) {
        boolean stillStanding = true;
        while (stillStanding) {
        try {
            System.out.println("1. See all customers\n2. See all rooms\n3. See all reservations\n4. Add a room\n5. Back to Main Menu");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1": AdminResource.getResource().displayAllCustomers();
                    break;
                case "2": AdminResource.getResource().displayAllRooms();
                    break;
                case "3": AdminResource.getResource().displayAllReservations();
                    break;
                case "4": 
                String passRoom = "";
                Double passPrice = 0.00;
                RoomType occupants = RoomType.SINGLE;
                Scanner in = new Scanner(System.in);
                System.out.println("Enter room number");
                passRoom = in.next();
                System.out.println("Enter price per night");
                passPrice = in.nextDouble();
                System.out.println("Enter 1 for single or 2 for double room");
                int roomType = in.nextInt();
                if (roomType == 1) {
                    occupants = RoomType.SINGLE;
                } else if (roomType == 2) {
                    occupants = RoomType.DOUBLE;
                } else {System.out.println("Invalid entry."); }
                IRoom passroom = new Room(passRoom, passPrice, occupants);
                ReservationService.getInstance().addRoom(passroom);
                System.out.println(ReservationService.getInstance().getARoom(passRoom));
                /*
                 * select option 4
                 * enter room number
                 * enter price per night
                 * enter single or double bed
                 * add another room y/n
                 */
                    break;
                case "5": stillStanding = false;
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            ex.getLocalizedMessage();
        } finally { }
    }
}
}