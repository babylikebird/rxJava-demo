package com.rxjava.demo.l2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-31
 * Time: 14:35
 */
@Slf4j
public class L2_7_WindowDemo {
    public static void main(String[] args) {
        /**
         * 发送指定数量的事件时，就将这些事件分为一组。window 中的 count 的参数就是代表指定的数量，
         * 例如将 count 指定为2，那么每发2个数据就会将这2个数据分成一组。
         */
        Observable.just(1, 2, 3, 4, 5)
                .window(2)
                .subscribe(new Observer<Observable<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        log.info("=========onSubscribe");
                    }

                    @Override
                    public void onNext(Observable<Integer> integerObservable) {
                        log.info("=========onNext");
                        integerObservable.subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                log.info("-----------onSubscribe");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                log.info("-----------onNext , {}", integer);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                log.info("-----------onComplete");
                            }
                        });
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
