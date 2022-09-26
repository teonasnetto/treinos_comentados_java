package utils;

import java.util.function.Predicate;

import entities.ProductComparator;

public class ProductPredicate implements Predicate<ProductComparator> {

    @Override
    public boolean test(ProductComparator p) {
        return p.getPrice() >= 10.0;
    }
}
