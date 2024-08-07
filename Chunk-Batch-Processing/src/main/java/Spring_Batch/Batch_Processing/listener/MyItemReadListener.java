package Spring_Batch.Batch_Processing.listener;

import Spring_Batch.Batch_Processing.domain.Product;
import org.springframework.batch.core.ItemReadListener;

public class MyItemReadListener implements ItemReadListener<Product> {

	@Override
	public void beforeRead() {
		System.out.println("beforeRead() executed");
	}

	@Override
	public void afterRead(Product item) {
		System.out.println("afterRead() executed for product " + item.getProductId());
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("onReadError() executed");
	}

}
