package fr.afcepf.al28.tp8;

public class MyArithmeticException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyArithmeticException() {
	}

	public MyArithmeticException(String message) {
		super(message);
	}

	public MyArithmeticException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MyArithmeticException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyArithmeticException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
