package com.ppu.taxi.ws.exception;

/**
 *
 */
public class LoginFailedException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginFailedException(Throwable ex) {
        super(ex);
    }
    public LoginFailedException(String s) {
        super(s);
    }
}
