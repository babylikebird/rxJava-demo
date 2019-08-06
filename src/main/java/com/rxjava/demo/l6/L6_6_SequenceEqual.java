package com.rxjava.demo.l6;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-06
 * Time: 9:56
 */
@Slf4j
public class L6_6_SequenceEqual {
    public static void main(String[] args) {
        /**
         * 1、判断两个 Observable 发送的事件是否相同。
         */
        Observable.sequenceEqual(Observable.just(1, 2, 3),
                Observable.just(1, 2, 4))
                .subscribe(new Consumer< Boolean >() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        log.info("accept : {}",aBoolean);
                    }
                });
    }
}
