import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BookServiceTest {

    private BookService bookService;
    private List<Book> books;

    @BeforeEach
    public void setup() {
        Book book1 = new Book("Fiction", 10.0, true, LocalDate.now());
        Book book2 = new Book("Fiction", 15.0, false, LocalDate.now());
        Book book3 = new Book("Non-fiction", 20.0, true, LocalDate.now());
        Book book4 = new Book("Non-fiction", 25.0, true, LocalDate.now());

        books = Arrays.asList(book1, book2, book3, book4);
        bookService = new BookService(books);
    }

    @Test
    public void testGetAllBooksOfTypeWithPriceGreaterThan() {
        List<Book> result = bookService.getAllBooksOfTypeWithPriceGreaterThan("Fiction", 10.0);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Fiction", result.get(0).getType());
        Assertions.assertEquals(15.0, result.get(0).getPrice());
    }

    @Test
    public void testGetAllDiscountedBooksOfType() {
        List<Book> result = bookService.getAllDiscountedBooksOfType("Non-fiction", 10.0);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Non-fiction", result.get(0).getType());
        Assertions.assertEquals(18.0, result.get(0).getPrice());
        Assertions.assertEquals("Non-fiction", result.get(1).getType());
        Assertions.assertEquals(22.5, result.get(1).getPrice());
    }

    @Test
    public void testGetCheapestBookOfType() {
        Book result = bookService.getCheapestBookOfType("Fiction");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Fiction", result.getType());
        Assertions.assertEquals(10.0, result.getPrice());
    }

    @Test
    public void testGetLastThreeAddedProducts() {
        List<Book> result = bookService.getLastThreeAddedProducts();
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("Non-fiction", result.get(0).getType());
        Assertions.assertEquals("Non-fiction", result.get(1).getType());
        Assertions.assertEquals("Fiction", result.get(2).getType());
    }

    @Test
    public void testCalculateTotalCostOfBooksAddedThisYear() {
        double result = bookService.calculateTotalCostOfBooksAddedThisYear();
        Assertions.assertEquals(20.0, result);
    }

    @Test
    public void testGroupProductsByType() {
        Map<String, List<Book>> result = bookService.groupProductsByType();
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(2, result.get("Fiction").size());
        Assertions.assertEquals(2, result.get("Non-fiction").size());
    }

}
