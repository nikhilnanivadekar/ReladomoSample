package example.complex;

import com.gs.collections.impl.factory.Sets;
import com.gs.fw.common.mithra.finder.Operation;
import example.complex.domain.TradeFinder;
import example.complex.domain.TradeList;
import example.complex.gui.BalanceWindow;
// import example.simple.domain.Person;
// import example.simple.domain.PersonFinder;

import java.util.Set;

// just some example code for the accompanying article.
public class ExampleCode
{
    public void codeSnippets()
    {
        /**
        Person john = PersonFinder.findOne(PersonFinder.personId().eq(102));
        john.getFirstName();
        PersonFinder.firstName().toLowerCase().startsWith("j");
        PersonFinder.firstName().eq("John");
        */
        new BalanceWindow().retrieveBalances();
        new BalanceWindow().retrieveBalancesWithOr();

        TradeList trades1 = TradeFinder.findMany(TradeFinder.all().and(TradeFinder.desk().eq("DeskA")));
        trades1.deepFetch(TradeFinder.account());
        trades1.deepFetch(TradeFinder.product().cusipSynonym());
        trades1.deepFetch(TradeFinder.product().synonymByType("ISN"));

        Set<String> productNames = Sets.mutable.with("ABC", "XYZ");
        Operation op1 = TradeFinder.account().location().eq("NY");
        op1 = op1.and(TradeFinder.product().productName().in(productNames));
        TradeList trades2 = TradeFinder.findMany(op1);
    }
}
