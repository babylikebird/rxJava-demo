package com.rxjava.demo.l3;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-01
 * Time: 10:28
 */
@Slf4j
public class L3_5_ZipDemo {
    public static void main(String[] args) {
        /**
         * 1、会将多个被观察者合并，根据各个被观察者发送事件的顺序一个个结合起来，最终发送的事件数量会与源 Observable 中最少事件的数量一样。
         * 2、上面代码中有两个 Observable，第一个发送事件的数量为5个，第二个发送事件的数量为6个。现在来看下打印结果：
         * 3、可以发现最终接收到的事件数量是5，那么为什么第二个 Observable 没有发送第6个事件呢？因为在这之前第一个 Observable 已经发送了 onComplete 事件，所以第二个 Observable 不会再发送事件。
         */
        Observable.zip(Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS)
                        .map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                String s1 = "A" + aLong;
                                log.info( "===================A 发送的事件 " + s1);
                                return s1;
                            }}),
                Observable.intervalRange(1, 6, 1, 1, TimeUnit.SECONDS)
                        .map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                String s2 = "B" + aLong;
                                log.info("===================B 发送的事件 " + s2);
                                return s2;
                            }
                        }),
                new BiFunction<String, String, String>() {
                    @Override
                    public String apply(String s, String s2) throws Exception {
                        String res = s + s2;
                        return res;
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        log.info("===================onSubscribe ");
                    }

                    @Override
                    public void onNext(String s) {
                        log.info("===================onNext " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        log.info("===================onError ");
                    }

                    @Override
                    public void onComplete() {
                        log.info("===================onComplete ");
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
