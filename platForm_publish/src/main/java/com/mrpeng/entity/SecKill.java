package com.mrpeng.entity;


import java.util.Date;

/**
 * Description: 秒杀数据表对应的实体类(商品对象)
 *
 * Created by pp on 2017/5/9.
 */
public class SecKill {

    private int seckillId;         // 秒杀的id编号
    private String name;            // 秒杀系统的商品名称
    private int number;             // 表示的是商品的库存
    private Date startTime;        // 秒杀的开始时间
    private Date endTime;          // 秒杀活动的结束时间
    private Date createTime;       // 秒杀活动的创建时间

    public int getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(int seckillId) {
        this.seckillId = seckillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SecKill{" +
                "seckillId=" + seckillId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}
