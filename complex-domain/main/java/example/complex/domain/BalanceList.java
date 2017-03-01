package example.complex.domain;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class BalanceList extends BalanceListAbstract
{
    public BalanceList()
    {
        super();
    }

    public BalanceList(int initialSize)
    {
        super(initialSize);
    }

    public BalanceList(Collection c)
    {
        super(c);
    }

    public BalanceList(Operation operation)
    {
        super(operation);
    }
}
