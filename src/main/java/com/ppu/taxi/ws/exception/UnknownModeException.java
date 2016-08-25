/**
 * 
 */
package com.ppu.taxi.ws.exception;

public class UnknownModeException extends RuntimeException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Throwable t;
    protected String strErrorCode;

    public UnknownModeException() {
    }

    public UnknownModeException(String s) {
        super(s);
    }

    public UnknownModeException(String s, String errorcode) {
        super(s);
        this.strErrorCode = errorcode;
    }

    public UnknownModeException(String s, String errorcode, Throwable t) {
        super(s);
        this.strErrorCode = errorcode;
        this.t = t;
    }

    public String getThrowable() {
        return ("Received throwable with Message: "+ t.getMessage());
    }

    public String getErrorCode() {
        return strErrorCode;
    }

    public void setErrorCode(String errorcode) {
        this.strErrorCode = errorcode;
    }
}
