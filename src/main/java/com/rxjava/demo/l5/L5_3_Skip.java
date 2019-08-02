package com.rxjava.demo.l5;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 14:32
 */
@Slf4j
public class L5_3_Skip {
    public static void main(String[] args) {
        /**
         * 1、跳过正序某些事件、count代表跳过事件的数量
         */
        Observable.just(1, 2, 3, 4)
                .skip(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("accept : {}", integer);
                    }
                });
    }
}
