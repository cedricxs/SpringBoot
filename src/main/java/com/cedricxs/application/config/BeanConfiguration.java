package com.cedricxs.application.config;

import com.cedricxs.api.product.interfaces.RpcProductService;
import com.cedricxs.rpc.RpcProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Configuration
public class BeanConfiguration {

    @Autowired
    RpcProxy rpcProxy;

    @Bean
    public RpcProductService rpcProductService() {
        return (RpcProductService)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{RpcProductService.class}, rpcProxy);
    }

}
