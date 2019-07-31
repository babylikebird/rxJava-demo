package com.rxjava.demo.l2;

import com.rxjava.demo.bean.Person;
import com.rxjava.demo.bean.Plan;
import com.rxjava.demo.util.PersonUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-31
 * Time: 10:54
 */
@Slf4j
public class L2_1_MapDemo_1 {
    public static void main(String[] args) {
        //将 Person 集合中的每个元素中的 Plan 的 action 打印出来
        List<Person> personList = PersonUtil.buildPerson(3);
        Observable.fromIterable(personList)
                .map(new Function<Person, List<Plan>>() {
                    @Override
                    public List<Plan> apply(Person person) throws Exception {
                        return person.getPlanList();
                    }
                }).subscribe(new Observer<List<Plan>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Plan> plans) {
                for (Plan plan: plans) {
                    List < String > planActionList = plan.getActionList();
                    for (String action: planActionList) {
                        log.info("action is [{}]",action);
                    }
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
