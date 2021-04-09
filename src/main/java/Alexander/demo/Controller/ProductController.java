package Alexander.demo.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Alexander.demo.Service.ProductService;
import Alexander.demo.SharedDto.ProductDto;
import Alexander.demo.Model.Request.ProductRequestModel;
import Alexander.demo.Model.Response.ProductResponseModel;


@RestController
@RequestMapping("product")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping
    public ProductDto[] getAllProducts(){
        return ProductDto[] x = new ProductDto[];
    }

    @GetMapping(value="/{productId}")
    public ProductResponseModel getProduct(@PathVariable String productId){

        ProductDto proDtoIn = new ProductDto();
        proDtoIn.setProductId(productId);

        ProductDto proDtoFind = productService.getProduct(proDtoIn);

        ProductResponseModel response = new ProductResponseModel();
        BeanUtils.copyProperties(proDtoFind, response);

        return response;
    }

    @PostMapping
    public ProductResponseModel createProduct(@RequestBody ProductRequestModel productDetails){
        
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productDetails, productDto);

        ProductDto productDtoServ = productService.createProduct(productDto);
        
        ProductResponseModel response = new ProductResponseModel();
        BeanUtils.copyProperties(productDtoServ, response);

        return response;
    }

    @PutMapping(value="/{productId}")
    public ProductResponseModel updateProduct(@PathVariable String productId, @RequestBody ProductRequestModel productDetails){
        
        ProductDto productDtoId = new ProductDto();
        productDtoId.setProductId(productId);

        ProductDto proDtoFind = productService.getProduct(productDtoId);

        ProductDto productDtoServ = productService.updateProduct(proDtoFind, productDetails);
        
        ProductResponseModel response = new ProductResponseModel();
        BeanUtils.copyProperties(productDtoServ, response);

        return response;
    }    

    @DeleteMapping(value="/{productId}")
    public ProductResponseModel deleteProduct(@PathVariable String productId){
        
        ProductDto proDtoId = new ProductDto();
        proDtoId.setProductId(productId);

        ProductDto proDtoDel = productService.getProduct(proDtoId);

        productService.deleteProduct(proDtoDel);

        ProductResponseModel response = new ProductResponseModel();
        BeanUtils.copyProperties(proDtoDel, response);

        return response;
    }
}