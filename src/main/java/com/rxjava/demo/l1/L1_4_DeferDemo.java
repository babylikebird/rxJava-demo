package com.rxjava.demo.l1;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-30
 * Time: 15:30
 */
@Slf4j
public class L1_4_DeferDemo {

    private static int i = 100;

    public static void main(String[] args) {
        /**
         * 这个方法的作用就是直到被观察者被订阅后才会创建被观察者。
         */
        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(i);
            }
        });
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                log.info("onNext: {}", integer);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
                log.info("onComplete");
            }
        };
        observable.subscribe(observer);
        i = 200;
        observable.subscribe(observer);
        i = 300;
        observable.subscribe(observer);
    }
}
