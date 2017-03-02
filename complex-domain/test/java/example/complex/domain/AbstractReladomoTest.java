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
        return "example/complex/testconfig/TestReladomoRuntimeConfig.xml";
    }

    protected String[] getTestDataFileNamesForDeskA()
    {
        return new String[]{"example/complex/testdata/data_AllTypes_DeskA.txt"};
    }

    protected String[] getTestDataFileNamesForDeskB()
    {
        return new String[]{"example/complex/testdata/data_AllTypes_DeskB.txt"};
    }

    @Before
    public void setUp() throws Exception
    {
        this.mithraTestResource = new MithraTestResource(this.getMithraConfigXmlFilename());

        final ConnectionManagerForTests nonShardedconnectionManager = ConnectionManagerForTests.getInstance("complex_domain_db_non_sharded");
        this.mithraTestResource.createSingleDatabase(nonShardedconnectionManager);
        this.mithraTestResource.addTestDataToDatabase("example/complex/testdata/data_AllTypes_NonSharded.txt", nonShardedconnectionManager);

        ConnectionManagerForTests shardedConnectionManager = ConnectionManagerForTests.getInstance("complex_domain_db_sharded");
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
