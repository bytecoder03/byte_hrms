package com.byteCoder.hrms.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byteCoder.hrms.Dao.DaoOne;
import com.byteCoder.hrms.Dto.StudentDetails;



@RestController
public class Ctrl1
{
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(Ctrl1.class);  
	@Autowired
	DaoOne daofirst;
	
	@PostMapping("/do-registration")
	public Object doRegis(@RequestBody StudentDetails sobj) throws ClassNotFoundException, SQLException
	{
		/*
		 * System.out.println("inside doregis"); Statement
		 * st=DatabaseConnection.DBconnectore(); String
		 * str="insert into Student_Details values('"+sobj.getId()+"','"+sobj.getName()+
		 * "','"+sobj.getEmail()+"','"+sobj.getPass()+"')"; int
		 * row=st.executeUpdate(str); if(row>0) { System.out.println("Success"); } else
		 * { System.out.println("Failed"); }
		 */
		
		 logger.info("Hello world");
		StudentDetails sdobj=daofirst.save(sobj);
		if(sdobj != null)
		{
			return sdobj;
		}
		else
			return "registration failed";
		
		  
		
		
		
		
	}
	@PostMapping("/selectqr")
	public Object doSearch(@RequestParam("sid") int Id) throws ClassNotFoundException, SQLException 
	{
		/*
		 * Statement st=DatabaseConnection.DBconnectore(); String
		 * selectQuery="Select * from Student_Details where sid='"+sob.getId()+"'";
		 * ResultSet rs=st.executeQuery(selectQuery); while(rs.next()) { int id
		 * =rs.getInt("Sid"); String name=rs.getString("Sname"); String mail
		 * =rs.getString("Semail"); String pass=rs.getString("Spass");
		 * System.out.println(id+" "+name+" "+mail+" "+pass); sob.setId(id);
		 * sob.setName(name); sob.setEmail(mail); sob.setPass(pass);
		 * 
		 * } return sob;
		 */
		StudentDetails sobj=daofirst.findById(Id);
		if(sobj!=null)
		{
			return sobj;
		}
		else
		{
			return "no details found";
		}
		
	}
	@PostMapping("/select-query")
	public List doSearchAll() throws ClassNotFoundException, SQLException 
	{
		/*
		 * boolean b=DecoderCode.validToken(token); if(b==false) {
		 * System.out.println("Token exp"); } ArrayList al=new ArrayList(); Statement
		 * st=DatabaseConnection.DBconnectore(); String
		 * selectQuery="Select * from Student_Details "; ResultSet
		 * rs=st.executeQuery(selectQuery);
		 * 
		 * while(rs.next()) { StudentDetails sob=new StudentDetails(); int id
		 * =rs.getInt("Sid"); String name=rs.getString("Sname"); String mail
		 * =rs.getString("Semail"); String pass=rs.getString("Spass");
		 * System.out.println(id+" "+name+" "+mail+" "+pass); sob.setId(id);
		 * sob.setName(name); sob.setEmail(mail); sob.setPass(pass); al.add(sob); }
		 */
         List<StudentDetails> stList = new ArrayList<>();
		
        
		Iterable<StudentDetails> itr=daofirst.findAll();
				
		for(StudentDetails std :itr)
		{
			stList.add(std);
		}
		return stList;
	}
	@DeleteMapping("/delmap")
	public Object dodelete(@RequestParam("id") int id)
			//,@RequestHeader("token") String token
			 throws ClassNotFoundException, SQLException
	{/*
		boolean b=DecoderCode.validToken(token);
		if(b==false)
		{
			 return "token expired - please login again.";
		}
		Statement st=DatabaseConnection.DBconnectore();
		int row=st.executeUpdate("Delete from Student_Details where sid='"+std.getId()+"'");
		System.out.println(row);
		
		return "Success";*/
		daofirst.deleteById(id);
		return "Deleted";
		
	}
	
	
	@PostMapping("/upadtemap")
	public  Object doupdate(@RequestBody StudentDetails std
			//,@RequestHeader("id") Integer id
			//@RequestHeader("token") String token
			) throws ClassNotFoundException, SQLException
	{
		/*
		 * boolean b=DecoderCode.validToken(token); if(b==false) { return
		 * "token expired - please login again."; } Statement
		 * st=DatabaseConnection.DBconnectore(); int
		 * row=st.executeUpdate("update  Student_Details set sname='"+std.getName()
		 * +"' ,semail='"+std.getEmail()+"' where sid='"+sid+"'");
		 * System.out.println(row);
		 * 
		 * return "Success";
		 */
		StudentDetails stobj  =  daofirst.save(std); 

			if(stobj !=null) { return stobj; }
			
			  else { return "registration failed"; }
	}
	
	@PostMapping("/aSigin")
	public Object dosigin(@RequestBody StudentDetails std ) throws ClassNotFoundException, SQLException
	{
		/*
		 * Statement st=DatabaseConnection.DBconnectore(); String
		 * loginquery="select * from Student_Details where Semail = '"+std.getEmail()
		 * +"'  and spass = '"+std.getPass()+"'"; ResultSet rs =
		 * st.executeQuery(loginquery);
		 * 
		 * if(rs.next()) { int id = rs.getInt("sid"); String name =
		 * rs.getString("sname");
		 * 
		 * 
		 * std.setId(id); std.setName(name);
		 * 
		 * 
		 * 
		 * Long ml=System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(2); String
		 * token=Base64.getEncoder().encodeToString(ml.toString().getBytes());
		 * std.setToken(token);
		 * 
		 * return std; } else { return "no student is registered with is email"; }
		 */
		StudentDetails sobj=daofirst.findByEmailAndPass(std.getEmail(),std.getPass() );
		if(sobj!=null)
		{
			return "Login successful";
		}
		else
		{
			return "Login failed";
		}
	}
	

}
