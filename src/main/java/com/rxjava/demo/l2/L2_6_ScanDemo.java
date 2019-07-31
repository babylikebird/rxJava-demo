package com.rxjava.demo.l2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-31
 * Time: 14:26
 */
@Slf4j
public class L2_6_ScanDemo {
    public static void main(String[] args) {
        /**
         * 1、scan将数据以一定的逻辑聚合起来
         */
        Observable.just(1, 2 , 3, 4, 5)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        log.info("=========apply");
                        log.info("=========integer : {}",integer);
                        log.info("=========integer2 : {}",integer2);
                        return integer + integer2;
                    }
                }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("=========onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                log.info("accept : {}",integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                log.info("=========onComplete");
            }
        });
    }
}
