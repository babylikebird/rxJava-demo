package com.rxjava.demo.l5;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 14:28
 */
@Slf4j
public class L5_1_Filter {
    public static void main(String[] args) {
        /**
         * 1、通过一定逻辑来过滤被观察者发送的事件，如果返回 true 则会发送事件，否则不会发送。
         */
        Observable.just(1, 2, 3)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer <= 2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                log.info("accept : {}", integer);
            }
        });
    }
}
