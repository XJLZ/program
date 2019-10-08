package com.domain;

import com.service.AccountService;

import java.util.*;

public class bean3 {

    private String[] Strs;
    private List<String> lists;
    private Set<String> sets;
    private Map<String,String> maps;
    private Properties prop;
    public void setStrs(String[] strs) {
        Strs = strs;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(Strs));
        System.out.println(lists);
        System.out.println(sets);
        System.out.println(maps);
        System.out.println(prop);
    }

}
