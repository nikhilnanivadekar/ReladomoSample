package example.complex.domain;

import java.sql.Timestamp;

public class Product extends ProductAbstract
{
    public Product(Timestamp businessDate, Timestamp processingDate)
    {
        super(businessDate, processingDate);
        // You must not modify this constructor. Mithra calls this internally.
        // You can call this constructor. You can also add new constructors.
    }

    public Product(Timestamp businessDate)
    {
        super(businessDate);
    }
}
