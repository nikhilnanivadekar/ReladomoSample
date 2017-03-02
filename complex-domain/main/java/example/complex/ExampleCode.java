package example.complex;

import example.complex.gui.BalanceWindow;
import example.simple.domain.Person;
import example.simple.domain.PersonFinder;

// just some example code for the accompanying article.
public class ExampleCode
{
    public void codeSnippets()
    {
        Person john = PersonFinder.findOne(PersonFinder.personId().eq(102));
        john.getFirstName();
        PersonFinder.firstName().toLowerCase().startsWith("j");
        PersonFinder.firstName().eq("John");

        new BalanceWindow().retrieveBalances();
        new BalanceWindow().retrieveBalancesWithOr();
    }
}
