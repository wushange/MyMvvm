package com.connxun.morui.model.remote.exception;

/**
 * @author wushange
 * @date 2017/12/5
 */

public final class EmptyException extends Exception {
    public EmptyException(int emptyType) {
        super("empty");
    }
}
