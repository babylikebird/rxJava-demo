package com.rxjava.demo.l4;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 17:30
 */
@Slf4j
public class L4_20_SubscribeOn {
    public static void main(String[] args) {
        /**
         * 1、指定被观察者的线程，要注意的时，如果多次调用此方法，只有第一次有效。
         * 2、Schedulers.computation( )	用于使用计算任务，如事件循环和回调处理
         * 3、Schedulers.immediate( )	当前线程
         * 4、Schedulers.io( )	用于 IO 密集型任务，如果异步阻塞 IO 操作。
         * 5、Schedulers.newThread( )	创建一个新的线程
         * 6、AndroidSchedulers.mainThread()	Android 的 UI 线程，用于操作 UI。
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                log.info("=========currentThread name:{}", Thread.currentThread().getName());
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("accept : {}", integer);
                    }
                });
        try {
            log.info("随便输入按回车退出............");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
