package com.rxjava.demo.l3;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 9:11
 */
@Slf4j
public class L3_1_ConcatDemo {
    public static void main(String[] args) {
        /**
         * 1、可以将多个观察者组合在一起，然后按照之前发送顺序发送事件。
         * 2、需要注意的是，concat() 最多只可以发送4个事件。
         */
        Observable.concat(Observable.just(1, 2),
                Observable.just(3, 4),
                Observable.just(5, 6),
                Observable.just(7, 8))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        log.info("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        log.info("onNext : {}", integer);
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
