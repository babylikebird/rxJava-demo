package com.rxjava.demo.l3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 10:53
 */
@Slf4j
public class L3_9_StartWithDemo {
    public static void main(String[] args) {
        /**
         * 1、在发送事件之前追加事件，startWith() 追加一个事件，startWithArray() 可以追加多个事件。
         * 2、追加的事件会先发出。
         */
        Observable.just(5, 6, 7)
                .startWithArray(2, 3, 4)
                .startWith(1)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("accept : {}", integer);
                    }
                });
    }
}
