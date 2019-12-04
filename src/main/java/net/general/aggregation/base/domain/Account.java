package net.general.aggregation.base.domain;

import java.util.Date;

public class Account {
    private Integer id;

    private String name;

    private Long money;

    private String dateflag;

    private Date dateggg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getDateflag() {
        return dateflag;
    }

    public void setDateflag(String dateflag) {
        this.dateflag = dateflag == null ? null : dateflag.trim();
    }

    public Date getDateggg() {
        return dateggg;
    }

    public void setDateggg(Date dateggg) {
        this.dateggg = dateggg;
    }
}