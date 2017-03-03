package example.complex.domain;

import java.sql.Timestamp;

public class Account extends AccountAbstract
{
    public Account(Timestamp businessDate, Timestamp processingDate)
    {
        super(businessDate, processingDate);
        // You must not modify this constructor. Mithra calls this internally.
        // You can call this constructor. You can also add new constructors.
    }

    public Account(Timestamp businessDate)
    {
        super(businessDate);
    }
}
