package services;

import java.util.List;
import java.util.function.Predicate;

import entities.ProductComparator;

public class ProductService {
    
    //função que recebe uma lista e filtra, porém dessa forma a função não é reutilizavel e nem fechada para alteração, ou seja, teria que alterar o código para mudar o filtro
    // public double filteredSum(List<ProductComparator> list) {
    //     double sum = 0.0;
    //     for (ProductComparator p : list) {
    //         if (p.getName().charAt(0) == 'T') {
    //             sum += p.getPrice();
    //         }
    //     }
    //     return sum;
    // }

    public double filteredSum(List<ProductComparator> list, Predicate<ProductComparator> criteria) {
        double sum = 0.0;
        for (ProductComparator p : list) {
            if (criteria.test(p)) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

}
