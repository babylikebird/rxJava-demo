package com.rxjava.demo.l1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-30
 * Time: 14:57
 */
@Slf4j
public class L1_3_3_FromFutureDemo {
    public static void main(String[] args) {
        /**
         * 参数中的 Future 是 java.util.concurrent 中的 Future，
         * Future 的作用是增加了 cancel() 等方法操作 Callable，
         * 它可以通过 get() 方法来获取 Callable 返回的值
         */
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello , future ";
            }
        });
        Observable.fromFuture(futureTask).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                futureTask.run();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                log.info("accept : {}", s);
            }
        });
    }
}
