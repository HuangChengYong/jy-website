package com.jyinfo.jy_utils.TipException;

/**
 * UnauthorizedException
 *
 * @version 1.0
 * @since 2018/1/22
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
