package example.simple.domain;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class PetTypeList extends PetTypeListAbstract
{
    public PetTypeList()
    {
        super();
    }

    public PetTypeList(int initialSize)
    {
        super(initialSize);
    }

    public PetTypeList(Collection c)
    {
        super(c);
    }

    public PetTypeList(Operation operation)
    {
        super(operation);
    }
}
