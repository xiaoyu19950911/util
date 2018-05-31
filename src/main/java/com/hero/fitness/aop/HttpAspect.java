package com.hero.fitness.aop;

import com.hero.fitness.enums.ResultEnums;
import com.hero.fitness.utils.ResultUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/2 9:17
 * @Modified By:
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("@annotation(com.hero.fitness.annotation.RequestValid)")
    public void log() {

    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("url={}", request.getRequestURI());

        LOGGER.info("method={}", request.getMethod());

        LOGGER.info("ip={}", request.getRemoteAddr());

        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        LOGGER.info("args={}", joinPoint.getArgs());
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        if (joinPoint.getArgs().length > 0) {
            for (Object arg : joinPoint.getArgs()) {
                if (arg instanceof BindingResult) {
                    BindingResult bindingResult = (BindingResult) arg;
                    StringBuilder str=new StringBuilder();
                    if(bindingResult.hasErrors()){
                        bindingResult.getAllErrors().forEach(error->{
                            str.append(error.getDefaultMessage());
                            str.append("\n");
                        });
                        return ResultUtils.error(ResultEnums.PARAMETERS_ERROR.getCode(),str.toString());
                    }
                }
            }
        }
        Object result=joinPoint.proceed();
        return result;
    }
}
