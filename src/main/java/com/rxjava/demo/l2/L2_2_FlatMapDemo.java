package com.rxjava.demo.l2;

import com.rxjava.demo.bean.Person;
import com.rxjava.demo.bean.Plan;
import com.rxjava.demo.util.PersonUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-31
 * Time: 11:22
 */
@Slf4j
public class L2_2_FlatMapDemo {
    public static void main(String[] args) {
        /**
         * 1 : flatMap这个方法可以将事件序列中的元素进行整合加工，返回一个新的被观察者。
         * 2 : flatMap() 其实与 map() 类似，但是 flatMap() 返回的是一个 Observerable。现在用一个例子来说明 flatMap() 的用法。
         * 3: flatMap 发送的事件是无序的
         */
        List<Person> personList = PersonUtil.buildPerson(3);
        Observable.fromIterable(personList)
                .flatMap(new Function<Person, ObservableSource<Plan>>() {
                    @Override
                    public ObservableSource<Plan> apply(Person person) throws Exception {
                        return Observable.fromIterable(person.getPlanList());
                    }
                })
                .flatMap(new Function< Plan, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Plan plan) throws Exception {
                        return Observable.fromIterable(plan.getActionList());
                    }
             }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                log.info("action is [{}]",s);
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
