package com.rxjava.demo.l5;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 14:30
 */
@Slf4j
public class L5_2_OfType {
    public static void main(String[] args) {
        /**
         * 1、可以过滤掉不符合该类型的事件
         */
        Observable.just(1, 2, 3, "JJ", "kk")
                .ofType(Integer.class)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("accept : {}", integer);
                    }
                });
    }
}
