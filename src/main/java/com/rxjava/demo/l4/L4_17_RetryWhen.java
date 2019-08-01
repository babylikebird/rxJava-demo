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
 * Time: 16:47
 */
@Slf4j
public class L4_17_RetryWhen {
    public static void main(String[] args) {
        /**
         * 1、当被观察者接收到异常或者错误事件时会回调该方法，这个方法会返回一个新的被观察者。
         * 如果返回的被观察者发送 Error 事件则之前的被观察者不会继续发送事件，
         * 如果发送正常事件则之前的被观察者会继续不断重试发送事件。
         * 2、下面实例404就不断发送事件、改为403就停止
         */
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("chan");
                emitter.onNext("ze");
                emitter.onNext("de");
                emitter.onError(new Exception("403"));//403
                emitter.onNext("ha");
                emitter.onComplete();
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        if (throwable.getLocalizedMessage().equals("404")){
                            return Observable.just("可以忽略的异常");
                        }else {
                            return Observable.error(new Throwable("终止啦"));
                        }
                    }
                });
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                log.info("onNext : {}", s);
            }

            @Override
            public void onError(Throwable e) {
                log.error("onError : {}", e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                log.info("onComplete");
            }
        });
    }
}
