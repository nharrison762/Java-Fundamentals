package menu;

import java.util.Scanner;

import api.AdminResource;
import serivce.CustomerService;
import serivce.ReservationService;

public class MainMenu {
//while loop to keep this running
    public static void main(String[] args) {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);

    while (keepRunning) {
        try {
            System.out.println("1. Find and reserve a room\n2. See my reservations\n3. Create an account\n4. Admin\n5. Exit");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1": System.out.println("userInput");
                /*
                 * select option one
                 * enter check in date mm/dd/yyyy
                 * enter check out date
                 * displays the rooms matching query, would you like to book a room y/n
                 * do you have an account y/n
                 * y > enter email format
                 * what room number would you like
                 * prints reservation
                 */
                    break;
                case "2": ReservationService.getInstance().printAllReservation();
                    break;
                case "3": 
                String passEmail = "";
                String passFirstName = "";
                String passLastName = "";
                Scanner in = new Scanner(System.in);
                System.out.println("Enter email format (such as defacto@example.com)");
                passEmail = in.next();
                System.out.println("Enter your first name");
                passFirstName = in.next();
                System.out.println("Enter your last name");
                passLastName = in.next();
                CustomerService.getInstance().addCustomer(passFirstName, passLastName, passEmail);
                /*
                 * select option
                 * enter email format
                 * enter first name
                 * enter last name
                 */
                    break;
                case "4": AdminMenu.doMenu(scanner);
                    break;
                case "5": keepRunning = false;
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            ex.getLocalizedMessage();
        } finally {
            scanner.close();
        }
    }
    }
}
