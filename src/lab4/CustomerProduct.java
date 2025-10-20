package lab4;

import java.time.LocalDate;

/**
 *
 * @author husse
 */
public class CustomerProduct implements Record {

    private final String customerSSN;
    private final String productID;
    private boolean paid = false;
    private final LocalDate purchaseDate;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {

        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;

    }

    public String getCustomerSSN() {
        return this.customerSSN;

    }

    public String getProductID() {

        return this.productID;

    }

    public LocalDate getPurchaseDate() {

        return this.purchaseDate;

    }

    @Override
    public String lineRepresentation() {

        int day = this.purchaseDate.getDayOfMonth();
        int month = this.purchaseDate.getMonthValue();
        int year = this.purchaseDate.getYear();

        String date = String.format("%02d-%02d", day, month);

        return this.customerSSN + "," + this.productID + "," + date + "-" + year + "," + this.paid;

    }

    public boolean isPaid() {
        return this.paid;

    }

    public void setPaid(boolean paid) {
        this.paid = paid;

    }

    @Override
    public String getSearchKey() {
        int day = this.purchaseDate.getDayOfMonth();
        int month = this.purchaseDate.getMonthValue();
        int year = this.purchaseDate.getYear();

        String date = String.format("%02d-%02d", day, month);
        return this.customerSSN + "," + this.productID + "," + date + "-" + year;
    }

}
