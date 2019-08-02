package com.rxjava.demo.l5;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 15:01
 */
@Slf4j
public class L5_5_DistinctUntilChanged {
    public static void main(String[] args) {
        /**
         * 1、过滤掉连续重复的事件
         */
        Observable.just(1, 2, 3, 3, 2, 1)
                .distinctUntilChanged()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("accept : {}", integer);
                    }
                });
    }
}
