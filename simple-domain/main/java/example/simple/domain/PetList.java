package example.simple.domain;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class PetList extends PetListAbstract
{
    public PetList()
    {
        super();
    }

    public PetList(int initialSize)
    {
        super(initialSize);
    }

    public PetList(Collection c)
    {
        super(c);
    }

    public PetList(Operation operation)
    {
        super(operation);
    }
}
