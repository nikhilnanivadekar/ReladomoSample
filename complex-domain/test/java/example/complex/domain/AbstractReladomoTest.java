package example.complex.domain;

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

    protected String[] getTestDataFileNamesForDeskA()
    {
        return new String[]{"testdata/data_AllTypes_DeskA.txt"};
    }

    protected String[] getTestDataFileNamesForDeskB()
    {
        return new String[]{"testdata/data_AllTypes_DeskB.txt"};
    }

    @Before
    public void setUp() throws Exception
    {
        this.mithraTestResource = new MithraTestResource(this.getMithraConfigXmlFilename());

        ConnectionManagerForTests shardedConnectionManager = ConnectionManagerForTests.getInstance("complex_domain");
        this.createDatabaseForSource(shardedConnectionManager, this.getTestDataFileNamesForDeskA(), "DeskA");
        this.createDatabaseForSource(shardedConnectionManager, this.getTestDataFileNamesForDeskB(), "DeskB");


        this.mithraTestResource.setUp();
    }

    private void createDatabaseForSource(ConnectionManagerForTests connectionManager, String[] testDataFileNames, String source)
    {
        for (String fileName : testDataFileNames)
        {
            this.mithraTestResource.createDatabaseForStringSourceAttribute(connectionManager, source, fileName);
        }
    }

    @After
    public void tearDown() throws Exception
    {
        this.mithraTestResource.tearDown();
    }
}
