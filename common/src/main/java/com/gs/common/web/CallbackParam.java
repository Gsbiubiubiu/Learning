package com.gs.common.web;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @User远
 * @Date2022/4/7
 */
@Setter
@Getter
public class CallbackParam implements Serializable {

    private static final long serialVersionUID = 4064118805074330001L;
    private String callback;
    private String scriptWrapping;

}
