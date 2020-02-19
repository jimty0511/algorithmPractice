package practice.ood;

import java.util.Date;
import java.util.List;

public class Library {
    public enum BookFormat {
        HARDCOVER,
        PAPERBACK,
        AUDIO_BOOK,
        EBOOK,
        NEWSPAPER,
        MAGAZINE,
        JOURNAL
    }

    public enum BookStatus {
        AVAILABLE,
        RESERVED,
        LOANED,
        LOST
    }

    public enum ReservationStatus {
        WAITING,
        PENDING,
        CANCELED,
        NONE
    }

    public enum AccountStatus {
        ACTIVE,
        CLOSED,
        CANCELED,
        BLACKLISTED,
        NONE
    }

    public class Address {
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }

    public class Person {
        private String name;
        private Address address;
        private String email;
        private String phone;
    }

    public class Constants {
        public static final int MAX_BOOKS_ISSUED_TO_A_USER = 5;
        public static final int MAX_LENDING_DAYS = 10;
    }

    public abstract class Account {
        private String id, password;
        private AccountStatus status;
        private Person person;
    }

    public class Librarian extends Account {
        public boolean addBookItem(BookItem bookItem) {
            return false;
        }

        public boolean blockMember(Member member) {
            return false;
        }

        public boolean unBlockMember(Member member) {
            return false;
        }
    }

    public class Member extends Account {
        private Date dateOfMembership;
        private int totalBooksCheckedOut;

        public boolean reserveBookItem(BookItem bookItem) {
            return false;
        }

        public boolean checkoutBookItem(BookItem item) {
            return false;
        }

        public void returnBookItem(BookItem bookItem) {
        }

        public boolean renewBookItem(BookItem bookItem) {
            return false;
        }
    }

    public abstract class Book {
        private String ISBN, title, subject, publisher, language;
        private int pages;
        private List<Person> authors;
    }

    public class BookItem extends Book {
        private String barcode;
        private Date borrowed, dueDate, dateOfPurchase, publictionDate;
        private double price;
        private Rack placeAt;

        public boolean checkout(String memberId) {
            return false;
        }
    }

    public class Rack {
        private int number;
        private String location;
    }

    public interface Search {
        List<Book> searchByTitle(String title);

        List<Book> searchByAuthor(String author);

        List<Book> searchByPubdate(Date pubDate);
    }

    public class Catalog implements Search {

        @Override
        public List<Book> searchByTitle(String title) {
            return null;
        }

        @Override
        public List<Book> searchByAuthor(String author) {
            return null;
        }

        @Override
        public List<Book> searchByPubdate(Date pubDate) {
            return null;
        }
    }
}
