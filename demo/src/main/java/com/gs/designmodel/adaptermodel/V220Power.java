package com.gs.designmodel.adaptermodel;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Gaos
 * @Date: 2023-01-11 16:37
 *
 * 现在拥有的其实是220v的家用电
 **/
@Slf4j
public class V220Power {
    /**
     *
     */
    public int provide220Power() {
      log.info("我提供220v家用电");
      return 220;
    }
}
