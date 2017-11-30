package com.mimidai.utils;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by zhangyu on 2017/8/9.
 */
public class TestTransitDemo implements Serializable {


    private static final long serialVersionUID = 1l;
    private transient String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException,
            ClassNotFoundException {
        LinkedList linkedList = Lists.newLinkedList();
        linkedList.addFirst("aa");
        linkedList.add("bb");
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.getFirst());
    }
}
