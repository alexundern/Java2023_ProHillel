import java.time.LocalDate;

public class Book {

    private String type;
    private double price;
    private boolean discountApplicable;
    private LocalDate addedDate;

    public Book(String type, double price, boolean discountApplicable, LocalDate addedDate) {
        this.type = type;
        this.price = price;
        this.discountApplicable = discountApplicable;
        this.addedDate = addedDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountApplicable() {
        return discountApplicable;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void applyDiscount(double discountPercentage) {
        if (discountApplicable) {
            price = price - (price * discountPercentage / 100);
        }
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

}
