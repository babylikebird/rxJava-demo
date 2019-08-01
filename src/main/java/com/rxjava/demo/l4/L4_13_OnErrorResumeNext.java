package com.rxjava.demo.l4;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 14:34
 */
@Slf4j
public class L4_13_OnErrorResumeNext {
    public static void main(String[] args) {
        /**
         * 1、当接收到 onError() 事件时，返回一个新的 Observable，并正常结束事件序列。
         * 2、 不会执行onError方法
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new Error("404"));
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> apply(Throwable throwable) throws Exception {
                log.error("exception",throwable);
                return Observable.just(6, 7, 8);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                log.info("onNext, {}", integer);
            }

            @Override
            public void onError(Throwable e) {
                log.error("onError");
            }

            @Override
            public void onComplete() {
                log.info("onComplete");
            }
        });
    }
}
