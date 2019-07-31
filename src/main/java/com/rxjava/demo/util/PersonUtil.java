package com.rxjava.demo.util;

import com.rxjava.demo.bean.Person;
import com.rxjava.demo.bean.Plan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-31
 * Time: 11:20
 */
public class PersonUtil {
    public static List<Person> buildPerson(int size){
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < size; i++){
            Person person = new Person();
            person.setName("Name:" + i);
            List<Plan> planList = new ArrayList<>();
            for (int j = 0 ; j < 3; j++){
                Plan plan = new Plan();
                plan.setTime("Time : " + j);
                plan.setContent("content : " + j + "," + person.getName());
                List<String> action = new ArrayList<>();
                action.add("apple : "+ j + "," + person.getName());
                action.add("banana : "+ j + "," + person.getName());
                action.add("orange : "+ j + "," + person.getName());
                plan.setActionList(action);
                planList.add(plan);
            }
            person.setPlanList(planList);
            personList.add(person);
        }
        return personList;
    }
}
