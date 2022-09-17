
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.stream.Collectors;

import entities.Comment;
import entities.Department;
import entities.HourContract;
import entities.Order;
import entities.Post;
import entities.Product;
import entities.Triangle;
import entities.Worker;
import entities.enums.OrderStatus;
import entities.enums.WorkerLevel;
import utils.Calculator;

public class App {

    public static void formatacaoTexto(){
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
    
    public static void numeroImparPar(){
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
    
    public static void usoFor(){
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

    public static void usoBibliotecaMath(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double x, z;

        System.out.println("Escreve a porra de um raio e dê enter");

        x = sc.nextDouble();
        
        z = 3.14159 * Math.pow(x, 2);

        System.out.printf("O raio deu %.4f%n", z);

        sc.close();
    }
    
    public static void operadoreBitBit(){
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
    
    public static void formatacaoString(){
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
    
    public static void usoClasse(){
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
    
    public static void instanciacaoObjetoTriangulo(){
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
    
    public static void instanciacaoObjetoCirculo(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o raio: ");

        double radius = sc.nextDouble();

        double c = Calculator.circunference(radius);

        double v = Calculator.circunference(radius);

        System.out.println("C: " + c + " V: " + v + " PI: " + Calculator.PI);

        sc.close();
        
    }

    public static void instanciacaoObjetoProduct(){
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
    
    public static void vetores(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] vect = new double[n];
        for(int i=0; i<n; i++){
            vect[i] = sc.nextDouble();
        }
        double sum = 0;
        for(int i=0; i<n; i++){
            sum += vect[i];
        }
        double avg = sum / n;
        System.out.printf("Valor é %f.01%n", avg);
        sc.close();
    }

    public static void vetoresProduct(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Product[] vect = new Product[n];

        for(int i=0; i<n; i++){
            //gambiarra pq deu um nextInt antes, para poder dar um next string precisa fazer isso se não ele pega o valor do ENTER
            sc.nextLine();
            String name = sc.nextLine();
            Double price = sc.nextDouble();
            vect[i] = new Product(name, price); 
        }

        Double sum = 0.0;
        //da de usar o próprio tamanho do vetor
        for(int i=0; i<vect.length; i++){
            sum += vect[i].getPrice();
        }

        Double avg = sum / n;

        System.out.println(avg);

        sc.close();
    }
    
    public static void boxinggUnboxingWrapperClasses(){
        int x = 20;

        //boxing
        Object obj = x;
        System.out.println(obj);

        //unboxing
        int y = (int) obj;
        System.out.println(y);

        //wrapper classes
        Integer i = x;
        int z = i * 2;
        System.out.println(z);

        //usando wrapper class
        //public String name;
        //public double price;
        //public Integer quantity;

    }
    
    public static void foreEach(){
        //instanciar vetor com dados
        String[] vect = new String[] {"João", "Maria", "José", "Pedro"};
        //percorrer vetor com for de forma diferente
        for(String x : vect){
            System.out.println(x);
        }

    }
    
    public static void listas(){
        //instanciar lista do tipo String
        List<String> list = new ArrayList<>();

        //adicionar elementos na lista
        list.add("Maria");
        list.add("José");
        list.add("Pedro");
        list.add("João");

        //adicionar elementos em uma posição especifica na lista
        list.add(2, "Paulo");

        //criar uma nova lista para filtrar somente os nomes que começam com P
        List<String> list2 = list.stream().filter(x -> x.startsWith("P")).collect(Collectors.toList());

        //remover elementos da lista
        list.remove("Maria");
        list.remove(1);
        //filtrar com função lambda para remover todos que iniciam com P
        list.removeIf(filter -> filter.startsWith("P"));

        //mostrar tamanho da lista
        System.out.println(list.size());
        
        //mostrar o index do elemento
        System.out.println(list.indexOf("José"));

        //mostrar elementos da lista
        for(String x : list){
            System.out.println(x);
        }

        //mostrar elementos da lista 2 separado por virgula
        for(String x : list2){
            System.out.print(x + ", ");
        }
        System.out.println();

        //filtra o primeiro nome da lista que começa com P, caso não exista, retornar nulo
        String first = list2.stream().filter(x -> x.startsWith("P")).findFirst().orElse(null);
        System.out.println(first);
        
    }
    
    public static void matriz(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        //cria uma matriz de n linhas e n colunas
        int[][] matriz = new int[n][n];
        //percorre a matriz
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print("Enter a value for [ " + i + " ] [ " + j + " ]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
        //mostra a matriz diagonal
        for(int i=0;i<n;i++){
            System.out.println(matriz[i][i] + " ");
        }

        //mostra a quantidade de numeros negativos da matriz
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matriz[i][j] < 0){
                    count++;
                }
            }
        }
        System.out.println("The number of negative numbers is: " + count);

        //mostra a quantidade de linhas da array
        System.out.println("The number of rows is: " + matriz.length);
        //mostra a quantidade de colunas da array
        System.out.println("The number of columns is: " + matriz[0].length);

        sc.close();
    }
    
    public static void dataHora(){

        //formatadores para datas
        DateTimeFormatter frmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter frmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH");
        DateTimeFormatter frmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter frmt4 = DateTimeFormatter.ISO_INSTANT;

        //instanciar data
        LocalDate       d01 = LocalDate.now();
        LocalTime       d02 = LocalTime.now();
        LocalDateTime   d03 = LocalDateTime.now();
        Instant         d04 = Instant.now();
        Instant         d05 = Instant.parse("2018-06-25T15:42:07Z");
        LocalDateTime   d06 = LocalDateTime.parse("25/10/2009 15:42:07", frmt1);
        LocalDateTime   d07 = LocalDateTime.parse("2018-10-15T15:42:07");
        LocalDate.of(2022, 01, 30);

        //imprime aas dastas
        System.out.println(d01);
        System.out.println(d02);
        System.out.println(d03);
        System.out.println(d04);
        //por padrao o print mostra o toString() do objeto
        System.out.println(d04.toString());
        System.out.println(d05);
        System.out.println(d06);
        //imprime as datas com os formatos
        System.out.println(d07.format(frmt2));
        System.out.println(frmt2.format(d07));
        System.out.println(frmt3.format(d05));
        System.out.println(frmt4.format(d05));

        //convertendo data global para local
        LocalDateTime d08 = LocalDateTime.ofInstant(d05, ZoneId.systemDefault());
        LocalDateTime d09 = LocalDateTime.ofInstant(d05, ZoneId.of("Portugal"));
        System.out.println(d08);
        System.out.println(d09);

        //imprimir só partes de uma data
        System.out.println(d01.getDayOfMonth());

        //Adicionar horas e dias em data
        LocalDateTime d10 = d03.plusHours(4);
        System.out.println(d10);
        
        //adicionar dias em Instant
        Instant d11 = d05.plus(7, ChronoUnit.DAYS);
        System.out.println(d11);
        
        //Duração entre duas datas
        Duration d12 = Duration.between(d05, d11);
        System.out.println(d12.toDays());
        
        //duracao entre dates
        Duration d13 = Duration.between(d01.atStartOfDay(), d01.atTime(23, 0));
        System.out.println(d13.toHours());

    }

    public static void dataHoraLegacy() throws ParseException{
        //estilos de datas usados antes do JAVA 8
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        Date x1 = new Date();
        Date x2 = new Date(System.currentTimeMillis());
        Date x3 = new Date(0L);
        Date x4 = new Date(1000L * 60L * 60L * 5L);

        Date y1 = sdf1.parse("26/06/2018");
        Date y2 = sdf2.parse("26/06/2018 15:42:07");
        Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
        System.out.println(x4);
        System.out.println(y1);
        System.out.println(y2);
        System.out.println(y3);
        System.out.println("-----------------");
        System.out.println(sdf2.format(x1));
        System.out.println(sdf2.format(x2));
        System.out.println(sdf2.format(x3));
        System.out.println(sdf2.format(x4));
        System.out.println(sdf2.format(y1));
        System.out.println(sdf2.format(y2));
        System.out.println(sdf2.format(y3));
        System.out.println("-----------------");
        System.out.println(sdf3.format(x1));
        System.out.println(sdf3.format(x2));
        System.out.println(sdf3.format(x3));
        System.out.println(sdf3.format(x4));
        System.out.println(sdf3.format(y1));
        System.out.println(sdf3.format(y2));
        System.out.println(sdf3.format(y3));
    }
    
    public static void calendar(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
        System.out.println(sdf.format(d));

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.HOUR, 4);
        d = cal.getTime();
        System.out.println(sdf.format(d));

        int minutes = cal.get(Calendar.MINUTE);
        System.out.println("Minutes: " + minutes);
    }
    
    public static void enumerador(){

        //instanciar enumerador
        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order);

        //como converter string para valuer do enumerador
        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);

    }
    
    public static void contarTrabalhador() throws ParseException{
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
        
        System.out.println("How many contracts to this worker?");
        int n = sc.nextInt();

        for (int i =1; i<=n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println("");
        System.out.print("Enter the month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month   = Integer.parseInt(monthAndYear.substring(0, 2));
        int year    = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%2f", worker.income(year, month)));

        sc.close();
    }
    
    public static void postComentarios() throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow, nota joia!");

        Post p1 = new Post(sdf.parse("21/06/2018 10:20:20"),"Traveling to new Zealand", "Tudo nota joia pra viajar!", 1);

        p1.addComment(c1);
        p1.addComment(c2);

        System.out.println(p1);

    }

    public static void atividade(){
        
    }
    
    public static void main(String[] args) throws Exception {
        postComentarios();
    }
}
