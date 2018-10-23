package com.qianli.ilink.cloud_platform.geteway.web;


import com.qianli.ilink.cloud_platform.commons.core.eneity.ResponseEntity;
import com.qianli.ilink.cloud_platform.commons.core.utils.ResponseEntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello/{name}")
    public ResponseEntity hello(@PathVariable("name") String name){

        return ResponseEntityUtils.buildSuccess();
    }




}
