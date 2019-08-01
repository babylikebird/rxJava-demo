package com.rxjava.demo.l3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 10:55
 */
@Slf4j
public class L3_10_CountDemo {
    public static void main(String[] args) {
        /**
         * 返回被观察者发送事件的数量。
         */
        Observable.just(1, 2, 3)
                .count()
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        log.info("accept : {}", aLong);
                    }
                });
    }
}
