public abstract class Product {
    private int id;
    private String name;
    private Brand brand;
    private int price;
    private int stock;
    private double discountRate;
    private int ram;
    private double screenSize;
    private int memory;

    public Product(int id, String name, Brand brand, int price, int stock, double discountRate, int ram, double screenSize, int memory) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.discountRate = discountRate;
        this.ram = ram;
        this.screenSize = screenSize;
        this.memory = memory;
    }
    public Product(){

    }

    public abstract void menu();

    public abstract void addItem();

    public abstract void getProducts();

    public abstract void deleteItem();
    public abstract void markafiltrele();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getMarka() {
        return brand;
    }

    public void setMarka(Brand brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}