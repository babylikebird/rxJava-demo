package com.rxjava.demo.l5;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 15:30
 */
@Slf4j
public class L5_9_ElementAtOrError {
    public static void main(String[] args) {
        /**
         * elementAt() 可以指定取出事件序列中事件，
         * 但是输入的 index 超出事件序列的总数的话就不会出现任何结果。
         * 这种情况下，你想发出异常信息的话就用 elementAtOrError() 。
         */
        Observable.just(1, 2, 3, 4)
                .elementAtOrError(6)
                .subscribe(new Consumer< Integer >() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        log.info("====================accept {}" , integer);
                    }
                });
    }
}
