package com.rxjava.demo.l0;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-30
 * Time: 14:25
 */
@Slf4j
public class L0Demo {
    public static void main(final String[] args) {
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                log.info("=========================currentThread name: {}" , Thread.currentThread().getName());
                observableEmitter.onNext(1);
                observableEmitter.onNext(2);
                observableEmitter.onError(new Throwable("null point"));
                observableEmitter.onNext(3);
                observableEmitter.onComplete();
            }
        });
        Observer observer = new Observer<Integer>(){
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe............");
            }

            public void onNext(Integer integer) {
                log.info("onNext............:{}", integer);
            }

            public void onError(Throwable e) {
                log.error("onError............:",e);
            }

            public void onComplete() {
                log.info("onComplete..........");
            }
        };
        observable.subscribe(observer);
    }
}
