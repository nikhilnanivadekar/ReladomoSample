package example.complex.gui;

import com.gs.fw.common.mithra.finder.Operation;
import example.complex.domain.AccountFinder;
import example.complex.domain.query.AccountRelatedOperationBuilder;

public class AccountComponent
{

    public Operation getUserOperation(AccountFinder.AccountSingleFinderForRelatedClasses account)
    {
        AccountRelatedOperationBuilder builder = new AccountRelatedOperationBuilder(account);
        String location = this.readUserSpecifiedLocation();
        if (location != null)
        {
            builder.addLocationFilter(location);
        }
        return builder.getOperation();
    }

    private String readUserSpecifiedLocation()
    {
        //stubbed out for this example.
        return "New York";
    }
}
