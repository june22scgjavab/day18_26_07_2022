package com.infytraining.test;


import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.infytraining.exception.InfyTrainingException;
import com.infytraining.model.Trainee;
import com.infytraining.service.InfyTrainingService;
import com.infytraining.service.InfyTrainingServiceImpl;

public class InfyTrainingServiceTest {
// In the below testcase we first created an object of Trainee with invalid date
// With assertThrows we are getting an object of InfyTrainingException when infyTraineeService.addTrainee(trainee) is called inside assertThrows 
// With assertEqual we are checking the The string returned , The expected String is Validator.INVALID_DATEOFJOINING
	 private InfyTrainingService infyTrainingService= new InfyTrainingServiceImpl();
	
   @Test
	public void addTraineeInvalidDateOfJoiningTest() throws InfyTrainingException{
		Trainee trainee = new Trainee("John Paul",LocalDate.of(2021, 7, 14) ,"Passport","john_paul" ,9876340976L);
		InfyTrainingException exception=Assertions.assertThrows(InfyTrainingException.class,()->infyTrainingService.addTrainee(trainee));
        Assertions.assertEquals("Validator.INVALID_DATEOFJOINING", exception.getMessage());
	}
   @Test
	public void generateTraineeReportNoRecordsFoundTest() throws InfyTrainingException {
		
		InfyTrainingException exception=Assertions.assertThrows(InfyTrainingException.class,()->infyTrainingService.generateTraineeReport("abc"));
        Assertions.assertEquals("TraineeService.NO_RECORDS_FOUND", exception.getMessage());
		
	}
   
   @Test
   public void addTraineeInvalidContactNumberTest()
   {
	 Trainee trainee=new Trainee("Ashok Kumar",LocalDate.now(),"Passport","ashok_kumar",6666575788688688L);  
	 InfyTrainingException exception=Assertions.assertThrows(InfyTrainingException.class,()->infyTrainingService.addTrainee(trainee));
    Assertions.assertEquals("Validator.INVALID_CONTACTNUMBER", exception.getMessage());
   }
   
   @Test
   public void addTraineeInvalidProofIdTest()
   {
	 Trainee trainee=new Trainee("Ashok Kumar",LocalDate.now(),"xyzt","ashok_kumar",9832367890L);  
	 InfyTrainingException exception=Assertions.assertThrows(InfyTrainingException.class,()->infyTrainingService.addTrainee(trainee));
    Assertions.assertEquals("Validator.INVALID_IDPROOF", exception.getMessage());
   }
   
   
   
   @Test
   public void addTraineeInvalidDateTest()
   {
	 Trainee trainee=new Trainee("Ashok Kumar",LocalDate.of(2023,10,12),"Passport","ashok_kumar",9832367890L);  
	 InfyTrainingException exception=Assertions.assertThrows(InfyTrainingException.class,()->infyTrainingService.addTrainee(trainee));
    Assertions.assertEquals("Validator.INVALID_DATEOFJOINING", exception.getMessage());
   }
   
  //john_paul has been successfully registered for Infosys Training.

   @Test
   public void addTraineeValidTest() throws InfyTrainingException
   {
	 Trainee trainee=new Trainee("Ashok Kumar",LocalDate.of(2022,07,26),"Passport","ashok_kumar",9832367890L);  
	String actual=infyTrainingService.addTrainee(trainee);
	String expected="ashok_kumar";
    Assertions.assertEquals(expected, actual);
   }

}
