package ap.sb.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("newcustomercost")
public class NewCustomerCost implements Cost{

	@Override
	public int getBaseCost() {
		
		return 1234;
	}

	@Override
	public int getDiscountPercentage() {
		
		return 15;
	}

}
