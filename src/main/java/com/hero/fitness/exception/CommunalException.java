package com.hero.fitness.exception;


import com.hero.fitness.enums.ResultEnums;
import lombok.Data;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/2 10:13
 * @Modified By:
 */
public class CommunalException extends RuntimeException{

    private Integer code;

    public CommunalException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code=resultEnums.getCode();
    }

    public CommunalException(Integer code,String msg){
        super(msg);
        this.code=code;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }
    
    

}
