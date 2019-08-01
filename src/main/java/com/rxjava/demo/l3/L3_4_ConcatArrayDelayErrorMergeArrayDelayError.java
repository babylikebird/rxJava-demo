package com.rxjava.demo.l3;

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
 * Date: 2019-08-01
 * Time: 10:15
 */
@Slf4j
public class L3_4_ConcatArrayDelayErrorMergeArrayDelayError {
    public static void main(String[] args) {
        /**
         * 在 concatArray() 和 mergeArray() 两个方法当中，如果其中有一个被观察者发送了一个 Error 事件，那么就会停止发送事件，
         * 如果你想 onError() 事件延迟到所有被观察者都发送完事件后再执行的话，
         * 就可以使用  concatArrayDelayError() 和 mergeArrayDelayError()
         *
         */
        Observable.concatArrayDelayError(
                Observable.create(new ObservableOnSubscribe< Integer >() {
                    @Override
                    public void subscribe(ObservableEmitter< Integer > e) throws Exception {
                        e.onNext(1);
                        e.onError(new NumberFormatException());
                    }
                }), Observable.just(2, 3, 4))
                .subscribe(new Observer< Integer >() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        log.info( "===================onNext  {}" , integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        log.info("===================onError ");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
