package com.ming.admin.service;

import com.ming.admin.controller.system.upms.LogInController;
import com.ming.common.utils.JSONUtils;
import com.ming.upms.system.domain.UpmsDictDataDO;
import com.ming.upms.system.service.UpmsDictDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jie_ming514
 */
@Service("dict")
public class DictService {

    private static final Logger logger = LoggerFactory.getLogger(LogInController.class);

    @Autowired
    private UpmsDictDataService upmsDictDataService;

    /**
     * 通过Type获取明细
     * @param type
     * @return
     */
    public String getType(String type) {
        List<UpmsDictDataDO> resultList = upmsDictDataService.getType(type);
        logger.info(JSONUtils.beanToJson(resultList));
        return JSONUtils.beanToJson(resultList);
    }


}
