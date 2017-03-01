package example.complex.domain;

import org.junit.Assert;
import org.junit.Test;

public class SimpleFinders extends AbstractReladomoTest
{
    @Test
    public void findByName()
    {
        Account account = AccountFinder.findOne(AccountFinder.acctId().eq(1));
        Assert.assertEquals("Bob", account.getFirstName());
        Assert.assertEquals("Smith", account.getLastName());
    }

    @Test
    public void findTrade()
    {
        Balance balanceA = BalanceFinder.findOne(BalanceFinder.acctId().eq(1).and(BalanceFinder.exchange().eq("DeskA")));
        Assert.assertEquals(10.01, balanceA.getValue(), 0.00);
        Balance balanceB = BalanceFinder.findOne(BalanceFinder.acctId().eq(1).and(BalanceFinder.exchange().eq("DeskB")));
        Assert.assertEquals(20.01, balanceB.getValue(), 0.00);
    }
}
