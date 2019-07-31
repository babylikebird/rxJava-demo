package com.rxjava.demo.l1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-30
 * Time: 15:27
 */
@Slf4j
public class L1_3_4_FromIterable {
    public static void main(String[] args) {
        /**
         * 直接发送一个 List 集合数据给观察者
         */
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        Observable.fromIterable(list)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        log.info("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        log.info("onNext: {}", integer);
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
