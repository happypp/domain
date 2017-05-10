package com.imooc.dao;

import com.imooc.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pp on 2017/3/25.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    /**
     * 通过年龄来查询女生
     * @return
     * @throws Exception
     */
    public List<Girl> findGirlsByAge(Integer age) throws Exception;

}
