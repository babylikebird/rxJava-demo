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
 * Time: 17:10
 */
@Slf4j
public class L4_19_RepeatWhen {
    public static void main(String[] args) {
        /**
         * 1、这个方法可以会返回一个新的被观察者设定一定逻辑来决定是否重复发送事件。
         * 2、这里分三种情况，如果新的被观察者返回 onComplete 或者 onError 事件，则旧的被观察者不会继续发送事件。
         *    如果被观察者返回其他事件，则会重复发送事件。
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
//                return Observable.empty();
//                return Observable.error(new Exception("404"));
                return Observable.just(4);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                log.info("onNext:{}",integer);
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
