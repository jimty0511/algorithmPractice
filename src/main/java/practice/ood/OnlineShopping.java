package practice.ood;

import java.util.Date;
import java.util.List;

public class OnlineShopping {
    public class Address {
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }

    public enum OrderStatus {
        UNSHIPPED, PENDING, SHIPPED, COMPLETED, CANCELED, REFUND_APPLIED
    }

    public enum AccountStatus {
        ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
    }

    public enum ShipmentStatus {
        PENDING, SHIPPED, DELIVERED, ON_HOLD,
    }

    public enum PaymentStatus {
        UNPAID, PENDING, COMPLETED, FILLED, DECLINED, CANCELLED, ABANDONED, SETTLING, SETTLED, REFUNDED
    }

    public class Account {
        private String userName;
        private String password;
        private AccountStatus status;
        private String name;
        private Address shippingAddress;
        private String email;
        private String phone;
    }

    public abstract class Customer {
        private ShoppingCart cart;
        private Order order;

        public boolean addItem(Item item) {
            return false;
        }

        public boolean removeItem(Item item) {
            return false;
        }
    }

    public class Guest extends Customer {
        public boolean registerAccount() {
            return true;
        }
    }

    public class Member extends Customer {
        private Account account;

        public OrderStatus placeOrder(Order order) {
            return null;
        }
    }

    public class ProductCategory {
        private String name, description;
    }

    public class ProductReview {
        private int rating;
        private String review;
        private Member member;
    }

    public class Product {
        private String productId, name, description;
        private double price;
        private ProductCategory category;
        private int availableCount;
        private Account seller;

        public boolean updatePrice(double newPrice) {
            return true;
        }
    }

    public class Item {
        private String productId;
        private int quantity;
        private double price;

        public boolean updateQuantity(int quantity) {
            return false;
        }
    }

    public class ShoppingCart {
        private List<Item> items;

        public boolean addItem(Item item) {
            return false;
        }

        public boolean removeItem(Item item) {
            return false;
        }

        public boolean updateItemQuantity(Item item, int quantity) {
            return false;
        }

        public List<Item> getItems() {
            return null;
        }

        public boolean checkOut() {
            return false;
        }
    }

    public class Order {
        private String orderNumber;
        private OrderStatus orderStatus;
        private Date orderDate;
        private List<OrderLog> logs;

        public boolean sendForShipment() {
            return false;
        }

        public boolean addLog(OrderLog log) {
            return false;
        }
    }

    public class OrderLog {
        private String orderNumber;
        private Date creationDate;
        private OrderStatus status;
    }

    public class ShipmentLog {
        private String shipmentNumber;
        private ShipmentStatus status;
        private Date creationDate;
    }

    public class Shipment {
        private String shipmentNumber;
        private Date shipmentDate;
        private Date estimatedArrival;
        private String shipmentMethod;

        public boolean addShipmentLog(ShipmentLog shipmentLog) {
            return false;
        }
    }

    public interface Search {
        List<Product> searchByName(String name);

        List<Product> searchByCategory(String category);
    }

    public class Catalog implements Search {

        @Override
        public List<Product> searchByName(String name) {
            return null;
        }

        @Override
        public List<Product> searchByCategory(String category) {
            return null;
        }
    }
}
