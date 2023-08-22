package com.evan.designMode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@SpringBootTest
public class AbstractFactoryTest {
    @Resource
    AbstractFactory abstractFactory;

    @Test
    public void test() {
        ProductA productA = abstractFactory.createProductA();
        ProductB productB = abstractFactory.createProductB();
        System.out.println(productA);
        System.out.println(productB);
    }

}

interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

@Service
class ConcreteFactory implements AbstractFactory {
    public ProductA createProductA() {
        return new ProductA1();
    }

    public ProductB createProductB() {
        return new ProductB1();
    }
}

interface ProductA {}
interface ProductB {}

class ProductA1 implements ProductA {}
class ProductB1 implements ProductB {}
