package example.domain;

import com.gs.fw.common.mithra.util.DefaultInfinityTimestamp;

import java.sql.Timestamp;

public class Product extends ProductAbstract
{
    public Product(Timestamp processingDate)
    {
        super(processingDate);
        // You must not modify this constructor. Mithra calls this internally.
        // You can call this constructor. You can also add new constructors.
    }

    public Product()
    {
        this(DefaultInfinityTimestamp.getDefaultInfinity());
    }
}
