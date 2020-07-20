package ap.sb.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Qualifier("regularcost")
class RegularCost implements Cost{
	@Override
	public int getBaseCost() {
		return 1234;
	}
	@Override
	public int getDiscountPercentage() {
		return 0;
	}
}

// Build - Test - Deploy
