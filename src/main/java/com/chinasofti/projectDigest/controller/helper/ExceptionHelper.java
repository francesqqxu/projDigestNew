package com.chinasofti.projectDigest.controller.helper;

import org.slf4j.Logger;

import com.chinasofti.projectDigest.dto.RestResponseBo;
import com.chinasofti.projectDigest.exception.TipException;

 
public class ExceptionHelper {
	 /**
     * 统一处理异常
     *
     * @param logger
     * @param msg
     * @param e
     * @return
     */
	
	public static RestResponseBo handlerException(Logger logger, String msg, Exception e) {
        if (e instanceof TipException) {
            msg = msg + "," +  e.getMessage();
        } else {
            logger.error(msg, e);
        }
        return RestResponseBo.fail(msg);
    }

}
