package com.kupreychik.consts;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RegexConsts {

    public static final String PHONE_REGEX = "/^(\\+\\d{1,3}[- ]?)?\\d{10}$/";

    public static final String DATE_FORMAT = "yyyy-MM-dd";
}
