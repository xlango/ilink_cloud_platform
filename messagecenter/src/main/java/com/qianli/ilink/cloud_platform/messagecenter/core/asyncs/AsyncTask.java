//package com.qianli.ilink.cloud_platform.messagecenter.core.asyncs;
//
//import com.qianli.ilink.cloud_platform.commons.core.eneity.BaseEntity;
//import org.springframework.scheduling.annotation.Async;
//
//@Async
//@FunctionalInterface
//public interface AsyncTask {
//
//    <E extends BaseEntity> void execute(E e);
//
//    default <E extends BaseEntity> void batchExecute(E...e){
//        for (E e1 : e) {
//            execute(e1);
//        }
//    }
//}
