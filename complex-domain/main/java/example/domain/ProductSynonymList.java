package example.domain;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class ProductSynonymList extends ProductSynonymListAbstract
{
    public ProductSynonymList()
    {
        super();
    }

    public ProductSynonymList(int initialSize)
    {
        super(initialSize);
    }

    public ProductSynonymList(Collection c)
    {
        super(c);
    }

    public ProductSynonymList(Operation operation)
    {
        super(operation);
    }
}
