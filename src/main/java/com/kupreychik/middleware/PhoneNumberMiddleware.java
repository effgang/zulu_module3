package com.kupreychik.middleware;

import com.kupreychik.consts.RegexConsts;
import com.kupreychik.dto.request.abstracts.AbstractRequest;
import com.kupreychik.model.AbstractModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhoneNumberMiddleware extends Middleware {

    public boolean check(AbstractRequest model) {
        log.debug("Выполняется проверка номера телефона");
        if (model.getPhoneNumber().matches(RegexConsts.PHONE_REGEX)) {
            log.debug("Проверка пройдена. Телефон подходит");
            return checkNext(model);
        } else {
            log.debug("Проверка не пройдена");
            return false;
        }
    }
}