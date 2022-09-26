package entities;

//implementação da interface comparable para ordenar a lista
public class WorkingMan implements Comparable<WorkingMan> {
    
    private String name;
    private Double salary;
    
    public WorkingMan(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(WorkingMan other) {
        //retornando a comparação entre os dados dos objetos
        return name.compareTo(other.getName()); // <- ordenando por nome

        // return salary.compareTo(other.getSalary()); //< - ordenando por salario
        // return -salary.compareTo(other.getSalary()); // <- ordenando por salario e mostrando em ordem decrescente
    }

    
}
