package entity;

public class OrderLine {
    private Product product;
    private int subToTal;
    private int quantity;
    private int totalPrice;

    public OrderLine(Product product, int subToTal, int quantity,int totalPrice) {
        this.product = product;
        this.subToTal = subToTal;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSubToTal() {
        return subToTal;
    }

    public void setSubToTal(int subToTal) {
        this.subToTal = subToTal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return product+ "," +subToTal+ "," +quantity;
    }
}
