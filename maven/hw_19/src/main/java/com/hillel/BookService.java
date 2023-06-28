package com.hillel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BookService {
    private final List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAllExpensiveBooks() {
        return books.stream()
                .filter(book -> book.getType().equals("Book") && book.getPrice().compareTo(BigDecimal.valueOf(250)) > 0)
                .collect(Collectors.toList());
    }

    public List<Book> getDiscountedBooks() {
        return books.stream()
                .filter(book -> book.getType().equals("Book") && book.hasDiscount())
                .peek(book -> book.setPrice(book.getPrice().multiply(BigDecimal.valueOf(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP)))
                .collect(Collectors.toList());
    }

    public Book findCheapestBook() {
        return books.stream()
                .filter(book -> book.getType().equals("Book"))
                .min(Comparator.comparing(Book::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
    }

    public List<Book> getLatestAddedBooks(int count) {
        return books.stream()
                .sorted(Comparator.comparing(Book::getCreateDate).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    public BigDecimal calculateTotalCostOfBooksInCurrentYear() {
        LocalDate currentYearStart = LocalDate.now().withDayOfYear(1);
        return books.stream()
                .filter(book -> book.getType().equals("Book"))
                .filter(book -> book.getCreateDate().isAfter(currentYearStart))
                .map(Book::getPrice)
                .filter(price -> price.compareTo(BigDecimal.valueOf(75)) > 0)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Map<String, List<Book>> groupBooksByType() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getType));
    }
}
