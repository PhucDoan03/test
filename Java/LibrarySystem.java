import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

abstract class LibraryAccount {
    protected String accountID;
    protected String fullName;
    protected String dob;
    protected String phone;
    protected String email;
    protected String address;
    protected String status;

    LibraryAccount(String accountID, String fullName, String dob, String phone, String email, String address, String status) {
        this.accountID = accountID;
        this.fullName = fullName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;

        if (status.equals("active") || status.equals("suspended") || status.equals("closed")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status. Allowed values are: 'active', 'suspended', 'closed'.");
        }
    }

    abstract public void searchCatalog(List<Book> catalog, String keyword);
}

class MemberAccount extends LibraryAccount {
    private final String accountType = "M";

    MemberAccount(String accountID, String fullName, String dob, String phone, String email, String address, String status) {
        super(accountID, fullName, dob, phone, email, address, status);
    }

    @Override
    public void searchCatalog(List<Book> catalog, String keyword) {
        System.out.println("Member is searching for books in the catalog...");
        for (Book book : catalog) {
            if (book.ISBN.contains(keyword) || book.title.contains(keyword) || book.authors.contains(keyword) || book.publisher.contains(keyword)) {
                System.out.println(book.getBookDetails());
            }
        }
    }

    public void borrowBook(BookRequest request) {
        request.borrowBook();
    }
}

class LibrarianAccount extends LibraryAccount {
    private final String accountType = "L";

    LibrarianAccount(String accountID, String fullName, String dob, String phone, String email, String address, String status) {
        super(accountID, fullName, dob, phone, email, address, status);
    }

    @Override
    public void searchCatalog(List<Book> catalog, String keyword) {
        System.out.println("Librarian is searching for books in the catalog...");
        for (Book book : catalog) {
            if (book.ISBN.contains(keyword) || book.title.contains(keyword) || book.authors.contains(keyword) || book.publisher.contains(keyword)) {
                System.out.println(book.getBookDetails());
            }
        }
    }

    public void manageCatalog(List<Book> catalog, Book book, String action) {
        switch (action) {
            case "add":
                catalog.add(book);
                System.out.println("Book added to the catalog.");
                break;
            case "update":
                for (int i = 0; i < catalog.size(); i++) {
                    if (catalog.get(i).ISBN.equals(book.ISBN)) {
                        catalog.set(i, book);
                        System.out.println("Book updated in the catalog.");
                        return;
                    }
                }
                System.out.println("Book not found in the catalog.");
                break;
            case "remove":
                catalog.removeIf(b -> b.ISBN.equals(book.ISBN));
                System.out.println("Book removed from the catalog.");
                break;
            default:
                System.out.println("Invalid action. Please specify 'add', 'update', or 'remove'.");
        }
    }
}

class Book {
    protected String ISBN;
    protected String title;
    protected List<String> authors;
    protected int year;
    protected String publisher;
    protected String status;

    Book(String ISBN, String title, List<String> authors, int year, String publisher, String status) {
        this.ISBN = ISBN;
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.publisher = publisher;

        if (status.equals("loaned") || status.equals("available")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status. Allowed values are: 'loaned', 'available'.");
        }
    }

    public String getBookDetails() {
        return "ISBN: " + ISBN + "\n" +
               "Title: " + title + "\n" +
               "Authors: " + String.join(", ", authors) + "\n" +
               "Year: " + year + "\n" +
               "Publisher: " + publisher + "\n" +
               "Status: " + status;
    }
}

class BookRequest {
    private String BLCode;
    private String memberID;
    private String ISBN;
    private Date dueDate;
    private Date returnDate;
    private Book requestedBook;

    public BookRequest(String BLCode, String memberID, String ISBN, Date dueDate, Date returnDate, Book requestedBook) {
        this.BLCode = BLCode;
        this.memberID = memberID;
        this.ISBN = ISBN;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.requestedBook = requestedBook;
    }

    public void borrowBook() {
        if (requestedBook.status.equals("available")) {
            requestedBook.status = "loaned";
            System.out.println("The book has been successfully loaned.");
        } else {
            System.out.println("The book is not available for loan.");
        }
    }

    public void returnBook() {
        requestedBook.status = "available";
        this.returnDate = new Date();
        System.out.println("The book has been successfully returned.");
    }

    public boolean isAvailable() {
        return requestedBook.status.equals("available");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
        // Tạo danh mục sách
        List<Book> catalog = new ArrayList<>();
        Book book1 = new Book("978-3-16-148410-0", "Java Programming", List.of("Author1", "Author2"), 2020, "Tech Publisher", "available");
        Book book2 = new Book("978-0-12-345678-9", "Data Structures", List.of("Author3", "Author4"), 2018, "Science Publisher", "available");
        
        catalog.add(book1);
        catalog.add(book2);
    
        // Nhập thông tin thành viên
        System.out.print("Enter Member ID: ");
        String memberID = scanner.nextLine();
        System.out.print("Enter Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Date of Birth: ");
        String dob = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        
        MemberAccount member = new MemberAccount(memberID, fullName, dob, phone, email, address, "active");
        
        // Tìm kiếm sách
        System.out.print("Enter the keyword to find book: ");
        String keyword = scanner.nextLine();
        member.searchCatalog(catalog, keyword);
        
        // Nhập yêu cầu mượn sách
        System.out.print("Enter ISBN code of the lended book: ");
        String isbn = scanner.nextLine();
        Book requestedBook = catalog.stream().filter(b -> b.ISBN.equals(isbn)).findFirst().orElse(null);
        if (requestedBook != null) {
            BookRequest request = new BookRequest("BL001", memberID, isbn, new Date(), null, requestedBook);
            member.borrowBook(request);
        } else {
            System.out.println("Failed to find the book with the ISBN.");
        }
        
        // Nhập thông tin thủ thư
        System.out.print("Enter Librarian ID: ");
        String librarianID = scanner.nextLine();
        LibrarianAccount librarian = new LibrarianAccount(librarianID, "Jane Smith", "02/02/1985", "0987654321", "jane@example.com", "456 High St", "active");
        
        // Thủ thư quản lý sách
        System.out.println("Librarian is adding new books...");
        Book newBook = new Book("978-1-23-456789-0", "Algorithms", List.of("Author5"), 2021, "Math Publisher", "available");
        librarian.manageCatalog(catalog, newBook, "add");
        
        scanner.close();
    }
}