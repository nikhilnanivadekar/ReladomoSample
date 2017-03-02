package example.complex.gui;

import com.gs.collections.impl.set.mutable.UnifiedSet;
import com.gs.fw.finder.Operation;
import example.complex.domain.ProductFinder;
import example.complex.domain.query.ProductRelatedOperationBuilder;
import example.complex.util.DateUtil;

import java.util.Date;
import java.util.Set;

public class ProductComponent
{
    public Operation getUserOperation(ProductFinder.ProductSingleFinderForRelatedClasses productFinder)
    {
        ProductRelatedOperationBuilder builder = new ProductRelatedOperationBuilder(productFinder, this.readUserCusips());
        Date maturityDate = readUserMaturityDate();
        if (maturityDate != null)
        {
            builder.addMaturityDateFilter(maturityDate);
        }
        return builder.getOperation();
    }

    private Set<String> readUserCusips()
    {
        //stubbed out for this example
        return UnifiedSet.newSetWith("ABC", "XYZ");
    }

    private Date readUserMaturityDate()
    {
        //stubbed out for this example
        return DateUtil.parseDate("2020-01-01 00:00:00");
    }
}
