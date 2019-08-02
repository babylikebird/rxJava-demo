package com.rxjava.demo.l5;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-08-02
 * Time: 14:40
 */
@Slf4j
public class L5_4_Distinct {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4,2, 3, 4)
        .distinct(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "A:"+integer;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                log.info("accept : {}", integer);
            }
        });
    }
}
