package com.notfound.crm.common.validator;

import com.notfound.crm.common.base.Constant;
import com.notfound.crm.common.exception.SystemException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Description: 这里是对字段进行校验的校验器工具类
 */
public class ValidatorUtil {

    static final Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static void validator (Object object){
        //验证信息存储到set集合中，如果验证通过集合为空，如果验证不通过则集合不为空
        Set<ConstraintViolation<Object>> validate = validator.validate(object);
            //集合为空则不执行for语句，不为空则执行for语句，并抛出异常
        System.out.println(validate);
        for (ConstraintViolation<Object> constraintViolation : validate) {
            //校验不通过信息
            String message = constraintViolation.getMessage();
            //校验不通过时抛出异常
            System.out.println(message);
            throw new SystemException(Constant.FORM_DATA_CHECK_ERROR_CODE, message);
        }
    }
}
