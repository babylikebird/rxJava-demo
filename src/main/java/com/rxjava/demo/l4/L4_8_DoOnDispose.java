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
 * Time: 11:39
 */
@Slf4j
public class L4_8_DoOnDispose {
    public static void main(String[] args) {
        /**
         * 当调用 Disposable 的 dispose() 之后回调该方法。
         */
        Observable.just(1, 2)
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        log.info("===========doOnDispose");
                    }
                }).subscribe(new Observer<Integer>() {
                    private Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                this.disposable = d;
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

            }
        });
    }
}
