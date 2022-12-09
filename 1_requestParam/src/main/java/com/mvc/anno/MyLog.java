package com.mvc.anno;


import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})//注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
@Documented
public @interface MyLog {
    String value() default "";//功能模块名称
    int type() default 1;//用户具体操作类型代表，0：登录；1：查询；2：新增；3：修改；import com.alibaba.fastjson.JSONObject;
}
