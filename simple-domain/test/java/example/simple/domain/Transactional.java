package example.simple.domain;

import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.Operation;
import org.junit.Test;

public class Transactional extends AbstractReladomoTest
{
    @Test
    public void update()
    {
        MithraManagerProvider.getMithraManager().executeTransactionalCommand(tx ->
        {
            Person person = PersonFinder.findOne(PersonFinder.personId().eq(8));
            person.setFirstName("David");
            person.setLastName("Smith");
            return person;
        });
    }

    @Test
    public void delete()
    {
        Person john = PersonFinder.findOne(PersonFinder.personId().eq(8));
        john.delete();
    }

    @Test
    public void deleteAll()
    {
        Operation op = PersonFinder.firstName().eq("John");
        op = op.and(PersonFinder.lastName().endsWith("e"));
        PersonList johns = PersonFinder.findMany(op);
        johns.deleteAll();
    }

    @Test
    public void deleteAllInBatches()
    {
        Operation op = PersonFinder.firstName().eq("John");
        op = op.and(PersonFinder.lastName().endsWith("h"));
        PersonList johns = PersonFinder.findMany(op);
        johns.deleteAllInBatches(1);
    }
}
