package example.complex.gui;

import com.gs.fw.common.mithra.finder.Operation;
import example.complex.domain.TradeFinder;
import example.complex.domain.TradeList;
import example.complex.util.DateUtil;

import java.util.Date;

public class TradeWindow
{
    private AccountComponent accountComponent = new AccountComponent();
    private ProductComponent productComponent = new ProductComponent();
    
    public TradeList retrieveTrades()
    {
        Operation op = TradeFinder.businessDate().eq(readUserDate());
        Operation refDataOp = accountComponent.getUserOperation(TradeFinder.account());
        refDataOp = refDataOp.and(productComponent.getUserOperation(TradeFinder.product()));
        op = op.and(refDataOp);
        return TradeFinder.findMany(op);
    }

    private Date readUserDate()
    {
        //read it from the gui component. stubbed out for this example.
        return DateUtil.parseDate("2017-03-02 00:00:00");
    }


}
