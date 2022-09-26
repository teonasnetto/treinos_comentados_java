package utils;

import java.util.function.Consumer;

import entities.ProductComparator;

public class ProductConsumer implements Consumer<ProductComparator> {

    //aumenta o preço em 10%
    @Override
    public void accept(ProductComparator p) {
        p.setPrice(p.getPrice() * 1.1);
    }
}
