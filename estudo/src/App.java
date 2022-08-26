
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.Triangle;
import utils.Calculator;

public class App {
    public static void atividade1(){
        String product1 = "Computer";
        String product2 = "Office desk";

        int age = 30;
        int code = 5290;
        char gender = 'F';

        double price1 = 2100.0;
        double price2 = 650.50;
        double measure = 53.234567;

        System.out.println("Products:");
        System.out.printf("%s, which price is $ %.2f%n", product1, price1);
        System.out.printf("%s, which price is $ %.2f%n", product2, price2);

        System.out.println();

        System.out.printf("Record: %d years old, code %d and gender: %s%n", age, code, gender);
        
        System.out.println();

        System.out.printf("Measure with eight decimal places: %.8f%n", measure);
        System.out.printf("Rounded (three decimal places) %.3f%n", measure);
        Locale.setDefault(Locale.US);
        System.out.printf("Us decimal point %.3f", measure);
    }
    public static void atividade2(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double valor;
        
        System.out.print("Digite algum número: ");

        valor = sc.nextDouble();

        double resultado = valor % 2;

        if(resultado > 0.0){
            System.out.println("Número digitado " + valor + " É ímpar e tem resto de " + resultado);
        }
        else{
            System.out.println("Número digitado " + valor + " É par e tem resto de " + resultado);
        }

        sc.close();
    }
    public static void atividade3(){
        Scanner sc      = new Scanner(System.in);
        System.out.print("Digite quantos pares de número quer dividir: ");
        int n = sc.nextInt();
        int v = n;
        for(int i=0; i<n; i++){
            System.out.println("Serão divididos " + v + " pares de números");
            System.out.println("Digite o dividendo e logo em seguida o divisor: ");
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(y==0){
                System.out.println("Divisão impossível");
            }
            else{
                double div = (double) x/y;
                System.out.printf("%.2f%n",div);
            }
            v--;
        }

        sc.close();
    }
    public static void atividade4(){
        String product1 = "Computer";
        String product2 = "Office desk";

        int age = 30;
        int code = 5290;
        char gender = 'F';

        double price1 = 2100.0;
        double price2 = 650.50;
        double measure = 53.234567;

        System.out.println("Products:");
        System.out.printf("%s, which price is $ %.2f%n", product1, price1);
        System.out.printf("%s, which price is $ %.2f%n", product2, price2);

        System.out.println();

        System.out.printf("Record: %d years old, code %d and gender: %s%n", age, code, gender);
        
        System.out.println();

        System.out.printf("Measure with eight decimal places: %.8f%n", measure);
        System.out.printf("Rounded (three decimal places) %.3f%n", measure);
        Locale.setDefault(Locale.US);
        System.out.printf("Us decimal point %.3f", measure);
    }
    public static void atividade5(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double x, y, z;

        System.out.println("Escreve a porra de dois numeros e dê enter");

        x = sc.nextDouble();
        y = sc.nextDouble();
        
        z = x + y;

        System.out.printf("A soma dessa bagaça deu %.2f%n", z);

        sc.close();
    }
    public static void atividade6(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double x, z;

        System.out.println("Escreve a porra de um raio e dê enter");

        x = sc.nextDouble();
        
        z = 3.14159 * Math.pow(x, 2);

        System.out.printf("O raio deu %.4f%n", z);

        sc.close();
    }
    public static void atividade7(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        /*
        Esse comando mostra como checar um arquivo de bit a bit com os operadores
        & - E
        | - OU
        ^ - XOR
        */
        int mask = 0b00100000;
        int n = sc.nextInt();

        if((n & mask) != 0){
            System.out.println("Sexto bit do valor é TRUE");
        }
        else{
            System.out.println("Sexto bit do numero informado é FALSE");
        }

        sc.close();
    }
    public static void atividade8(){
        String texto = "   abcde FGHIJ kLmNoP       ";

        String txt01 = texto.toLowerCase();
        String txt02 = texto.toUpperCase();
        String txt03 = texto.trim();
        String txt04 = texto.substring(2,9);
        String txt05 = texto.replace(' ', 'X');
        int txt06 = texto.indexOf("J");
        int txt07 = texto.lastIndexOf(" ");
        //formato de vetor
        String[] txt08 = texto.trim().split(" ");

        System.out.println(txt01);
        System.out.println(txt02);
        System.out.println(txt03);
        System.out.println(txt04);
        System.out.println(txt05);
        System.out.println(txt06);
        System.out.println(txt07);
        System.out.println(txt08[0]);
    }
    public static void atividade9(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        
        int higher = max(x, y, z);

        System.out.println(higher);

        sc.close();
    }
    public static int max(int a, int b, int c){
        int aux;

        if(a>b && a>c){
            aux = a;
        }
        else if(b>a && b>c){
            aux = b;
        }
        else{
            aux = c;
        }

        return aux;
    }
    public static void atividade10(){
        Scanner sc = new Scanner(System.in);
        
        Triangle x,y;

        x = new Triangle();
        y = new Triangle();

        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double areaX = x.area();
        double areaY = y.area();

        System.out.println(areaX);
        System.out.println(areaY);

        sc.close();
    }
    public static void atividade11(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter Product data");
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Price:");
        Double price = sc.nextDouble();
        System.out.print("Quantity in stock:");
        int quantity = sc.nextInt();
        
        Product product = new Product(name, price, quantity);

        System.out.println(product);

        System.out.printf("%n Entre com quantos produtos quer adicionar: %n");
        quantity = sc.nextInt();
        product.addProducts(quantity);
        System.out.println(product);

        System.out.printf("%n Entre com quantos produtos quer remover: %n");
        quantity = sc.nextInt();
        product.removeProducts(quantity);
        System.out.println(product);

        sc.close();
    }
    public static void atividade12(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o raio: ");

        double radius = sc.nextDouble();

        double c = Calculator.circunference(radius);

        double v = Calculator.circunference(radius);

        System.out.println("C: " + c + " V: " + v + " PI: " + Calculator.PI);

        sc.close();
        
    }
    public static void atividade13(){

    }
    public static void main(String[] args) throws Exception {
        atividade11();
    }
}
