package com.rxjava.demo.l4;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 14:09
 */
@Slf4j
public class L4_12_OnErrorReturn {
    public static void main(String[] args) {
        /**
         * 当接受到一个 onError() 事件之后回调，返回的值会回调 onNext() 方法，并正常结束该事件序列。
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new NullPointerException());
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onComplete();
            }
        }).onErrorReturn(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) throws Exception {
                log.error("........onErrorReturn");
                return 404;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("........onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                log.info("........onNext: {}", integer);
            }

            @Override
            public void onError(Throwable e) {
                log.error("........onError");
            }

            @Override
            public void onComplete() {
                log.info("........onComplete");
            }
        });
    }
}
