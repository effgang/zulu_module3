package com.kupreychik.middleware;

import com.kupreychik.dto.request.abstracts.AbstractRequest;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.kupreychik.consts.RegexConsts.DATE_FORMAT;

@Slf4j
public class BirthDateMiddleware extends Middleware {
    @Override
    public boolean check(AbstractRequest model) {
        try {
            LocalDateTime.parse(model.getBirthDate(), DateTimeFormatter.ofPattern(DATE_FORMAT));
            return checkNext(model);
        } catch (DateTimeParseException dateTimeParseException) {
            log.debug("Неверный формат даты, проверьте вашу дату");
            return false;
        }
    }
}
