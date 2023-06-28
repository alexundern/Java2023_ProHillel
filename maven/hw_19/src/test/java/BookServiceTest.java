import com.hillel.Book;
import com.hillel.BookService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookServiceTest {

    private BookService bookService;
    private List<Book> books;

    @BeforeEach
    void setUp() {
        books = new ArrayList<>();
        books.add(new Book("Book", BigDecimal.valueOf(300), false, LocalDate.of(2022, 1, 1)));
        books.add(new Book("Book", BigDecimal.valueOf(200), true, LocalDate.of(2022, 2, 1)));
        books.add(new Book("Toy", BigDecimal.valueOf(100), true, LocalDate.of(2022, 3, 1)));
        books.add(new Book("Book", BigDecimal.valueOf(400), true, LocalDate.of(2023, 4, 1)));

        bookService = new BookService(books);
    }

    @DisplayName("All Expensive Books")
    @Test
    void testGetAllExpensiveBooks() {
        List<Book> expensiveBooks = bookService.getAllExpensiveBooks();

        Assertions.assertEquals(2, expensiveBooks.size());
        Assertions.assertEquals(BigDecimal.valueOf(300), expensiveBooks.get(0).getPrice());
        Assertions.assertEquals(BigDecimal.valueOf(400), expensiveBooks.get(1).getPrice());
    }

    @DisplayName("Get Discounted Books")
    @Test
    void testGetDiscountedBooks() {
        List<Book> discountedBooks = bookService.getDiscountedBooks();

        Assertions.assertEquals(2, discountedBooks.size());
        Assertions.assertEquals(BigDecimal.valueOf(180).setScale(2,
                BigDecimal.ROUND_HALF_UP), discountedBooks.get(0).getPrice());
        Assertions.assertEquals(BigDecimal.valueOf(360).setScale(2,
                BigDecimal.ROUND_HALF_UP), discountedBooks.get(1).getPrice());
    }

    @DisplayName("Find Cheapest Book")
    @Test
    void testFindCheapestBook() {
        Book cheapestBook = bookService.findCheapestBook();

        Assertions.assertEquals(BigDecimal.valueOf(200), cheapestBook.getPrice());
    }

    @DisplayName("Find Cheapest Book With No Book Found")
    @Test
    void testFindCheapestBookWithNoBookFound() {
        books.removeIf(book -> book.getType().equals("Book"));

        Assertions.assertThrows(NoSuchElementException.class, () -> bookService.findCheapestBook());
    }

    @DisplayName("Get Latest Added Books")
    @Test
    void testGetLatestAddedBooks() {
        List<Book> latestBooks = bookService.getLatestAddedBooks(2);

        Assertions.assertEquals(2, latestBooks.size());
        Assertions.assertEquals(LocalDate.of(2023, 4, 1), latestBooks.get(0).getCreateDate());
        Assertions.assertEquals(LocalDate.of(2022, 3, 1), latestBooks.get(1).getCreateDate());
    }

    @DisplayName("Calculate Total Cost Of Books In Current Year")
    @Test
    void testCalculateTotalCostOfBooksInCurrentYear() {
        BigDecimal totalCost = bookService.calculateTotalCostOfBooksInCurrentYear();

        Assertions.assertEquals(BigDecimal.valueOf(400).setScale(2, BigDecimal.ROUND_HALF_UP), totalCost);
    }

    @DisplayName("Group Books By Type")
    @Test
    void testGroupBooksByType() {
        List<Book> bookGroup = bookService.groupBooksByType().get("Book");

        Assertions.assertEquals(3, bookGroup.size());
        Assertions.assertEquals("Book", bookGroup.get(0).getType());
        Assertions.assertEquals("Book", bookGroup.get(1).getType());
        Assertions.assertEquals("Book", bookGroup.get(2).getType());

        List<Book> toyGroup = bookService.groupBooksByType().get("Toy");

        Assertions.assertEquals(1, toyGroup.size());
        Assertions.assertEquals("Toy", toyGroup.get(0).getType());
    }
}
