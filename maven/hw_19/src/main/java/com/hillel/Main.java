// package com.hillel;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

// public class Main {
//     public static void main(String[] args) {
//         List<Book> books = new ArrayList<>();
//         books.add(new Book("Book", BigDecimal.valueOf(300), false,
//                 LocalDate.of(2022, 1, 1)));
//         books.add(new Book("Book", BigDecimal.valueOf(200), true,
//                 LocalDate.of(2022, 2, 1)));
//         books.add(new Book("Toy", BigDecimal.valueOf(100), true,
//                 LocalDate.of(2022, 3, 1)));
//         books.add(new Book("Book", BigDecimal.valueOf(400), true,
//                 LocalDate.of(2023, 4, 1)));

//         BookService bookService = new BookService(books);

//         List<Book> expensiveBooks = bookService.getAllExpensiveBooks();
//         System.out.println("Expensive Books:");
//         expensiveBooks.forEach(book -> System.out.println(book.getPrice()));

//         List<Book> discountedBooks = bookService.getDiscountedBooks();
//         System.out.println("Discounted Books:");
//         discountedBooks.forEach(book -> System.out.println(book.getPrice()));

//         Book cheapestBook = bookService.findCheapestBook();
//         System.out.println("Cheapest Book: " + cheapestBook.getPrice());

//         List<Book> latestBooks = bookService.getLatestAddedBooks(3);
//         System.out.println("Latest Books:");
//         latestBooks.forEach(book -> System.out.println(book.getCreateDate()));

//         BigDecimal totalCost = bookService.calculateTotalCostOfBooksInCurrentYear();
//         System.out.println("Total Cost of Books in Current Year: " + totalCost);

//         Map<String, List<Book>> groupedBooks = bookService.groupBooksByType();
//         System.out.println("Grouped Books:");
//         groupedBooks.forEach((type, bookList) -> {
//             System.out.println(type + ":");
//             bookList.forEach(book -> System.out.println(book.getPrice()));
//         });
//     }
// }
