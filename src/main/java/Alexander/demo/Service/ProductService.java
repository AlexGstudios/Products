package Alexander.demo.Service;

import Alexander.demo.Model.Request.ProductRequestModel;
import Alexander.demo.SharedDto.ProductDto;

public interface ProductService {

    ProductDto[] getAllProducts();
    ProductDto getProduct(ProductDto productDetailsIn);
    ProductDto createProduct(ProductDto productDetailsIn);
    ProductDto updateProduct(ProductDto productDetailsIn, ProductRequestModel proReqModel);
    void deleteProduct(ProductDto productDetails);    
}