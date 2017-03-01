package example.simple.domain;

import org.junit.Assert;
import org.junit.Test;

public class SimpleFinders extends AbstractReladomoTest
{
    @Test
    public void findByName()
    {
        Person john = PersonFinder.findOne(PersonFinder.firstName().eq("John"));
        Assert.assertEquals("Doe", john.getLastName());
    }
}
