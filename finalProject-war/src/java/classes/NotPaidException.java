package classes;




public class NotPaidException extends Exception{

	@Override
	public String getMessage() {
		return "Two treatments have not yet been paid and no treatment can be added";
	}
	


}
