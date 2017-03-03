package example.simple.domain;

import org.junit.Test;

public class Relationships extends AbstractReladomoTest
{
    @Test
    public void getPets()
    {
        Person person = PersonFinder.findOne(PersonFinder.personId().eq(2));
        PetList pets = person.getPets();
    }

    @Test
    public void navigation()
    {
        PersonList people = PersonFinder.findMany(PersonFinder.all());
        people.deepFetch(PersonFinder.pets());
    }
}
