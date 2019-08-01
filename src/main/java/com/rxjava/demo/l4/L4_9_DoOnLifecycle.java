package com.rxjava.demo.l4;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 11:45
 */
@Slf4j
public class L4_9_DoOnLifecycle {
    public static void main(String[] args) {
        /**
         * 在回调 onSubscribe 之前回调该方法的第一个参数的回调方法，可以使用该回调方法决定是否取消订阅。
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).doOnLifecycle(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                log.info("==================doOnLifecycle accept");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                log.info("==================doOnLifecycle Action");
            }
        }).doOnDispose(
                        new Action() {
                            @Override
                            public void run() throws Exception {
                                log.info("==================doOnDispose Action");
                            }
                        })
                .subscribe(new Observer<Integer>() {
                    private Disposable d;

                    @Override
                    public void onSubscribe(Disposable d) {
                        log.info("==================onSubscribe ");
                        this.d = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        log.info("==================onNext " + integer);
                        d.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        log.info("==================onError ");
                    }

                    @Override
                    public void onComplete() {
                        log.info("==================onComplete ");
                    }

                });
    }
}
