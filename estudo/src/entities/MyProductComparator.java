package entities;

import java.util.Comparator;

//Criando uma classe que implementa a interface Comparator
//Logo é uma interface funcional

public class MyProductComparator implements Comparator<ProductComparator> {

    @Override
    public int compare(ProductComparator p1, ProductComparator p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }

}
