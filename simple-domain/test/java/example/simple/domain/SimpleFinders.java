package example.simple.domain;

import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.Operation;
import org.junit.Assert;
import org.junit.Test;

public class SimpleFinders extends AbstractReladomoTest
{
    @Test
    public void findById()
    {
        Person john = PersonFinder.findOne(PersonFinder.personId().eq(8));
        Assert.assertEquals("Doe", john.getLastName());
    }

    @Test
    public void findByName()
    {
        Person john = PersonFinder.findOne(PersonFinder.firstName().eq("John"));
        Assert.assertEquals("Doe", john.getLastName());
    }

    @Test
    public void findByStartsWith()
    {
        Person john = PersonFinder.findOne(PersonFinder.firstName().toLowerCase().startsWith("j"));
        Assert.assertEquals("Doe", john.getLastName());
    }

    @Test
    public void combinedOperations()
    {
        Operation op = PersonFinder.firstName().eq("John");
        op = op.and(PersonFinder.lastName().endsWith("e"));
        PersonList johns = PersonFinder.findMany(op);
    }

    @Test
    public void transactionalUpdate()
    {
        MithraManagerProvider.getMithraManager().executeTransactionalCommand(tx ->
        {
            Person person = PersonFinder.findOne(PersonFinder.personId().eq(8));
            person.setFirstName("David");
            person.setLastName("Smith");
            return person;
        });
    }
}
