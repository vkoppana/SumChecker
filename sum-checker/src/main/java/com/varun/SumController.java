package com.varun;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;  

@RestController  
public class SumController {
	
	@Autowired
	CalculateService calService;
	
	@Autowired
	QuestionService queService;
	 
	 
	 @RequestMapping(value ="/", method = RequestMethod.POST, headers = "Accept=application/json")  
	    public ResponseEntity<String> verifySumService(@RequestBody Message msg ,HttpServletRequest request){  
		 	
		 	if(msg.getServiceNum().equals("Service 1"))
		 	{
		 		String question = queService.setNewQuestion();
		 		
		 		return new ResponseEntity<String>(question,HttpStatus.OK);
		 	}
		 
		 	if(msg.getServiceNum().equals("Service 2"))
		 	{
		 		String calMsg = calService.calculateSum(msg.msg,queService);
		 		
		 		if(calMsg == "VerifiedSum")
		 			return new ResponseEntity<String>("That’s great",HttpStatus.OK);
		 		else if(calMsg == "Response Numbers Changed")
		 			return new ResponseEntity<String>("Response Numbers Changed",HttpStatus.BAD_REQUEST);
		 		else if(calMsg == "WrongSum")
		 			return new ResponseEntity<String>("That’s wrong. Please try again.",HttpStatus.BAD_REQUEST);
		 	}  
		 	
		 	return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
	    }  
	 
	
}
