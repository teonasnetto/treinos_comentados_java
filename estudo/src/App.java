
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import devices.ComboDevice;
import devices.ConcretePrinter;
import devices.ConcreteScanner;
import entities.AbstractShape;
import entities.Account;
import entities.BussinesAccount;
import entities.CarRental;
import entities.Circle;
import entities.CircleCuringa;
import entities.ClientHashCode;
import entities.Comment;
import entities.Department;
import entities.Employee;
import entities.HourContract;
import entities.LogEntry;
import entities.Order;
import entities.OutsourcedEmployee;
import entities.Post;
import entities.Product;
import entities.ProductComparator;
import entities.ProductGenerics;
import entities.ProductSet;
import entities.Rectangle;
import entities.RectangleCuringa;
import entities.SavingsAccount;
import entities.ShapeCuringa;
import entities.Triangle;
import entities.Vehicle;
import entities.Worker;
import entities.WorkingMan;
import entities.enums.Color;
import entities.enums.OrderStatus;
import entities.enums.WorkerLevel;
import services.BrazilInterestService;
import services.BrazilTaxService;
import services.CalculationService;
import services.InterestService;
import services.PrintService;
import services.ProductService;
import services.RentalService;
import utils.Calculator;

public class App {

    public static void formatacaoTexto() {
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

    public static void numeroImparPar() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double valor;

        System.out.print("Digite algum número: ");

        valor = sc.nextDouble();

        double resultado = valor % 2;

        if (resultado > 0.0) {
            System.out.println("Número digitado " + valor + " É ímpar e tem resto de " + resultado);
        } else {
            System.out.println("Número digitado " + valor + " É par e tem resto de " + resultado);
        }

        sc.close();
    }

    public static void usoFor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite quantos pares de número quer dividir: ");
        int n = sc.nextInt();
        int v = n;
        for (int i = 0; i < n; i++) {
            System.out.println("Serão divididos " + v + " pares de números");
            System.out.println("Digite o dividendo e logo em seguida o divisor: ");
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (y == 0) {
                System.out.println("Divisão impossível");
            } else {
                double div = (double) x / y;
                System.out.printf("%.2f%n", div);
            }
            v--;
        }

