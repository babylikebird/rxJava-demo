package com.rxjava.demo.l3;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 10:44
 */
@Slf4j
public class L3_7_ReduceDemo {
    public static void main(String[] args) {
        /**
         * 1、与 scan() 操作符的作用也是将发送数据以一定逻辑聚合起来，
         * 这两个的区别在于 scan() 每处理一次数据就会将事件发送给观察者，而 reduce() 会将所有数据聚合在一起才会发送事件给观察者。
         * 2、 从结果可以看到，其实就是前2个数据聚合之后，然后再与后1个数据进行聚合，一直到没有数据为止。
         */
        Observable.just(1, 2 ,3, 4)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        log.info("apply");
                        log.info("integer : {}",integer);
                        log.info("integer2 : {}",integer2);
                        return integer + integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                log.info("accept:{}",integer);
            }
        });
    }
}
