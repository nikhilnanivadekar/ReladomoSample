package example.complex.domain.query;

import com.gs.fw.common.mithra.finder.Operation;
import example.complex.domain.ProductFinder;

import java.util.Date;
import java.util.Set;

/*
This is an example of an abstraction. It's meant to be illustrative.
For this trivial domain, it's probably overkill.
Imagine something more complicated as you're reading this, with business logic, like the maturity date filter below
 */
public class ProductRelatedOperationBuilder
{
    private static final long FIFTY_YEARS = 50*365*24*60*60*1000L;

    private ProductFinder.ProductSingleFinderForRelatedClasses productFinder;
    private Operation current;

    public ProductRelatedOperationBuilder(ProductFinder.ProductSingleFinderForRelatedClasses productFinder, Set<String> cusips)
    {
        this.productFinder = productFinder;
        current = productFinder.cusipSynonym().synonymValue().in(cusips);
    }

    public Operation getOperation()
    {
        return current;
    }

    public void addMaturityDateFilter(Date maturityDate)
    {
        //let's pretend maturity date is complicated and needs some business logic
        if (maturityDate.getTime() > System.currentTimeMillis()+ FIFTY_YEARS)
        {
            current = current.and(productFinder.maturityDate().notEq(ProductFinder.processingDate().getInfinityDate()));
        }
        else
        {
            current = current.and(productFinder.maturityDate().lessThan(maturityDate));
        }
    }
}
