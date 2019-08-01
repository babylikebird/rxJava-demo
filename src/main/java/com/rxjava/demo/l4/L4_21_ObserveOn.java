package com.rxjava.demo.l4;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 17:37
 */
@Slf4j
public class L4_21_ObserveOn {
    public static void main(String[] args) {
        /**
         * 1、指定观察者的线程，每指定一次就会生效一次。
         * 2、后面会覆盖前面
         */
        Observable.just(1, 2, 3)
                .observeOn(Schedulers.newThread())
                .observeOn(Schedulers.computation())
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        log.info("=========currentThread name:{}", Thread.currentThread().getName());
                        return Observable.just("Niu"+integer);
                    }
                }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("=========onSubscribe ");
            }

            @Override
            public void onNext(String s) {
                log.info("=========onNext : {}", s);
            }

            @Override
            public void onError(Throwable e) {
                log.info("=========onError ");
            }

            @Override
            public void onComplete() {
                log.info("=========onComplete ");
            }
        });
        try {
            log.info("随便输入按回车退出............");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
