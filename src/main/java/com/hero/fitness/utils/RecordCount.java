package com.hero.fitness.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: rry
 * @description:
 * @author: XiaoYu
 * @create: 2018-04-27 20:30
 **/

public class RecordCount implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -435328320159692760L;

    private int startCount;//当前页码

    private int pageSize;//每页大小

    private int totalPageCount;//总页码

    private long totalCount;//总条数

    private int numberOfElements;//当前页数据量


    public RecordCount() {}

    /**
     * Constructor.
     * @param start the starting count.
     * @param pageSize the maximum record count.
     * @param total the total record count.
     */
    public RecordCount(int start, int pageSize, long total, int totalPageCount, int numberOfElements)
    {
        this.startCount=start+1;
        this.pageSize = pageSize;
        this.totalCount = total;
        this.totalPageCount=totalPageCount;
        this.numberOfElements=numberOfElements;
    }

    /**
     * Constructor.
     * @param rc the record count.
     */
    public RecordCount(RecordCount rc)
    {
        this(rc.getStartCount(), rc.getPageSize(), rc.getTotalCount(),rc.getTotalPageCount(),rc.getNumberOfElements());
    }

    public int getStartCount()
    {
        return startCount;
    }

    public void setStartCount(int startCount)
    {
        this.startCount = startCount;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getTotalPageCount()
    {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount)
    {
        this.totalPageCount = totalPageCount;
    }

    public long getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }

    public int getNumberOfElements()
    {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements)
    {
        this.numberOfElements = numberOfElements;
    }
    
    
}
