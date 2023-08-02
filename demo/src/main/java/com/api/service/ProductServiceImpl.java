package com.api.service;

import com.api.Exception.HnDBankException;
import com.api.dto.ProductDTO;
import com.api.entity.Product;
import com.api.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository ProductRespository;

    @Override
    public int addProduct(ProductDTO productDto) throws HnDBankException {
        Optional<Product> optional = ProductRespository.findById(productDto.getProductId());
        if (optional.isPresent())
            throw new HnDBankException("Service.Product_FOUND");
        Product product = new Product();
        product.setDateOfBirth(productDto.getDateOfBirth());
        product.setEmailId(productDto.getEmailId());
        product.setName(productDto.getName());
        product.setProductId(productDto.getProductId());
        product.setProductType(productDto.getProductType());
        Product s = ProductRespository.save(product);
        return s.getProductId();
    }
    @Override
    public ProductDTO getProduct(Integer ProductId) throws HnDBankException {
        Optional<Product> optional = ProductRespository.findById(ProductId);
        Product product = optional.orElseThrow(() -> new HnDBankException("Service.Product_NOT_FOUND"));
//        Product Product = new Product();
        ProductDTO productDto = new ProductDTO();
        productDto.setProductId(product.getProductId());
        productDto.setDateOfBirth(product.getDateOfBirth());
        productDto.setEmailId(product.getEmailId());
        productDto.setName(product.getName());
        productDto.setProductType(product.getProductType());
        return productDto;
    }
    @Override
    public List<ProductDTO> findAll() throws HnDBankException {
        Iterable<Product> Products = ProductRespository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        Products.forEach(product -> {
            ProductDTO productDto = new ProductDTO();
            productDto.setProductId(product.getProductId());
            productDto.setDateOfBirth(product.getDateOfBirth());
            productDto.setEmailId(product.getEmailId());
            productDto.setProductType(product.getProductType());
            productDto.setName(product.getName());
            productDTOS.add(productDto);
        });
		if (productDTOS.isEmpty())
                throw new HnDBankException("Service.ProductS_NOT_FOUND");
		return productDTOS;
}

    @Override
    public void updateProduct(Integer ProductId, ProductDTO productDTO) throws HnDBankException {
        Optional<Product> optional = ProductRespository.findById(ProductId);
        Product product = optional.orElseThrow(() -> new HnDBankException("Service.Product_NOT_FOUND"));
        product.setEmailId(productDTO.getEmailId());
        product.setName(productDTO.getName());
        product.setProductType(productDTO.getProductType());
    }

    @Override
    public void deleteProduct(Integer ProductId) throws HnDBankException {
        Optional<Product> optional = ProductRespository.findById(ProductId);
        optional.orElseThrow(() -> new HnDBankException("Service.Product_NOT_FOUND"));
        ProductRespository.deleteById(ProductId);
    }

//    @Override
//    public void findBy(String emailId, int custId) throws HnDBankException {
//        List<Product> custlist = ProductRespository.findByEmailId(emailId);
//        System.out.println(custlist);
//        List<String> name = ProductRespository.findNameByEmailId(emailId);
//        System.out.println(name);
//
//        ProductRespository.updateProductEmailId("h1234@gmail.com", custId);
//
////        optional.orElseThrow(() -> new HnDBankException("Service.Product_NOT_FOUND"));
//
//    }


}
