package example.simple.domain;

import java.sql.Timestamp;

public class Pet extends PetAbstract
{
    public Pet(Timestamp processingDate
    )
    {
        super(processingDate
        );
        // You must not modify this constructor. Mithra calls this internally.
        // You can call this constructor. You can also add new constructors.
    }

    public Pet()
    {
        this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
    }
}
