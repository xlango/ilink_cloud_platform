//package com.qianli.ilink.cloud_platform.messagecenter.repository;
//
//import com.qianli.ilink.cloud_platform.messagecenter.BaseTest;
//import com.qianli.ilink.cloud_platform.messagecenter.core.entity.UserEntity;
//import com.qianli.ilink.cloud_platform.messagecenter.repository.mysql.TestRepository;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//public class TestRepositoryTest extends BaseTest{
//
//    @Resource
//    private TestRepository testRepository;
//
//
//    @Test
//    public void test(){
//        List<UserEntity> all = testRepository.findAll();
//        all.forEach(System.out::println);
//    }
//
//
//}