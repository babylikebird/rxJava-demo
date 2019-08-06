package com.rxjava.demo.l6;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-06
 * Time: 10:08
 */
@Slf4j
public class L6_9_Amb {
    public static void main(String[] args) {

        /**
         * amb() 要传入一个 Observable 集合，但是只会发送最先发送事件的 Observable 中的事件，其余 Observable 将会被丢弃。
         */

        ArrayList<Observable< Long >> list = new ArrayList < > ();

        list.add(Observable.intervalRange(1, 5, 2, 1, TimeUnit.SECONDS));
        list.add(Observable.intervalRange(6, 5, 0, 1, TimeUnit.SECONDS));

        Observable.amb(list)
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
