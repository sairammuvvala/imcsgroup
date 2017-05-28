package employeeController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Service.AirlineServiceInterface;
import entities.Flight;



@RestController
@RequestMapping("/flight")
public class AirlineController {
	
	@Autowired
	AirlineServiceInterface airlineService;
	
	
	
	@RequestMapping(value="/{flightid}", method=RequestMethod.GET)
	public ResponseEntity<?> getFlight(@PathVariable String flight_Id) {
		Flight flight = null;
		try {
			try {
				flight = airlineService.findFlight(Integer.parseInt(flight_Id));
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		if (flight == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(flight, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes={"application/json"})
	public ResponseEntity<?> createFlight(@RequestBody Flight flight) {
	
		try {
			 airlineService.createFlight(flight);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(flight, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/{flight_id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteDepartment(@PathVariable String flight_id) throws SQLException {
		boolean flag=false;
		try {
			flag = airlineService.deleteFlight(Integer.parseInt(flight_id));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		if (flag == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, consumes={"application/json"})
	public ResponseEntity<?> updateDepartment(@RequestBody Flight flight) {
		try {
			boolean  flag = airlineService.updateFlight(flight);
			
			if (flag == false) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(flight, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
