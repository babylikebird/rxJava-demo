package com.rxjava.demo.l6;

import io.reactivex.Observable;
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
 * Date: 2019-08-06
 * Time: 9:50
 */
@Slf4j
public class L6_5_SkipUntil {
    public static void main(String[] args) {
        /**
         * 当 skipUntil() 中的 Observable 发送事件了，原来的 Observable 才会发送事件给观察者。
         */
        Observable.intervalRange(1, 5, 0, 1, TimeUnit.SECONDS)
                .skipUntil(Observable.intervalRange(6, 5,3, 1, TimeUnit.SECONDS))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        log.info("accept : {}", aLong);
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
