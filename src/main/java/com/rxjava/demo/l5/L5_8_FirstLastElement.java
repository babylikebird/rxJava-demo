package com.rxjava.demo.l5;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 15:27
 */
@Slf4j
public class L5_8_FirstLastElement {
    public static void main(String[] args) {
        /**
         * firstElement() 取事件序列的第一个元素，lastElement() 取事件序列的最后一个元素。
         */
        Observable.just(1, 2, 3)
                .firstElement()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("first : {}",integer);
                    }
                });
        Observable.just(1, 2, 3)
                .lastElement()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("last : {}",integer);
                    }
                });
    }
}
