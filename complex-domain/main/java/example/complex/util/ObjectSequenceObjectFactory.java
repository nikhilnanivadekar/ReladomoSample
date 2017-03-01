package example.complex.util;

import com.gs.fw.common.mithra.MithraSequence;
import com.gs.fw.common.mithra.MithraSequenceObjectFactory;
import example.complex.domain.ObjectSequence;
import example.complex.domain.ObjectSequenceFinder;

public class ObjectSequenceObjectFactory
        implements MithraSequenceObjectFactory
{
    public MithraSequence getMithraSequenceObject(String sequenceName, Object sourceAttribute, int initialValue)
    {
        ObjectSequence objectSequence = ObjectSequenceFinder.findByPrimaryKey(sequenceName);
        if (objectSequence == null)
        {
            objectSequence = new ObjectSequence();
            objectSequence.setSimulatedSequenceName(sequenceName);
            objectSequence.setNextValue(initialValue);
            objectSequence.insert();
        }
        return objectSequence;
    }
}
