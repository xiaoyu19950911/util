package com.hero.fitness.utils;

import lombok.Data;

import java.util.List;

/**
 * @program: rry
 * @description:
 * @author: XiaoYu
 * @create: 2018-05-02 11:01
 **/
public class ListResponse<T> extends RecordCount {

    private List<T> value;//列表内容

    public ListResponse(int start, int pageSize, long total, int totalPageCount, int numberOfElements) {
        super(start, pageSize, total, totalPageCount,numberOfElements);
    }

    public List<T> getValue()
    {
        return value;
    }

    public void setValue(List<T> value)
    {
        this.value = value;
    }
    
    
}
