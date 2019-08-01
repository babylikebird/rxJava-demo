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
 * Time: 16:04
 */
@Slf4j
public class L4_14_OnExceptionResumeNext {
    public static void main(String[] args) {
        /**
         * 与 onErrorResumeNext() 作用基本一致，但是这个方法只能捕捉 Exception。
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new NullPointerException("NUll POINT"));
            }
        }).onExceptionResumeNext(new Observable<Integer>() {
            @Override
            protected void subscribeActual(Observer<? super Integer> observer) {
                observer.onNext(666);
                observer.onComplete();
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
