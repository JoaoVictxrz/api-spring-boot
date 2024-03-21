import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.portfolio.users.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public void resourceNotFound<StandartError>( String ResourceNotFoundException) { 
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", e.getMessage(), "");
		return ResponseEntity.status(Https.NOT_FOUND).body(error)
	}
}
