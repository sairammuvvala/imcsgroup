package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import trng.imcs.beans.Student;
import trng.imcs.beans.Address;
import trng.imcs.beans.Marks;

public class MarshellingApp {
	
	
	public static void main(String[] args) {
		
		
		Address address1=new Address();
		address1.setStreetNo(123);
		address1.setStreetName("mcArther");
		address1.setZipcode("75063");
		
		List<Address> address = new ArrayList<Address>();
			
		address.add(address1);
			
		Marks marks1=new Marks();		
		List<Marks> marks = new ArrayList<Marks>();
		marks.add(marks1);	
		marks1.setMaxMarks(100);
		  Student student = new Student(123,"Sai","Ram",address,marks );
		  try {

			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(student, file);
			jaxbMarshaller.marshal(student, System.out);

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }

		}


}
