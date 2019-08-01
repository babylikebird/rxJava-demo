package com.rxjava.demo.l4;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 17:07
 */
@Slf4j
public class L4_18_Repeat {
    public static void main(String[] args) {
        /**
         * 1、重复发送被观察者的事件，times 为发送次数。
         */
        Observable.just(1, 2, 3)
                .repeat(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("accept: {}",integer);
                    }
                });
    }
}
