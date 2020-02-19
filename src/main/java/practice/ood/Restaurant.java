package practice.ood;

import java.util.Date;
import java.util.List;

public class Restaurant {

    private String name;
    private List<Branch> branches;

    public boolean addBranch(Branch branch) {
        return true;
    }

    public enum ReservationStatus {
        REQUESTED, PENDING, CONFIRMED, CHECKED_IN, CANCELLED, ABANDONED
    }

    public enum SeatType {
        REGULAR, KID, ACCESSIBLE, OTHER
    }

    public enum OrderStatus {
        RECEIVED, PREPARING, COMPLETED, CANCELLED, NONE
    }

    public enum TableStatus {
        FREE, RESERVED, OCCUPIED, OTHER
    }

    public enum AccountStatus {
        ACTIVE, CLOSED, CANCELED, BLACKLISTED, BLOCKED
    }

    public enum PaymentStatus {
        UNPAID, PENDING, COMPLETED, FILLED, DECLINED, CANCELLED, ABANDONED, SETTLING, SETTLED, REFUNDED
    }

    public class Address {
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }

    public class Account {
        private String id;
        private String password;
        private Address address;
        private AccountStatus status;

        public boolean resetPassword() {
            return true;
        }
    }

    public abstract class Person {
        private String name;
        private String email;
        private String phone;
    }

    public class Customer extends Person {

    }

    public abstract class Employee extends Person {
        private int employeeId;
        private Account account;
    }

    public class Receptionist extends Employee {
        public boolean createReservation() {
            return true;
        }

        public List<Customer> searchCustomer(String name) {
            return null;
        }
    }

    public class Manager extends Employee {
        public boolean addEmployee() {
            return true;
        }
    }

    public class Chef extends Employee {
        public boolean takeOrder() {
            return true;
        }
    }

    public class Kitchen {
        private String name;
        private Chef[] chefs;

        private boolean assignChef() {
            return true;
        }
    }

    public class Branch {
        private String name;
        private Address address;
        private Kitchen kitchen;
    }

    public class TableChart {
        private int tableChartId;
    }

    public class Table {
        private int id, maxCapacity, locationId;
        private TableStatus status;
        private List<TableSeat> seats;

        public boolean isFree() {
            return true;
        }

        public boolean addReservation() {
            return true;
        }
    }

    public class TableSeat {
        private int num;
        private SeatType type;

        public boolean updateType(SeatType type) {
            return true;
        }
    }

    public class Reservation {
        private int id, peopleCount;
        private Date timeOfReservation;
        private ReservationStatus status;
        private String notes;
        private Date checkinTime;
        private Customer customer;
        private Table[] tables;
    }

    public class MenuItem {
        private int id;
        private String title, description;
        private double price;

        public boolean updatePrice(double price) {
            return true;
        }
    }

    public class MenuSection {
        private int id;
        private String title, description;
        private List<MenuItem> menuItems;

        public boolean addItem(MenuItem menuItem) {
            return true;
        }
    }

    public class Menu {
        private int id;
        private String title, description;
        private List<MenuSection> menuSections;

        public boolean addMenuSection(MenuSection section) {
            return true;
        }
    }

    public class MealItem {
        private int id, quantity;
        private MenuItem item;

        public boolean updateQuantity(int quantity) {
            return true;
        }
    }

    public class Meal {
        private int id;
        private TableSeat seat;
        private List<MenuItem> menuItems;

        public boolean addItem(MenuItem item) {
            return true;
        }
    }

    public class Order {
        private int id;
        private OrderStatus status;
        private Date creationTime;
        private Meal[] meals;
        private Table table;
        private Chef chef;

        public boolean addMeal(Meal meal) {
            return true;
        }

        public boolean removeMeal(Meal meal) {
            return true;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public boolean setStatus(OrderStatus status) {
            return true;
        }
    }

}
