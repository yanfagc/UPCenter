package com.postbox.service;

import com.postbox.mapper.ExpressmanInfoMapperExt;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 快递员Service
 * Created by H.CAAHN on 2017/7/21.
 */
@Service
public class ExpressmanInfoService extends AbstractUpcService {
    @Autowired
    private ExpressmanInfoMapperExt expressmanInfoMapperExt;
    
    
}
