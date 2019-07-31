package com.rxjava.demo.l1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-30
 * Time: 16:38
 */
@Slf4j
public class L1_10_ENE {
    public static void main(String[] args) {
        /**
         * empty() ： 直接发送 onComplete() 事件
         * never()：不发送任何事件
         * error()：发送 onError() 事件
         */
        Observable.empty()
                .subscribe(new Observer< Object >() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        log.info("onSubscribe");
                    }

                    @Override
                    public void onNext(Object o) {
                        log.info("onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        log.info("onError");
                    }

                    @Override
                    public void onComplete() {
                        log.info("onComplete");
                    }
                });
    }
}
