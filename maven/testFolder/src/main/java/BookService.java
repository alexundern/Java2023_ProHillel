import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BookService{
    private final List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAllBooksOfTypeWithPriceGreaterThan(String type, double priceThreshold) {
        return books.stream()
                .filter(book -> book.getType().equals(type) && book.getPrice() > priceThreshold)
                .collect(Collectors.toList());
    }

    public List<Book> getAllDiscountedBooksOfType(String type, double discountPercentage) {
        return books.stream()
                .filter(book -> book.getType().equals(type) && book.isDiscountApplicable())
                .peek(book -> book.applyDiscount(discountPercentage))
                .collect(Collectors.toList());
    }

    public Book getCheapestBookOfType(String type) {
        return books.stream()
                .filter(book -> book.getType().equals(type))
                .min(Comparator.comparingDouble(Book::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: " + type + "] не знайдено"));
    }

    public List<Book> getLastThreeAddedProducts() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getAddedDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public double calculateTotalCostOfBooksAddedThisYear() {
        int currentYear = LocalDate.now().getYear();

        return books.stream()
                .filter(book -> book.getType().equals("Book"))
                .filter(book -> book.getAddedDate().getYear() == currentYear)
                .filter(book -> book.getPrice() <= 75.0)
                .mapToDouble(Book::getPrice)
                .sum();
    }


    public Map<String, List<Book>> groupProductsByType() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getType));
    }

}
