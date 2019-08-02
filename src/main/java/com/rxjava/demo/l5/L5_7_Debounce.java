package com.rxjava.demo.l5;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 15:09
 */
@Slf4j
public class L5_7_Debounce {
    public static void main(String[] args) {
        /**
         * 1、如果两件事件发送的时间间隔小于设定的时间间隔则前一件事件就不会发送给观察者。
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                Thread.sleep(900);
                emitter.onNext(3);
            }
        }).debounce(1,TimeUnit.SECONDS).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                log.info("accept: {}", integer);
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
