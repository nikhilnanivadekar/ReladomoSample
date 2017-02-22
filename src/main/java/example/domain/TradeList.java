package example.domain;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class TradeList extends TradeListAbstract
{
    public TradeList()
    {
        super();
    }

    public TradeList(int initialSize)
    {
        super(initialSize);
    }

    public TradeList(Collection c)
    {
        super(c);
    }

    public TradeList(Operation operation)
    {
        super(operation);
    }
}
