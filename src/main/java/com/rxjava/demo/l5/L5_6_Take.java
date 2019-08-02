package com.rxjava.demo.l5;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 15:03
 */
@Slf4j
public class L5_6_Take {
    public static void main(String[] args) {
        /**
         * 1、控制观察者接收的事件的数量。
         */
        Observable.just(1, 2, 3, 4, 5)
                .take(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("accept : {}",integer);
                    }
                });
    }
}
