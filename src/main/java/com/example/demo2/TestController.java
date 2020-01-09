package com.example.demo2;

import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo2.Coin;
import com.example.demo2.result;


@RestController
public class TestController {
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/list")
	public List<Coin> index() {
		
		return jdbc.query("select * from coin", (resultSet, i) -> {
	          return toCoin(resultSet);
	      });
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/change/{idInput}/{mount}/{idOutput}")
	public result index(@PathVariable("idInput") String idInput, 
			@PathVariable("mount") String mount, 
			@PathVariable("idOutput") String idOutput) {
		
		
		Coin input = jdbc.query("select * from coin where id = "+idInput, (resultSet, i) -> {
	          return toCoin(resultSet);
	      }).get(0); 
		
		Coin output = jdbc.query("select * from coin where id = "+idOutput, (resultSet, i) -> {
	          return toCoin(resultSet);
	      }).get(0);
		
		float money = Float.parseFloat(mount)*Float.parseFloat(input.getValue())/Float.parseFloat(output.getValue());
		float change = money/Float.parseFloat(mount);
		
		result res = new result();
		res.setChange(change);
		res.setMoney(money);
								
		return res;
	}
	
	
	@RequestMapping("/insert")
	  public String insert() {
				
		try {
			
			jdbc.execute("insert into coin(name , value) VALUES('carlos','30')");
			
		}catch (Exception e) {
			 e.printStackTrace();
		}
		
		
	    return "Greetings from Spring Boot!";
	  }
	
	
	private Coin toCoin(ResultSet resultSet) throws SQLException {
	      Coin coin = new Coin();
	      coin.setId(resultSet.getLong("ID"));
	      coin.setName(resultSet.getString("NAME"));
	      coin.setValue(resultSet.getString("VALUE"));
	      
	      return coin;
	  }
	
	
	
	
}
