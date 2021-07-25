package com.cedricxs.application.controller;


import com.cedricxs.api.product.dto.AddProductDTO;
import com.cedricxs.api.product.dto.AddProductResultDTO;
import com.cedricxs.api.product.dto.GetProductResultDTO;
import com.cedricxs.api.product.interfaces.RpcProductService;
import com.cedricxs.application.exception.RepositoryException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chaxingshuo
 * @date 2021/07/24
 */
@RestController
public class ProductController {

    @Resource
    private RpcProductService rpcProductService;

    @GetMapping(path = "/product")
    public GetProductResultDTO getProduct() {
        System.out.println("start rpc get product");
        return rpcProductService.getProduct();
    }

    @PostMapping(path = "/product")
    public AddProductResultDTO addProduct(AddProductDTO addProductDTO) throws RepositoryException {
        System.out.println("start rpc add product");
        return rpcProductService.addProduct(addProductDTO);
    }

}
