package com.rxjava.demo.l6;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 15:50
 */
@Slf4j
public class L6_4_TakeUntil {
    public static void main(String[] args) {
        /**
         * 1、可以设置条件，当事件满足此条件时，下一次的事件就不会被发送了。
         */
        Observable.just(1, 2, 3, 4)
                .takeUntil(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                log.info("accept : {}", integer);
            }
        });
    }
}
