package br.cefet.aps.cfs.control;

import br.cefet.aps.cfs.model.Product;
import br.cefet.aps.cfs.model.ProductGeneral;

class ProductGeneralServices extends ProductServices {

	@Override
	Product newProduct(Long id, String name, Long quantity) {
		return new ProductGeneral(id, name, quantity);
	}
	

}
