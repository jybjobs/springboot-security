package com.yihecloud.service;

import com.yihecloud.entity.Customer;
import com.yihecloud.entity.CustomerRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jyb on 17-9-2.
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Resource
    private CustomerRepository customerRepository ;

    @Override
    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    /**
     * 127.0.0.1:6379> get com.yihecloud.service.CustomerServiceImplfindById2
     "[\"com.yihecloud.entity.Customer\",{\"id\":2,\"firstName\":\"Chloe\",\"lastName\":\"O'Brian\"}]"
     * @param id
     * @return
     */
    @Cacheable(value = "customer") //添加到redis
    public Customer findById(Long id){
        return customerRepository.findOne(id);
    }

    @Cacheable(value= "customers")
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }
    /**
     * 删除缓存数据
     * @param id
     */
    @CacheEvict
    @Transactional(rollbackFor = IllegalArgumentException.class)//指定特殊异常时，进行数据回滚
    public void deleteById(Long id){
        customerRepository.delete(id);
        System.out.println("删除缓存......");
    }




}
