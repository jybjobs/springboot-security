package com.yihecloud.controller;

import com.yihecloud.entity.Customer;
import com.yihecloud.entity.CustomerRepository;
import com.yihecloud.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

// Controller 和 RestController 区别：
// @RestController is a stereotype annotation that combines @ResponseBody and @Controller.
//意思是：@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@Controller
//根据官方意思：非 war包方式访问时 可以不用继承 SpringBootServletInitializer
//Note that a WebApplicationInitializer is only needed if you are building a war file and deploying it.
// If you prefer to run an embedded container (we do) then you won't need this at all.
//public class IndexController extends SpringBootServletInitializer {
public class IndexController     {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ICustomerService iCustomerService;

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(IndexController.class);
//    }

    /**
     * 从redis中存取数据
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello", "hello,springboot.");
        model.addAttribute("hello", operations.get("hello"));
        return "index";
    }

    /**
     * 从mysql 中读取数据
     *
     * @return
     */
    @RequestMapping(value = "customers")
    @ResponseBody
    public Iterable<Customer> getCustomers() {
        Iterable<Customer> customers = iCustomerService.findAll();
//        logger.debug(customers.toString());
        return customers;
    }

    /**
     * redis 缓存
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "customer/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable("id") Long id) {
//        logger.debug(customers.toString());
        return iCustomerService.findById(id);
    }
}