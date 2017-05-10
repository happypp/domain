package com.imooc.service;

import com.imooc.dao.GirlRepository;
import com.imooc.entity.Girl;
import com.imooc.entity.Result;
import com.imooc.enums.GirlEnums;
import com.imooc.exception.GirlException;
import com.imooc.utlis.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pp on 2017/3/26.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTow(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBBBBBBBBBBBB");
        girlB.setAge(18);
        girlRepository.save(girlB);
    }



    public Result getGirlInfo(Integer id) throws Exception {
        Girl one = girlRepository.findOne(id);
        if(one != null){
            if(one.getAge() < 11 ){
                throw new GirlException(GirlEnums.PRIMARY_SCHOOL);
            }else if(one.getAge() > 10 && one.getAge() < 18){
                throw new GirlException(GirlEnums.MIDDLE_SCHOOL);
            }
            return ResultUtil.seccees(one);
        }else {
            throw new Exception("查询的数据为空");
        }
    }

}
