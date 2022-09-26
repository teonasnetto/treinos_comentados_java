package entities;

public class ProductComparator {
    private String name;
    private Double price;

    public ProductComparator(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    //criando um método nao estatico para retornar uma expressão lambda Predicate
    public boolean nonStaticProductPredicate() {
        return getPrice() >= 100.0;
    }

    //criando um método estatico para retornar uma expressão lambda Predicate
    public static boolean staticProductPredicate(ProductComparator p) {
        return p.getPrice() >= 100.0;
    }

    //criando um método estatico para retornar uma expressão lambda Consumer
    public static void staticProductConsumer(ProductComparator p) {
        p.setPrice(p.getPrice() * 1.1);
    }

    //criando um método nao estatico para retornar uma expressão lambda Consumer
    public void nonStaticProductConsumer() {
        setPrice(getPrice() * 1.1);
    }

    //criando um método estatico para retornar uma expressão lambda Function
    public static String staticProductFunction(ProductComparator p) {
        return p.getName().toUpperCase();
    }

    //criando um método nao estatico para retornar uma expressão lambda Function
    public String nonStaticProductFunction() {
        return getName().toUpperCase();
    }

    @Override
    public String toString() {
        return "name=" + name + ", price=" + price;
    }
    
}
