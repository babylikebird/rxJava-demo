package com.rxjava.demo.l6;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-06
 * Time: 10:01
 */
@Slf4j
public class L6_7_Contains {
    public static void main(String[] args) {
        /**
         * 1、判断事件序列中是否含有某个元素，如果有则返回 true，如果没有则返回 false。
         */
        Observable.just(1, 2, 3)
                .contains(3)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        log.info("accept : {}", aBoolean);
                    }
                });
    }
}
