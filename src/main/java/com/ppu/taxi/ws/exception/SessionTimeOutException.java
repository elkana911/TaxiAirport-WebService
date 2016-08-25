package com.ppu.taxi.ws.exception;

/**
 *
 */
public class SessionTimeOutException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SessionTimeOutException(Throwable ex) {
        super(ex);
    }
    public SessionTimeOutException(String s) {
        super(s);
    }
}
