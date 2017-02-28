package example.domain;

import com.gs.fw.common.mithra.MithraSequence;

public class ObjectSequence extends ObjectSequenceAbstract implements MithraSequence
{
    public ObjectSequence()
    {
        super();
        // You must not modify this constructor. Mithra calls this internally.
        // You can call this constructor. You can also add new constructors.
    }

    public void setSequenceName(String sequenceName)
    {
        this.setSimulatedSequenceName(sequenceName);
    }

    public long getNextId()
    {
        return this.getNextValue();
    }

    public void setNextId(long nextValue)
    {
        this.setNextValue(nextValue);
    }
}
