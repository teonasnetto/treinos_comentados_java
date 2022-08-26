package entities;

public class Product {
    private String name;
    private double price;
    private int quantity;

    //Mantém o construtor padrão
    public Product() {
    }
    //Cria o construtor para a classe Product
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    //Cria o construtor em sobrecarga sem necessidade do parâmetro quantity
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        //Esse this no quantity tambem não é necessário pois não tem ambiguidade de referência
        //o quantity não precisa ser = a 0 pois ele já é instânciado com valor zero no construtor
        this.quantity = 0;
    }

    //Edita os dados encapsulados
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    //Retorna os dados encapsulados
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    //Adiciona, remove produtos ao estoque
    public void addProducts(int quantity){
        this.quantity += quantity;
    }

    public void removeProducts(int quantity){
        this.quantity -= quantity;
    }

    public double totalVluesInStock(){
        return price * quantity;
    }

    //sobrescreve a toString de herança do objeto para retornar o valor que colocar, mesmo sem chamar o product.toString (Caso seja chamado direto no println) 
    public String toString(){
        return name + ", $" + String.format("%.2f", price) + ", " + quantity + " units, Total: $ " + totalVluesInStock();
    }
}
