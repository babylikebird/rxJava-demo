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
 * Time: 15:46
 */
@Slf4j
public class L6_3_SkipWhile {
    public static void main(String[] args) {
        /**
         * 1、可以设置条件，当某个数据满足条件时不发送该数据，反之则发送。
         */
        Observable.just(1, 2, 3, 4)
                .skipWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 3;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                log.info("accept : {}",integer);
            }
        });
    }
}
