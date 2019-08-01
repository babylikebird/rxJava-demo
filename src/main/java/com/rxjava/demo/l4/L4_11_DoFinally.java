package com.rxjava.demo.l4;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 14:04
 */
@Slf4j
public class L4_11_DoFinally {

    public static void main(String[] args) {
        /**
         * 1、在所有事件发送完毕之后回调该方法。
         * 2、doFinally() 和 doAfterTerminate() 到底有什么区别？
         * 区别就是在于取消订阅，如果取消订阅之后 doAfterTerminate() 就不会被回调，
         * 而 doFinally() 无论怎么样都会被回调，且都会在事件序列的最后。
         */
        Observable.just(1, 2, 3)
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        log.info("doFinally");
                    }
                }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                log.info("doOnDispose");
            }
        }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                log.info("doAfterTerminate");
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe");
                disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                log.info("onNext : {}", integer);
                disposable.dispose();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                log.info("onComplete");
            }
        });
    }
}
