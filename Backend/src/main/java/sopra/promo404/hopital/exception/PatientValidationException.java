package sopra.promo404.hopital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "La matière n'a pu être validée")
public class PatientValidationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public PatientValidationException() {
		super();
	}

	public PatientValidationException(String message) {
		super(message);
	}


}
