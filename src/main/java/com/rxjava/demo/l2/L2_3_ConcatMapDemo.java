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
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-31
 * Time: 14:02
 */
@Slf4j
public class L2_3_ConcatMapDemo {
    public static void main(String[] args) {
        /**
         * concatMap是有序的
         */
        List<Person> personList = PersonUtil.buildPerson(3);
        Observable.fromIterable(personList)
                .concatMap(new Function<Person, ObservableSource<Plan>>() {
                    @Override
                    public ObservableSource<Plan> apply(Person person) throws Exception {
                        if ("Name:1".equals(person.getName())){
                            return Observable.fromIterable(person.getPlanList()).delay(10, TimeUnit.MICROSECONDS);
                        }
                        return Observable.fromIterable(person.getPlanList());
                    }
                }).subscribe(new Observer<Plan>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Plan plan) {
                log.info("content : {}",plan.getContent());
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
