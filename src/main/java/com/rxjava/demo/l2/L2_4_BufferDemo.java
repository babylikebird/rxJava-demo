package com.rxjava.demo.l2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-31
 * Time: 14:05
 */
@Slf4j
public class L2_4_BufferDemo {
    public static void main(String[] args) {
        /**
         * 1、 从需要发送的事件当中获取一定数量的事件，并将这些事件放到缓冲区当中一并发出。
         * 2、 buffer 有两个参数，一个是 count，另一个 skip。count 缓冲区元素的数量，skip 就代表缓冲区满了之后，发送下一次事件序列的时候要跳过多少元素。
         * 3、 从结果可以看出，每次发送事件，指针都会往后移动一个元素再取值，直到指针移动到没有元素的时候就会停止取值。
         * 4、 count = skip 最佳
         */
        Observable.just(1, 2 ,3 ,4 ,5)
                .buffer(2 , 1)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        log.info("缓冲区：{}", integers.size());
                        for (Integer i:integers
                             ) {
                            log.info("元素：{}",i);
                        }
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
