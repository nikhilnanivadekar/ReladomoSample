package example.complex.domain;

import java.sql.Timestamp;

public class Balance extends BalanceAbstract
{

    public static final int QUANTITY_TYPE = 100;

    public Balance(Timestamp businessDate, Timestamp processingDate)
    {
        super(businessDate, processingDate);
        // You must not modify this constructor. Mithra calls this internally.
        // You can call this constructor. You can also add new constructors.
    }

    public Balance(Timestamp businessDate)
    {
        super(businessDate);
    }
}
