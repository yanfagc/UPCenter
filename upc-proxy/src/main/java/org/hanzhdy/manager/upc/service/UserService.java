package org.hanzhdy.manager.upc.service;

import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.mapper.UserBasicMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 * Created by H.CAAHN on 2017/12/8.
 */
@Service
public class UserService extends AbstractUpcService {
    @Autowired
    private UserBasicMapperExt userBasicMapperExt;
    
    
}
