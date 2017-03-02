package example.complex.gui;

import com.gs.collections.impl.set.mutable.UnifiedSet;
import com.gs.fw.common.mithra.finder.Operation;
import example.complex.domain.BalanceFinder;
import example.complex.domain.BalanceList;
import example.complex.util.DateUtil;

import java.util.Date;
import java.util.Set;

public class BalanceWindow
{

    private AccountComponent accountComponent = new AccountComponent();
    private ProductComponent productComponent = new ProductComponent();

    public BalanceList retrieveBalances()
    {
        Operation op = BalanceFinder.businessDate().eq(readUserDate());
        op = op.and(BalanceFinder.desk().in(readUserDesks()));
        Operation refDataOp = accountComponent.getUserOperation(BalanceFinder.account());
        refDataOp = refDataOp.and(productComponent.getUserOperation(BalanceFinder.product()));
        op = op.and(refDataOp);
        return BalanceFinder.findMany(op);
    }

    public BalanceList retrieveBalancesWithOr()
    {
        Operation op = BalanceFinder.businessDate().eq(readUserDate());
        op = op.and(BalanceFinder.desk().in(readUserDesks()));
        Operation refDataOp = accountComponent.getUserOperation(BalanceFinder.account());
        refDataOp = refDataOp.or(productComponent.getUserOperation(BalanceFinder.product()));
        op = op.and(refDataOp);
        return BalanceFinder.findMany(op);
    }

    private Set<String> readUserDesks()
    {
        //read it from the gui component. stubbed out for this example.
        return UnifiedSet.newSetWith("DeskA");
    }

    private Date readUserDate()
    {
        //read it from the gui component. stubbed out for this example.
        return DateUtil.parseDate("2017-03-02 00:00:00");
    }


}
