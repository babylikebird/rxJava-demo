package com.rxjava.demo.l4;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 11:10
 */
@Slf4j
public class L4_2_DoOnEach {
    public static void main(String[] args) {
        /**
         * 1、Observable 每发送一件事件之前都会先回调这个方法。
         * 2、直到时间发送完毕
         */
        Observable.just(1, 2, 3, 4)
                .doOnEach(new Consumer<Notification<Integer>>() {
                    @Override
                    public void accept(Notification<Integer> integerNotification) throws Exception {
                        log.info("doOnEach accept : {}", integerNotification.getValue());
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                log.info("subscribe accept : {}",integer);
            }
        });
    }
}
