package com.mrpeng.dao;

import com.mrpeng.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Description: 秒杀成功的明细DAO
 *
 * Created by pp on 2017/5/9.
 */
public interface SuccessKilledDAO {
    /**
     * 插入购买明细,可以过滤重复.
     * seckillId 秒杀成功的id编号
     * userphone 表示的是用户的联系方式
     * */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);


    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * long seckillId: 表示的是秒杀成功的明细id编号,id编号和phone能够唯一确定一条记录.
     * */
    SuccessKilled queryByIdWithSecKill(@Param("seckillId") long seckillId,
                                       @Param("userPhone") long userPhone);

}
