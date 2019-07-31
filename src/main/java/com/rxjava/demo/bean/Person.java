package com.rxjava.demo.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2019-07-31
 * Time: 11:04
 */
@Data
public class Person {
    private String name;
    private List<Plan> planList = new ArrayList<>();

}
