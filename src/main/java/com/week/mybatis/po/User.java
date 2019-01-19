package com.week.mybatis.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author week
 * @Title: User
 * @ProjectName mavenmybatis
 * @Description: 实现了序列化接口是为了测试二级缓存
 * @date 2019/1/1214:45
 */
public class User  implements Serializable {
    /**
     * 属性名和数据库表的字段对应
     * id
     * 用户姓名
     * 性别
     * 生日
     * 地址
     */
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
    private List<Orders> ordersList;

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
