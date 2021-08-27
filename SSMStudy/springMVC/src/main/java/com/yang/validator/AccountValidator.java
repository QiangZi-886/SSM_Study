package com.yang.validator;

import com.yang.entity.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//Accout验证器
public class AccountValidator implements Validator {
    //在数据验证之前会首先对传入的类型进行验证，如果类型相同才会进行下一步，如果类型不同，那么就不往下继续走
    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.equals(aClass);//aClass就是传入的类型，将其与Account的类型比对
    }

    @Override
    public void validate(Object o, Errors errors) {
        //使用ValidationUtils工具类，将错误信息封装进error
        ValidationUtils.rejectIfEmpty(errors,"name",null,"姓名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"password",null,"密码不能为空");
    }
}
