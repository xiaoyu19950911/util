package com.hero.fitness.utils;

import org.springframework.data.domain.Page;

/**
 * @program: rry
 * @description:
 * @author: XiaoYu
 * @create: 2018-05-02 11:31
 **/
public class PageUtil {

    public static ListResponse PageListToListResponse(Page pageList){
        ListResponse result=new ListResponse(pageList.getNumber(),pageList.getSize(),pageList.getTotalElements(),pageList.getTotalPages(),pageList.getNumberOfElements());
        result.setValue(pageList.getContent());
        return result;
    }
}
