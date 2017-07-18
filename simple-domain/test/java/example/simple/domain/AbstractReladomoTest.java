package example.simple.domain;

import com.gs.fw.common.mithra.test.ConnectionManagerForTests;
import com.gs.fw.common.mithra.test.MithraTestResource;
import org.junit.After;
import org.junit.Before;

public class AbstractReladomoTest
{
    private MithraTestResource mithraTestResource;

    protected String getMithraConfigXmlFilename()
    {
        return "testconfig/TestReladomoRuntimeConfig.xml";
    }

    @Before
    public void setUp() throws Exception
    {
        this.mithraTestResource = new MithraTestResource(this.getMithraConfigXmlFilename());
        final ConnectionManagerForTests connectionManager = ConnectionManagerForTests.getInstanceForDbName("simple_domain_db");
        this.mithraTestResource.createSingleDatabase(connectionManager);
        this.mithraTestResource.addTestDataToDatabase("testdata/data_AllTypes.txt", connectionManager);
        this.mithraTestResource.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        this.mithraTestResource.tearDown();
    }
}
