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
public class Plan {
    private String time;
    private String content;
    private List<String> actionList = new ArrayList<>();

}
