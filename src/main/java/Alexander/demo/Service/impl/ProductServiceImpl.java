package Alexander.demo.Service.impl;

import java.util.Optional;

import Alexander.demo.SharedDto.ProductDto;
import Alexander.demo.Model.Entity.ProductEntity;
import Alexander.demo.Model.Request.ProductRequestModel;
import Alexander.demo.Repository.ProductRepo;
import Alexander.demo.Service.ProductService;
import Alexander.demo.Service.FilterUtil.Filter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @Override
    public ProductDto[] getAllProducts(){
        
        ProductDto[] proDtoAll = new ProductDto[(int) ];

        return proDtoAll;
    }

    @Override
    public ProductDto getProduct(ProductDto productDetailsIn) {
        
        Optional<ProductEntity> productFind = productRepo.findByProductId(productDetailsIn.getProductId());

        ProductDto proDtoFind = new ProductDto();
        BeanUtils.copyProperties(productFind.get(), proDtoFind);

        return proDtoFind;
    }

    @Override
    public ProductDto createProduct(ProductDto productDetailsIn) {

        ProductEntity proEnt = new ProductEntity();
        BeanUtils.copyProperties(productDetailsIn, proEnt);

        ProductEntity proEntSave = productRepo.save(proEnt);

        ProductDto proDtoSave = new ProductDto();
        BeanUtils.copyProperties(proEntSave, proDtoSave);

        return proDtoSave;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDetailsIn, ProductRequestModel proReqModel) {


        ProductEntity proEnt = new ProductEntity();
        BeanUtils.copyProperties(productDetailsIn, proEnt);

        Filter filter = new Filter();
        BeanUtils.copyProperties(proReqModel, proEnt, filter.editElement(proReqModel));

        ProductEntity proEntSave = productRepo.save(proEnt);

        ProductDto proDtoResp = new ProductDto();
        BeanUtils.copyProperties(proEntSave, proDtoResp);

        return proDtoResp;
    }

    @Override
    public void deleteProduct(ProductDto productDetails) {

        ProductEntity proEnt = new ProductEntity();
        BeanUtils.copyProperties(productDetails, proEnt);
        productRepo.delete(proEnt);
    }
    
}
