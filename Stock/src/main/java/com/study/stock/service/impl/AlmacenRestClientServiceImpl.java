package com.study.stock.service.impl;

import com.study.stock.service.AlmacenRestClientService;
import com.study.stock.service.vo.ProductoServiceInVO;
import com.study.stock.service.vo.ProductoServiceOutVO;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Service
@PropertySource("classpath:application.properties")
public class AlmacenRestClientServiceImpl implements AlmacenRestClientService {

    @Value("${client.rest.uri}")
    private String uri;

    @Override
    public ProductoServiceOutVO obtenerProducto(ProductoServiceInVO producto) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return restTemplate.postForObject(uri.concat("/provideProducto"),producto, ProductoServiceOutVO.class);
    }
}
