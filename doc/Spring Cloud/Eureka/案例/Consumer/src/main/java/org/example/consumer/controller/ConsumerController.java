package org.example.consumer.controller;

import org.example.consumer.MyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author: longzhonghua
 * @date: 2019/9/20
 * Description: 将MyFeignClient注入到controller层
 */

@RestController
public class ConsumerController {
    @Autowired
    MyFeignClient myFeignClient;
    @RequestMapping("/greet")
    public String index() {
        return myFeignClient.hello();
    }
}