package example.complex.domain;
import java.sql.Timestamp;
public class ProductSynonym extends ProductSynonymAbstract
{
	public ProductSynonym(Timestamp businessDate
	, Timestamp processingDate
	)
	{
		super(businessDate
		,processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public ProductSynonym(Timestamp businessDate)
	{
		super(businessDate);
	}
}
