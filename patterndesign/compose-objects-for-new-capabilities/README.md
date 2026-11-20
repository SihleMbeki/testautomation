# Compose objects for new capabilities

## Description

Build a class's behavior by giving it focused helper objects and combining
their work. This adds capabilities without copying implementation or making
the class hierarchy deeper. Composition is especially useful when a feature
needs to combine several independent operations.

## Example

```java
interface PriceAdjustment {
    double apply(double price);
}

class TenPercentDiscount implements PriceAdjustment {
    public double apply(double price) {
        return price * 0.90;
    }
}

class AddTax implements PriceAdjustment {
    public double apply(double price) {
        return price * 1.15;
    }
}

class CheckoutTotal {
    private final PriceAdjustment discount;
    private final PriceAdjustment tax;

    CheckoutTotal(PriceAdjustment discount, PriceAdjustment tax) {
        this.discount = discount;
        this.tax = tax;
    }

    double calculate(double price) {
        return tax.apply(discount.apply(price));
    }

    public static void main(String[] args) {
        CheckoutTotal checkout = new CheckoutTotal(
            new TenPercentDiscount(),
            new AddTax()
        );
        System.out.println(checkout.calculate(100)); // 103.5
    }
}
```

`CheckoutTotal` composes a discount and tax operation to provide a complete
calculation. The `main` method creates the concrete adjustments and passes
them into the constructor; this is how `CheckoutTotal` receives the behavior
without declaring or constructing those implementations itself.
