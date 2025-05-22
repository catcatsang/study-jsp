package com.app.mysql.service;

import com.app.mysql.domain.dto.ProductDTO;
import com.app.mysql.domain.dto.ProductOnlineDTO;
import com.app.mysql.domain.vo.OnlineVO;
import com.app.mysql.domain.vo.ProductVO;
import com.app.mysql.mapper.ProductMapper;
import com.app.mysql.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Override
    public Optional<ProductDTO> getProduct(Long id) {
        return Optional.ofNullable(
                toProductDTO(productDAO.findVoById(id)
                        .orElseThrow(RuntimeException::new)));
    }

    @Override
    public void insert(ProductOnlineDTO productOnlineDTO) {
//        ProductVO productVO;
//        OnlineVO onlineVO;
//
//        productVO = toProductVO(productOnlineDTO);
//        ProductMapper.insert(productVO);
//
//        productOnlineDTO.setId(productVO.getId());
//
//        onlineVO = toOnlineVO(productOnlineDTO);
//        insert(onlineVO);
    }
}








