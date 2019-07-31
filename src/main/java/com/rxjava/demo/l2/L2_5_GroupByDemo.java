package com.rxjava.demo.l2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-31
 * Time: 14:12
 */
@Slf4j
public class L2_5_GroupByDemo {
    public static void main(String[] args) {
        /**
         * 1、将发送的数据进行分组，每个分组都会返回一个被观察者。
         * 2、以下的代码就是将1~10的数据分成3组
         */
        Observable.just(1 ,2, 3, 4, 5, 6, 7, 8, 9, 10)
                .groupBy(new Function<Integer, Integer>() {//返回分组名

                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer % 3;//将1~10的数据分成3组
                    }
                }).subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                integerIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        log.info("groupName = [{}], value = [{}]",integerIntegerGroupedObservable.getKey(), integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
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