        sc.close();
    }

    public static void usoBibliotecaMath() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double x, z;

        System.out.println("Escreve a porra de um raio e dê enter");

        x = sc.nextDouble();

        z = 3.14159 * Math.pow(x, 2);

        System.out.printf("O raio deu %.4f%n", z);

        sc.close();
    }

    public static void operadoreBitBit() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        /*
         * Esse comando mostra como checar um arquivo de bit a bit com os operadores
         * & - E
         * | - OU
         * ^ - XOR
         */
        int mask = 0b00100000;
        int n = sc.nextInt();

        if ((n & mask) != 0) {
            System.out.println("Sexto bit do valor é TRUE");
        } else {
            System.out.println("Sexto bit do numero informado é FALSE");
        }

        sc.close();
    }

    public static void formatacaoString() {
        String texto = "   abcde FGHIJ kLmNoP       ";

        String txt01 = texto.toLowerCase();
        String txt02 = texto.toUpperCase();
        String txt03 = texto.trim();
        String txt04 = texto.substring(2, 9);
        String txt05 = texto.replace(' ', 'X');
        int txt06 = texto.indexOf("J");
        int txt07 = texto.lastIndexOf(" ");
        // formato de vetor
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

    public static void usoClasse() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int higher = max(x, y, z);

        System.out.println(higher);

        sc.close();
    }

    public static int max(int a, int b, int c) {
        int aux;

        if (a > b && a > c) {
            aux = a;
        } else if (b > a && b > c) {
            aux = b;
        } else {
            aux = c;
        }

        return aux;
    }

    public static void instanciacaoObjetoTriangulo() {
        Scanner sc = new Scanner(System.in);

        Triangle x, y;

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

    public static void instanciacaoObjetoCirculo() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o raio: ");

        double radius = sc.nextDouble();

        double c = Calculator.circunference(radius);

        double v = Calculator.circunference(radius);

        System.out.println("C: " + c + " V: " + v + " PI: " + Calculator.PI);

        sc.close();

    }

    public static void instanciacaoObjetoProduct() {
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

    public static void vetores() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] vect = new double[n];
        for (int i = 0; i < n; i++) {
            vect[i] = sc.nextDouble();
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += vect[i];
        }
        double avg = sum / n;
        System.out.printf("Valor é %f.01%n", avg);
        sc.close();
    }

    public static void vetoresProduct() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Product[] vect = new Product[n];

        for (int i = 0; i < n; i++) {
            // gambiarra pq deu um nextInt antes, para poder dar um next string precisa
            // fazer isso se não ele pega o valor do ENTER
            sc.nextLine();
            String name = sc.nextLine();
            Double price = sc.nextDouble();
            vect[i] = new Product(name, price);
        }

        Double sum = 0.0;
        // da de usar o próprio tamanho do vetor
        for (int i = 0; i < vect.length; i++) {
            sum += vect[i].getPrice();
        }

        Double avg = sum / n;

        System.out.println(avg);

        sc.close();
    }

    public static void boxinggUnboxingWrapperClasses() {
        int x = 20;

        // boxing
        Object obj = x;
        System.out.println(obj);

        // unboxing
        int y = (int) obj;
        System.out.println(y);

        // wrapper classes
        Integer i = x;
        int z = i * 2;
        System.out.println(z);

        // usando wrapper class
        // public String name;
        // public double price;
        // public Integer quantity;

    }

    public static void foreEach() {
        // instanciar vetor com dados
        String[] vect = new String[] { "João", "Maria", "José", "Pedro" };
        // percorrer vetor com for de forma diferente
        for (String x : vect) {
            System.out.println(x);
        }

    }

    public static void listas() {
        // instanciar lista do tipo String
        List<String> list = new ArrayList<>();

        // adicionar elementos na lista
        list.add("Maria");
        list.add("José");
        list.add("Pedro");
        list.add("João");

        // adicionar elementos em uma posição especifica na lista
        list.add(2, "Paulo");

        // criar uma nova lista para filtrar somente os nomes que começam com P
        List<String> list2 = list.stream().filter(x -> x.startsWith("P")).collect(Collectors.toList());

        // remover elementos da lista
        list.remove("Maria");
        list.remove(1);
        // filtrar com função lambda para remover todos que iniciam com P
        list.removeIf(filter -> filter.startsWith("P"));

        // mostrar tamanho da lista
        System.out.println(list.size());

        // mostrar o index do elemento
        System.out.println(list.indexOf("José"));

        // mostrar elementos da lista
        for (String x : list) {
            System.out.println(x);
        }

        // mostrar elementos da lista 2 separado por virgula
        for (String x : list2) {
            System.out.print(x + ", ");
        }
        System.out.println();

        // filtra o primeiro nome da lista que começa com P, caso não exista, retornar
        // nulo
        String first = list2.stream().filter(x -> x.startsWith("P")).findFirst().orElse(null);
        System.out.println(first);

    }

    public static void matriz() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        // cria uma matriz de n linhas e n colunas
        int[][] matriz = new int[n][n];
        // percorre a matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter a value for [ " + i + " ] [ " + j + " ]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
        // mostra a matriz diagonal
        for (int i = 0; i < n; i++) {
            System.out.println(matriz[i][i] + " ");
        }

        // mostra a quantidade de numeros negativos da matriz
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] < 0) {
                    count++;
                }
            }
        }
        System.out.println("The number of negative numbers is: " + count);

        // mostra a quantidade de linhas da array
        System.out.println("The number of rows is: " + matriz.length);
        // mostra a quantidade de colunas da array
        System.out.println("The number of columns is: " + matriz[0].length);

        sc.close();
    }

    public static void dataHora() {

        // formatadores para datas
        DateTimeFormatter frmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter frmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH");
        DateTimeFormatter frmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter frmt4 = DateTimeFormatter.ISO_INSTANT;

        // instanciar data
        LocalDate d01 = LocalDate.now();
        LocalTime d02 = LocalTime.now();
        LocalDateTime d03 = LocalDateTime.now();
        Instant d04 = Instant.now();
        Instant d05 = Instant.parse("2018-06-25T15:42:07Z");
        LocalDateTime d06 = LocalDateTime.parse("25/10/2009 15:42:07", frmt1);
        LocalDateTime d07 = LocalDateTime.parse("2018-10-15T15:42:07");
        LocalDate.of(2022, 01, 30);

        // imprime aas dastas
        System.out.println(d01);
        System.out.println(d02);
        System.out.println(d03);
        System.out.println(d04);
        // por padrao o print mostra o toString() do objeto
        System.out.println(d04.toString());
        System.out.println(d05);
        System.out.println(d06);
        // imprime as datas com os formatos
        System.out.println(d07.format(frmt2));
        System.out.println(frmt2.format(d07));
        System.out.println(frmt3.format(d05));
        System.out.println(frmt4.format(d05));

        // convertendo data global para local
        LocalDateTime d08 = LocalDateTime.ofInstant(d05, ZoneId.systemDefault());
        LocalDateTime d09 = LocalDateTime.ofInstant(d05, ZoneId.of("Portugal"));
        System.out.println(d08);
        System.out.println(d09);

        // imprimir só partes de uma data
        System.out.println(d01.getDayOfMonth());

        // Adicionar horas e dias em data
        LocalDateTime d10 = d03.plusHours(4);
        System.out.println(d10);

        // adicionar dias em Instant
        Instant d11 = d05.plus(7, ChronoUnit.DAYS);
        System.out.println(d11);

        // Duração entre duas datas
        Duration d12 = Duration.between(d05, d11);
        System.out.println(d12.toDays());

        // duracao entre dates
        Duration d13 = Duration.between(d01.atStartOfDay(), d01.atTime(23, 0));
        System.out.println(d13.toHours());

    }

    public static void dataHoraLegacy() throws ParseException {
        // estilos de datas usados antes do JAVA 8
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

    public static void calendar() {
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

    public static void enumerador() {

        // instanciar enumerador
        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order);

        // como converter string para valuer do enumerador
        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);

    }

    public static void contarTrabalhador() throws ParseException {
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

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
                new Department(departmentName));

        System.out.println("How many contracts to this worker?");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
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
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%2f", worker.income(year, month)));

        sc.close();
    }

    public static void postComentarios() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow, nota joia!");

        Post p1 = new Post(sdf.parse("21/06/2018 10:20:20"), "Traveling to new Zealand", "Tudo nota joia pra viajar!",
                1);

        p1.addComment(c1);
        p1.addComment(c2);

        System.out.println(p1);

    }

    public static void accountHeranca() {

        // Account não pode ser instanciada, pois é abstrada para somente existir contas
        // bussines e savings
        // Account acc = new Account(1001, "Halex", 0.0); //<-Gera erro se deixar

        BussinesAccount bacc = new BussinesAccount(1002, "Joseph", 0.0, 500.0);

        // UPCASTING, atribuir uma bussines account para uma versão Account
        // ou seja, atribuir uma subclasse ser atribuido para uma superclasse
        Account acc1 = bacc;
        Account acc2 = new BussinesAccount(1003, "Rafa", 100.0, 1000.0);
        Account acc3 = new SavingsAccount(1004, "Marcos", 5000.0, 0.01);

        // DOWNCASTING
        // não é aceitavel converter naturalmente uma superclasse para uma subclasee
        // BussinesAccount acc4 = acc2; //<- Gera erro
        BussinesAccount acc4 = (BussinesAccount) acc2;
        acc4.loan(400.0);

        // uma herança não consegue ser convertido para outro tipo de subclasse, o
        // compilador nao reconhece
        // BussinesAccount acc5 = (BussinesAccount)acc3; //<- Gera erro ao rodar

        // checar se é uma instancia do tipo certo
        if (acc3 instanceof BussinesAccount) {
            BussinesAccount acc5 = (BussinesAccount) acc3;
            acc5.loan(500);
            System.out.println(acc5.getBalance());
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("OK!");
        }

        System.out.println(acc1.toString());

    }

    public static void polimorfismo() {

        List<Employee> list = new ArrayList<>();

        int n = 2;

        for (int i = 1; i <= n; i++) {
            System.out.println("Era pra ter os inputs dos funcionarios aqui " + i);
            if (i == 1) {
                list.add(new OutsourcedEmployee("Jose", 10, 20.0, 200.0));
            } else {
                list.add(new Employee("Maria", 12, 25.0));
            }
        }

        for (Employee emp : list) {
            System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
        }

    }

    public static void execerpts() {
        System.out.println("Start excerpts");
        excertptTest1();
        System.out.println("End excerpts");
    }

    public static void excertptTest1() {

        System.out.println("Start excerptsTest1");

        excertptTest2();

        System.out.println("End program 1");
    }

    public static void excertptTest2() {
        System.out.println("Start excerptsTest2");

        Scanner sc = new Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Fora de posição");
            // printa a pilha de erros e quais metodos e classes que chamou o outro
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Texto escrito errado");
        }

        System.out.println("End program 2");

        sc.close();
    }

    public static void excerptFinnaly() {

        File file = new File("C:\\temp\\in.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } finally {
            // uso do finally para mesmo se não achar o arquivo, ele fechar o leitor
            if (sc != null) {
                sc.close();
            }
        }
    }

    public static void manipulandoArqTexto() {

        /* Lendo arquivos de texto */

        // File file = new
        // File("D:\\THEO\\programing\\codigos\\JAVA\\JAVA_geral\\in.txt");
        // Scanner sc = null;

        // // Dentro de um bloco try pois pode sair alguma exception
        // try {
        // sc = new Scanner(file);
        // while (sc.hasNextLine()) {
        // System.out.println(sc.nextLine());
        // }
        // } catch (IOException e) {
        // System.out.println(e.getMessage());
        // } finally {
        // if (sc != null) {
        // sc.close();
        // }
        // }

        // // Outra forma de abrir e fechar os arquivos "muito verboso"
        // String path = "D:\\THEO\\programing\\codigos\\JAVA\\JAVA_geral\\in.txt";
        // FileReader fr = null;
        // BufferedReader br = null;

        // try {
        // //Instanciar um arquivo estabelecendo uma Stream, sequencia de leitura a
        // partir do arquivo
        // fr = new FileReader(path);
        // //Instanciado a partir de FileReader para deixar mais rapido a leitura do
        // arquivo
        // br = new BufferedReader(fr);
        // // br = new BufferedReader(new FileReader(path)); //<-- pode ser feita assim
        // tambem
        // String line = br.readLine();
        // while (line != null) {
        // System.out.println(line);
        // line = br.readLine();
        // }
        // } catch (IOException e) {
        // System.out.println(e.getMessage());
        // } finally {
        // try{
        // if (br != null) {
        // br.close();
        // }
        // if (fr != null) {
        // fr.close();
        // }
        // } catch (IOException e) {
        // //mostrar a pilha caso haja erros
        // e.printStackTrace();
        // }
        // }

        // Forma pratica de abrir e fechar Streams sem ser manualmente

        String path = "D:\\THEO\\programing\\codigos\\JAVA\\JAVA_geral\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /* Escrevendo arquivos de texto */

        String[] lines = new String[] { "Good morning", "Good afternoon", "Good night" };

        String path_out = "D:\\THEO\\programing\\codigos\\JAVA\\JAVA_geral\\out.txt";

        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(path_out))) { //
        // <-- Aqui sempre vai recriar o arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path_out, true))) { // Com o true dará append no
                                                                                       // arquivo
            for (String line : lines) {
                bw.write(line); // Aqui vai adicionar no final do arquivo
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void manipulandoPastas() {
        String strPath = "D:\\THEO\\programing\\codigos\\JAVA\\JAVA_geral";

        File path = new File(strPath);

        // abrindo uma pasta e listando os diretórios
        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS: ");
        for (File folder : folders) {
            System.out.println(folder);
        }

        // abrindo uma pasta e listando os arquivos
        File[] files = path.listFiles(File::isFile);
        for (File file : files) {
            System.out.println(file);
        }

        // instanciando um boleano para retornar se foi um sucesso a criação da pasta
        // criando a pasta
        boolean success = new File(strPath, "\\teste").mkdir();
        System.out.println("Directory created? " + success);

        // Mostrando caminho dos arquivos
        String strPath2 = "D:\\THEO\\programing\\codigos\\JAVA\\JAVA_geral\\in.txt";

        File path2 = new File(strPath2);

        // Somente o nome
        System.out.println(path2.getName());
        // Somente o caminho sem o nome
        System.out.println(path2.getParent());
        // Caminho e nomes completos
        System.out.println(path2.getPath());

    }

    public static void usandoInterface() throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String carModel = "Civic";
        Date start = sdf.parse("25/06/2018 10:30");
        Date finish = sdf.parse("25/06/2018 14:40");

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        double pricePerHour = 10.00;
        double pricePerDay = 130.00;

        // cahamar o BrazilTaxService é uma injeção de dependencia por meio de
        // construtor (ele é instanciada e injetado por meio do construtor)
        // Gera um dependencia fraca (Acomplamento fraco, pois se eu colocar para a
        // classe instanciar o BrazilTaxService,
        // ela fica dependente da classe BrazilTaxService e fica um forte acomplamento)
        // Criando uma inversão de controle, removendo da classe RentalService a
        // responsabilidade de instanciação das suas dependencias
        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("INVOICE:");
        System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

    }

    public static void usandoInterfaceClasseAbstrata() {
        // Usando a interface com a classe abstrata color, usando a interfaçe Shape
        // temos a obrigatoriedade de implementar o metodo area()
        AbstractShape s1 = new Circle(Color.BLACK, 2.0);
        AbstractShape s2 = new Rectangle(Color.WHITE, 3.0, 4.0);

        System.out.println("Circle color: " + s1.getColor());
        System.out.println("Circle area: " + String.format("%.3f", s1.area()));
        System.out.println("Rectangle color: " + s2.getColor());
        System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));

    }

    public static void problemaDoDiamante() {

        // Resolvendo o problema da herança multipla que não é permitirdo antes do java
        // 8
        // Usando interface para resolver o problema do diamante através da criação de
        // uma classe abstrata e interfaces para instaciar varios devices

        ConcretePrinter p = new ConcretePrinter("1080");
        p.processDoc("My Letter");
        p.print("My Letter");

        System.out.println();
        ConcreteScanner s = new ConcreteScanner("2003");
        s.processDoc("My Email");
        System.out.println("Scan result: " + s.scan());

        System.out.println();
        ComboDevice c = new ComboDevice("2081");
        c.processDoc("My dissertation");
        c.print("My dissertation");
        System.out.println("Scan result: " + c.scan());
    }

    public static void interfaceComparable() {
        // implementação da interface comparable para ordenar a lista
        // após a implementação da interface, é necessário implementar o metodo
        // compareTo
        // para que a lista seja ordenada
        // transformando em um tipo de lista comparável

        List<WorkingMan> list = new ArrayList<>();
        String path = "D:\\THEO\\programing\\codigos\\Z_estudos_testes\\JAVA_geral\\in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String workinkManCSV = br.readLine();
            while (workinkManCSV != null) {
                String[] fields = workinkManCSV.split(",");
                list.add(new WorkingMan(fields[0], Double.parseDouble(fields[1])));
                workinkManCSV = br.readLine();
            }
            Collections.sort(list);
            for (WorkingMan s : list) {
                System.out.println(s.getName() + ", " + s.getSalary());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void defaulMethods() {
        // desde o java 8, é possivel implementar metodos na interface
        // herdando valores e tendo herança multipla já que o métodos está na interface
        // para evitar repetição de código utilizamos o defaul na interface para chamada
        // do pagamento
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService is = new BrazilInterestService(2.0);
        double payment = is.payment(amount, months);

        System.out.println("Payment after " + months + " months:");
        System.out.println(String.format("%.2f", payment));

        sc.close();
    }

    public static void usginGenerics() {

        // usando generics para criar uma lista de objetos

        Scanner sc = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService<>();

        System.out.print("How many values? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Integer value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        Integer x = ps.first();
        System.out.println("First: " + x);

        sc.close();
    }

    public static void usginGenericsComparable() {
        // usando generics para criar uma lista de objetos
        // usando a interface comparable para ordenar a lista
        // após a implementação da interface, é necessário implementar o metodo
        // compareTo
        // para que a lista seja ordenada
        // transformando em um tipo de lista comparável
        Locale.setDefault(Locale.US);

        List<ProductGenerics> list = new ArrayList<>();

        String path = "D:\\THEO\\programing\\codigos\\Z_estudos_testes\\JAVA_geral\\data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new ProductGenerics(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            ProductGenerics x = CalculationService.max(list);
            System.out.println("Most expensive:");
            System.out.println(x);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void usginCuringas1() {
        List<Integer> myInts = Arrays.asList(5, 2, 10);
        printCuringas(myInts);

        List<String> myStrs = Arrays.asList("alo", "bom", "dia");
        printCuringas(myStrs);
    }

    public static void printCuringas(List<?> list) {
        // criando uma coleção de dados do tipo curinga
        // o tipo curinga é um tipo que aceita qualquer tipo de dado
        // o curinga é representado pelo simbolo "?"
        // porém o tipo curinga não aceita adicionar dados na lista

        for (Object obj : list) {
            System.out.println(obj);
        }

    }

    public static void usginCuringas2() {
        List<ShapeCuringa> myShapes = new ArrayList<>();
        myShapes.add(new RectangleCuringa(3.0, 2.0));
        myShapes.add(new CircleCuringa(2.0));

        List<CircleCuringa> myCircles = new ArrayList<>();
        myCircles.add(new CircleCuringa(2.0));
        myCircles.add(new CircleCuringa(3.0));

        System.out.println("Total area: " + totalAreaCuringa(myCircles));
    }

    public static double totalAreaCuringa(List<? extends ShapeCuringa> list) {
        // Passando que a lista é do tipo curinga e que o tipo curinga é do tipo
        // ShapeCuringa
        // Assim pode ser passado qualquer tipo de lista que herde de ShapeCuringa
        // Então a lista pode ser do tipo CircleCuringa ou RectangleCuringa
        double sum = 0.0;
        for (ShapeCuringa s : list) {
            sum += s.area();
        }
        return sum;
    }

    public static void usginCuringas3() {
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<String> myStrings = Arrays.asList("sim", "não");
        List<Object> myObjs = new ArrayList<Object>();
        // usando o curinga para adicionar dados na lista
        copyCuringasObjects(myInts, myObjs);
        // usando uma lista curinga para ler qualquer tipo de lista e dados da lista
        printCuringas(myObjs);
        copyCuringasObjects(myDoubles, myObjs);
        printCuringas(myObjs);
        copyCuringasObjects(myStrings, myObjs);
        printCuringas(myObjs);

    }

    public static void copyCuringasNumber(List<? extends Object> source, List<? super Object> destiny) {
        for (Object number : source) {
            destiny.add(number);
        }
    }

    public static void copyCuringasObjects(List<? extends Object> source, List<? super Object> destiny) {
        // usando a covariancia para ler os dados da lista
        // usando a contra variância para passar uma lista de qualquer tipo de dado
        // para a lista de destino
        // assim posso adiciona qualquer tipo de dado na lista de destino
        for (Object number : source) {
            destiny.add(number);
        }
    }

    public static void usingHashCodeAndEquals() {
        // usando o metodo hashCode e equals para comparar objetos
        String a = "Maria";
        String b = "Alex";

        // hash code mais rapido devido a mostrar o numero de memoria do objeto
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        // equals mais lento devido a comparar os dados do objeto
        System.out.println(a.equals(a));

        // criando um hashCode personalizado
        ClientHashCode client1 = new ClientHashCode("Maria", "maria@email.com");
        ClientHashCode client2 = new ClientHashCode("Maria", "maria@email.com");

        System.out.println(client1.hashCode());
        System.out.println(client2.hashCode());

        // Se eu usar o equals ele mostra true devido a comparação dos dados do objeto
        System.out.println(client1.equals(client2));

        // Se eu usar == ele mostra false devido ao heap de memoria da instanciação
        // serem diferentes
        System.out.println(client1 == client2);

        // Qual a experessão literal o compilador trata e retorna corretamente no uso do
        // ==
        String s1 = "Maria";
        String s2 = "Maria";
        System.out.println(s1 == s2);

        // porem se eu instanciar ele deixa de usar o == e passa a usar o equals
        String s3 = new String("Maria");
        String s4 = new String("Maria");
        System.out.println(s3 == s4);
    }

    public static void usingSet() {

        // HashSet - mais rápido (operações O(1) em tabela hash) e não ordenado
        // TreeSet - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado
        // pelo compareTo do objeto (ou Comparator)
        // LinkedHashSet - velocidade intermediária e elementos na ordem em que são
        // adicionado

        // EXEMPLO com HashSet
        Set<String> set = new HashSet<>();
        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");
        System.out.println(set.contains("Notebook"));
        set.remove("Notebook");
        for (String p : set) {
            System.out.println(p);
        }
        System.out.println(set.size());
        set.add("Notebook");
        set.removeIf(filter -> filter.charAt(0) == 'T');
        for (String p : set) {
            System.out.println(p);
        }

        // EXEMPLO de operadores com TreeSet
        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
        // union
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);
        // intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);
        // difference
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);
    }

    public static void usingSetIgualdadeAndComparable() {
        Set<ProductSet> set = new HashSet<>();
        set.add(new ProductSet("TV", 5));
        set.add(new ProductSet("Notebook", 8));
        set.add(new ProductSet("Tablet", 20));
        ProductSet prod = new ProductSet("Notebook", 8);
        // Se eu comparar sem existir o equals e o hashCode ele vai comparar a
        // referencia de memoria
        // e vai retornar false
        System.out.println(set.contains(prod));

        // Criando um toString para facilitar visualização dos dados
        Set<ProductSet> setTree = new TreeSet<>();
        // Vai gerar erro (Caso não tenha o comparable) pois não implementamos o
        // comparable
        // O treeSet usa o comparable para ordenar os dados na hora da visualização
        // Após implementado ele roda normal
        setTree.add(new ProductSet("TV", 5));
        setTree.add(new ProductSet("Notebook", 8));
        setTree.add(new ProductSet("Tablet", 20));
        for (ProductSet p : set) {
            System.out.println(p);
        }

    }

    public static void countinUniquesSet() {
        Scanner sc = new Scanner(System.in);

        String path = "D:\\THEO\\programing\\codigos\\Z_estudos_testes\\JAVA_geral\\logData.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(" ");
                String username = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));

                set.add(new LogEntry(username, moment));

                line = br.readLine();
            }
            System.out.println("Total users: " + set.size());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }

    public static void usingMap() {
        Map<String, String> cookies = new TreeMap<>();
        cookies.put("username", "maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "99771122");
        cookies.remove("email");
        //Sobrescreve o valor anterior pois o Map não aceita repetição de chave
        cookies.put("phone", "99771133");
        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone number: " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email"));
        System.out.println("Size: " + cookies.size());
        System.out.println("ALL COOKIES:");
        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }
    }

    public static void usingComparator() {
        //Usando uma interface funcional abstrata () para ordenar
        List<ProductComparator> list = new ArrayList<>();
        list.add(new ProductComparator("TV", 5.0));
        list.add(new ProductComparator("Notebook", 8.0));
        list.add(new ProductComparator("Tablet", 20.0));

        //Caso for usar precisa importar o java.util.Comparator e o entities.ProductComparator

        // list.sort(new MyProductComparator()); //<- primeira forma de usar o comparator

        //Usando uma expressão anonima para ordenar com o Comparator do java.util
        //Forma muito verbosa de usar o comparator
        // Comparator<ProductComparator> comp = new Comparator<ProductComparator>() {
        //     @Override
        //     public int compare(ProductComparator p1, ProductComparator p2) {
        //         return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        //     }
        // };

        // //Por ser muito verboso utilizamos função lambda com o Comparator do java.util
        // Comparator<ProductComparator> comp = (p1, p2) -> { return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());};
        //Pode usar de uma forma mais simples sem precisar das chaves e do return
        // Comparator<ProductComparator> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        // list.sort(comp);

        //Para simplificar mais ainda usa uma expressão sem precisar criar uma variavel, a função lambda é passada diretamente
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (ProductComparator p : list) {
            System.out.println(p);
        }
    }

    public static void usingPredicate() {

        List<ProductComparator> list = new ArrayList<>();
        list.add(new ProductComparator("TV", 5.0));
        list.add(new ProductComparator("Notebook", 8.0));
        list.add(new ProductComparator("Tablet", 20.0));

        // list.removeIf(new ProductPredicate()); //<- forma de usar o predicate com implementação da interface

        // list.removeIf(ProductComparator::staticProductPredicate); //<- forma de usar o predicate método estático
        
        // list.removeIf(ProductComparator::nonStaticProductPredicate); //<- forma de usar o predicate método não estático
        
        /*forma de usar o predicate expressão lambda declarada
        double min = 10.0
        // da de usar o min ou passaar o numero direto no min
        Predicate<ProductComparator> pred = p -> p.getPrice() >= min; 
        list.removeIf(pred); 
        */

        list.removeIf(p -> p.getPrice() >= 10.0); //<- forma de usar o predicate inline

        for (ProductComparator p : list) {
            System.out.println(p);
        }

    }

    public static void usingConsumer() {
        List<ProductComparator> list = new ArrayList<>();
        list.add(new ProductComparator("TV", 5.0));
        list.add(new ProductComparator("Notebook", 8.0));
        list.add(new ProductComparator("Tablet", 20.0));

        // list.forEach(new ProductConsumer()); //<- forma de usar o consumer com implementação da interface

        // list.forEach(ProductComparator::nonStaticProductConsumer); //<- forma de usar o consumer método não estático
        
        // list.forEach(ProductComparator::staticProductConsumer); //<- forma de usar o consumer método estático
        
        /*forma de usar o consumer expressão lambda declarada
        double factor = 1.1;
        // da de usar o factor ou passaar o numero direto no factor
        Consumer<ProductComparator> cons = p -> p.setPrice(p.getPrice() * factor); 
        list.forEach(cons); 
        */

        list.forEach(p -> p.setPrice(p.getPrice() * 1.1)); //<- forma de usar o consumer inline

        //Forma de iterar sobre a lista
        // for (ProductComparator p : list) {
        //     System.out.println(p);
        // }

        //Forma de iterar usando o forEach usando reference method ao println
        list.forEach(System.out::println);
    }

    public static void usingFunction() {
        List<ProductComparator> list = new ArrayList<>();
        list.add(new ProductComparator("Tv", 5.0));
        list.add(new ProductComparator("Notebook", 8.0));
        list.add(new ProductComparator("Tablet", 20.0));
        
        //convertendo para formato stram para poder usar o map
        //usando a função map para transformar cada elemento da lista na função pedida
        //usando collect para retornar a stream para uma lista
        // List<String> names = list.stream().map(new ProductFunction()).collect(Collectors.toList()); //<- forma de usar o function com implementação da interface
        // names.forEach(System.out::println);

        // List<String> names = list.stream().map(ProductComparator::staticProductFunction).collect(Collectors.toList()); //<- <- forma de usar o function método não estático
        // names.forEach(System.out::println);

        // List<String> names = list.stream().map(ProductComparator::nonStaticProductFunction).collect(Collectors.toList()); //<- <- forma de usar o function método não estático
        // names.forEach(System.out::println);

        /*forma de usar o function expressão lambda declarada
        Function<ProductComparator, String> func = p -> p.getName().toUpperCase(); 
        List<String> names = list.stream().map(func).collect(Collectors.toList()); //<- <- forma de usar o function método não estático
        names.forEach(System.out::println);
        */

        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList()); //<- forma de usar o function inline
        names.forEach(System.out::println);
    }

    public static void creatingFunctionThatUseFunction() {
        List<ProductComparator> list = new ArrayList<>();
        list.add(new ProductComparator("Tv", 5.0));
        list.add(new ProductComparator("Notebook", 8.0));
        list.add(new ProductComparator("Tablet", 20.0));

        //Criando uma função que recebe uma função como parametro

        ProductService ps = new ProductService();

        // double sum = ps.filteredSum(list); <- forma de usar a função comentada no ProductService

        double sum = ps.filteredSum(list, p -> p.getPrice() < 10.0); //<- forma de usar a função inline

        System.out.println("Sum = " + String.format("%.2f", sum));
    }

    public static void usingStream() {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        //Criando uma stream a partir de uma coleção
        // Stream<Integer> st1 = list.stream();
        //Criando uma stream a partir de uma coleção usando map
        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        //Impriminto a stream
        System.out.println(Arrays.toString(st1.toArray()));

        //Criando uma stream diretamente
        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        //Criando uma stream através de uma função de iteração
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 5);
        //Mostrando somente 10 elementos da stream devido a ser infinita
        System.out.println(Arrays.toString(st3.limit(15).toArray()));

        //Criando uma stream através da sequencia de fibonacci
        Stream<Long> st4 = Stream.iterate(new Long[] { 0L, 1L }, p -> new Long[] { p[1], p[0] + p[1] }).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(15).toArray()));
    }

    public static void usingStreamPipelines() {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        //toArray é uma operação terminal
        System.out.println(Arrays.toString(st1.toArray()));

        //Gerando o somatorio dos elementos da lista
        int sum = list.stream().reduce(0, (x, y) -> x + y);

        System.out.println("Sum = " + sum);

        //criando uma stream a partir da lista "list" e filtrando os elementos pares, depois multiplicando por 10 e logo após transformando em uma lista
        List<Integer> newList = list.stream().filter(x -> x % 2 == 0).map(x -> x * 10).collect(Collectors.toList());
        System.out.println(Arrays.toString(newList.toArray()));
    }
    public static void main(String[] args) throws Exception {
        usingStreamPipelines();
    }
}