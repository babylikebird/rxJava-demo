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
 * Time: 10:37
 */
@Slf4j
public class L3_6_CombineLatestDemo {
    public static void main(String[] args) {
        /**
         * 1、combineLatest() 的作用与 zip() 类似，
         * 但是 combineLatest() 发送事件的序列是与发送的时间线有关的
         * ，当 combineLatest() 中所有的 Observable 都发送了事件，
         * 只要其中有一个 Observable 发送事件，这个事件就会和其他 Observable 最近发送的事件结合起来发送，
         * 2、下列示例，Observable A 会每隔1秒就发送一次事件，Observable B 会隔2秒发送一次事件。来看看打印结果：
         * 当 B 发送了 B1 事件之后，就会与 A 最近发送的事件 A2 结合成 A2B1，这样只有后面一有被观察者发送事件，这个事件就会与其他被观察者最近发送的事件结合起来了。
         * 因为 combineLatestDelayError() 就是多了延迟发送 onError() 功能，这里就不再赘述了。
         */
        Observable.combineLatest(
                Observable.intervalRange(1, 4, 1, 1, TimeUnit.SECONDS)
                        .map(new Function< Long, String >() {@Override
                        public String apply(Long aLong) throws Exception {
                            String s1 = "A" + aLong;
                            log.info("===================A 发送的事件 " + s1);
                            return s1;
                        }
                        }),
                Observable.intervalRange(1, 5, 2, 2, TimeUnit.SECONDS)
                        .map(new Function < Long, String > () {@Override
                        public String apply(Long aLong) throws Exception {
                            String s2 = "B" + aLong;
                            log.info("===================B 发送的事件 " + s2);
                            return s2;
                        }
                        }),
                new BiFunction< String, String, String >() {@Override
                public String apply(String s, String s2) throws Exception {
                    String res = s + s2;
                    return res;
                }
                })
                .subscribe(new Observer< String >() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        log.info( "===================onSubscribe ");
                    }

                    @Override
                    public void onNext(String s) {
                        log.info("===================最终接收到的事件 " + s);
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
