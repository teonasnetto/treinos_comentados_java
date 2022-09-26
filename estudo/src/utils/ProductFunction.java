package utils;

import java.util.function.Function;

import entities.ProductComparator;

public class ProductFunction implements Function<ProductComparator, String> {

    @Override
    public String apply(ProductComparator p) {
        return p.getName().toUpperCase();
    }
}
