package org.hanzhdy.api;

import org.hanzhdy.manager.support.constants.resp.RespCode;
import org.hanzhdy.web.controller.AbstractController;

/**
 * Created by H.CAAHN on 2017/6/27.
 */
public abstract class ApplicationController extends AbstractController {
    protected static final RespCode respCode     = RespCode.getInstance();
}
