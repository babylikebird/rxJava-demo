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
 * Time: 15:43
 */
@Slf4j
public class L6_1_All {
    public static void main(String[] args) {
        /**
         * 1、判断事件序列是否全部满足某个事件，如果都满足则返回 true，反之则返回 false。
         */
        Observable.just(1, 2, 3, 4)
                .all(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 3;
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                log.info("accept : {}", aBoolean);
            }
        });
    }
}
