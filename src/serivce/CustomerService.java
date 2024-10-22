package serivce;

import java.util.LinkedList;

import model.Customer;

public class CustomerService {

    private LinkedList<Customer> customers = new LinkedList<>();

    private final static CustomerService serviceInstance = new CustomerService();
    //create private constructor
    private CustomerService() {

    }

    public static CustomerService getInstance(){
        return serviceInstance;
    }

    public void addCustomer(String firstName, String lastName, String email) {
        Customer noob = new Customer(firstName, lastName, email);
        customers.add(noob);
    }

    public Customer getCustomer(String customerEmail) {
        for (Customer i : customers) {
            if (i.getEmail() == customerEmail) {
                return i;
            }
        }
        return null;
    }
}
