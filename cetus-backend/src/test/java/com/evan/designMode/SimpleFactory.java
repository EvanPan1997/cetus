package com.evan.designMode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@SpringBootTest
public class SimpleFactory {
    @Resource
    Creator creator;

    @Test
    public void test() {
        Product product = creator.factoryMethod();
        System.out.println(product.toString());
        product.printInfo();
    }
}

interface Creator {
    Product factoryMethod();
}

@Service
class ConcreteCreator implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

interface Product {
    void printInfo();
}

class ConcreteProduct implements Product {
    @Override
    public void printInfo() {
        System.out.println("This is a product");
    }
}