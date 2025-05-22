package com.app.mysql.service;

import com.app.mysql.domain.dto.ProductDTO;
import com.app.mysql.domain.dto.ProductOnlineDTO;
import com.app.mysql.domain.vo.OnlineVO;
import com.app.mysql.domain.vo.ProductVO;

import java.util.Optional;

public interface ProductService {
//    상품 조회
    public Optional<ProductDTO> getProduct(Long id);

//    상품 추가
    public void insert(ProductOnlineDTO productOnlineDTO);

    public default ProductDTO toProductDTO(ProductVO productVO){
        ProductDTO productDTO = null;
        if(productVO != null){
            productDTO.setId(productVO.getId());
            productDTO.setProductName(productVO.getProductName());
            productDTO.setProductStock(productVO.getProductStock());
            productDTO.setProductPrice(productVO.getProductPrice());
            productDTO.setCreatedDate(productVO.getCreatedDate());
            productDTO.setUpdatedDate(productVO.getUpdatedData());
        }
        return productDTO;
    }

//    public default ProductVO toProductVO(ProductOnlineDTO productOnlineDTO){
//        return ProductVO.builder().productName(productOnlineDTO.getProductName()).build();
//    }
//
//    public default OnlineVO toOnlineVO(ProductOnlineDTO productOnlineDTO){
//        return OnlineVO.builder().marketName(productOnlineDTO.getMarketName()).build();
//    }

}











