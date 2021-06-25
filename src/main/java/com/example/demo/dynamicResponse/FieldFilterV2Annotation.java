package com.example.demo.dynamicResponse;

import java.lang.annotation.*;

/**
 * Created by Peiyao.Wang on 2021/3/29
 *
 * @author Peiyao.Wang
 * @date 2021/3/29
 * @Description TODO
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldFilterV2Annotation {
    //想要保留的字段，用逗号分隔
    String include() default "";

    //想要过滤的字段，用逗号分隔
    String exclude() default "";

    //返回到前端数据类型 这里使用JSONObject 如果是纯集合可以使用JSONArray
    Class classez() default CommonResponse.class;
}
