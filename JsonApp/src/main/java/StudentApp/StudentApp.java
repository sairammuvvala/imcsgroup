package StudentApp;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import studentPojos.Address;
import studentPojos.Marks;
import studentPojos.Student;

public class StudentApp {

	public static void main(String[] args) throws JsonParseException, IOException {
		StudentApp json  = new StudentApp();
        json.marshalling();
        json.unmarshalling();
            
        
    }
	
	private void unmarshalling() throws IOException {
	
		byte[] jsonData = Files.readAllBytes(Paths.get("C:\\Users\\sairam\\workspace\\JsonApp\\src\\main\\resources\\Student.json"));
		ObjectMapper objectMapper = new ObjectMapper();
		Student student = objectMapper.readValue(jsonData, Student.class);
		
		System.out.println(student);	
	}

	public void marshalling() throws JsonGenerationException, JsonMappingException, IOException{
		Address address1 = new Address();
        address1.setStreet("MacArthur");
        address1.setCity("DALLAS");
        address1.setState("TX");
        Address address2 = new Address();
        address2.setStreet("RanchView");
        address2.setCity("IRVING");
        address2.setState("TX");
        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address1);
        addressList.add(address2);
        Marks subject1 = new Marks("MATHS",78.0);
        Marks subject2 = new Marks("ENGLISH",90);
        List<Marks> marksList = new ArrayList<Marks>();
        marksList.add(subject1);
        marksList.add(subject2);
        Student student = new Student("Sairam",addressList,marksList);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, student);
        System.out.println("Student JSON is\n"+stringEmp);	
	}    
}

