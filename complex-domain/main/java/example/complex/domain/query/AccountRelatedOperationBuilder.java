package example.complex.domain.query;


import com.gs.fw.common.mithra.finder.NoOperation;
import com.gs.fw.common.mithra.finder.Operation;
import example.complex.domain.AccountFinder;

/*
this is an example of an abstraction. It's meant to be illustrative.
For this trivial domain, it's probably overkill.
Imagine something more complicated as you're reading this, with complex business logic
 */

public class AccountRelatedOperationBuilder
{
    private AccountFinder.AccountSingleFinderForRelatedClasses accountFinder;
    private Operation current = NoOperation.instance();

    public AccountRelatedOperationBuilder(AccountFinder.AccountSingleFinderForRelatedClasses accountFinder)
    {
        this.accountFinder = accountFinder;
    }

    public void addLocationFilter(String location)
    {
        //let's pretend we need some business logic around location
        if ("New York".equalsIgnoreCase(location.trim()))
        {
            location = "NY";
        }
        if ("London".equalsIgnoreCase(location.trim()))
        {
            location = "LDN";
        }
        current = current.and(accountFinder.location().eq(location));
    }

    public Operation getOperation()
    {
        return this.current;
    }
}
