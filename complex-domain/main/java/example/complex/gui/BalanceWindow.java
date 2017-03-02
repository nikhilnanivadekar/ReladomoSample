package example.complex.gui;

import com.gs.fw.common.mithra.finder.Operation;
import example.complex.domain.BalanceFinder;
import example.complex.domain.BalanceList;
import example.complex.util.DateUtil;

import java.util.Date;

public class BalanceWindow
{

    private AccountComponent accountComponent = new AccountComponent();
    private ProductComponent productComponent = new ProductComponent();

    public BalanceList retrieveBalances()
    {
        Operation op = BalanceFinder.businessDate().eq(readUserDate());
        Operation refDataOp = accountComponent.getUserOperation(BalanceFinder.account());
        refDataOp = refDataOp.and(productComponent.getUserOperation(BalanceFinder.product()));
        op = op.and(refDataOp);
        return BalanceFinder.findMany(op);
    }

    private Date readUserDate()
    {
        //read it from the gui component. stubbed out for this example.
        return DateUtil.parseDate("2017-03-02 00:00:00");
    }


}
