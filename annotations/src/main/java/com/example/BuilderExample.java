package com.example;

class ProductTwo {
    private String partOne;
    private String partTwo;

    public void setPartOne(String partOne) {
        this.partOne = partOne;
    }

    public void setPartTwo(String partTwo) {
        this.partTwo = partTwo;
    }

    @Override
    public String toString() {
        return "ProductTwo{" +
                "partOne='" + partOne + '\'' +
                ", partTwo='" + partTwo + '\'' +
                '}';
    }
}

interface Builder {
    Builder buildPartOne(String partOne);
    Builder buildPartTwo(String partTwo);
    ProductTwo build();
}

class ConcreteBuilder implements Builder {
    private final ProductTwo product = new ProductTwo();
    private static volatile Builder builder;
    @Override
    public Builder buildPartOne(String partOne) {
        product.setPartOne(partOne);
        return builder;
    }

    @Override
    public Builder buildPartTwo(String partTwo) {
        product.setPartTwo(partTwo);
        return builder;
    }

    public static Builder builder() {
        if(builder == null) {
            builder = new ConcreteBuilder();
        }
        return builder;
    }

    @Override
    public ProductTwo build() {
        return product;
    }
}



public class BuilderExample {
    public static void main(String[] args) {
        ProductTwo result = ConcreteBuilder.builder()
                .buildPartOne("part one")
                .buildPartTwo("part two")
                .build();

        System.out.println(result);
    }
}
