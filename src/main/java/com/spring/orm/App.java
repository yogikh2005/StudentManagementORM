package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.Pipe.SourceChannel;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.Dao.StudentDao;
import com.spring.orm.entities.Student;



public class App {
    public static void main( String[] args )  {
    	
    
    		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    		StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
    		
    		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    		
    		while(true) {
    			System.out.println();
    			System.out.println("--------------------Welcome To Student Managment System--------------------");
    			System.out.println("1:Add new student");
    			System.out.println("2:Display all student");
    			System.out.println("3:Get info singal student");
    			System.out.println("4:Update student");
    			System.out.println("5:Delete student");
    			System.out.println("6:Exit");
				
    			try {
				
    			
    			int ch=Integer.parseInt(bufferedReader.readLine());  
    			
    			switch (ch) {
    			
    			//Save student
				case 1: 
					
				
					System.out.println("Enter student name");
					String name=bufferedReader.readLine();
					
					System.out.println("Enter student address");
					String address=bufferedReader.readLine();
					
					System.out.println("Enter the student mobile number");
					long mobile =Long.parseLong(bufferedReader.readLine());
					
					Student student=new Student();
					
					student.setStudentAddress(address);
					student.setStudentName(name);
					student.setStudentMobile(mobile);
					
					int res=studentDao.insert(student);
					System.out.println("Student added successfully with id"+res);
					System.out.println("-------------------------------------------------------------");
					break;
					
				//Read all student	
				case 2:
					
				     List<Student>allStudents=studentDao.getList();
				     if(allStudents!=null) {
				     System.out.println("All students");
				     System.out.println("--------------------------------------------------------------");
				     System.out.printf("| %-5s | %-15s | %-12s | %-17s |\n", "Id", "Name", "Mobile", "Address");
				     System.out.println("--------------------------------------------------------------");

				     for (Student student2 : allStudents) {
				         System.out.printf("| %-5d | %-15s | %-12s | %-17s |\n",
				             student2.getStudentId(),
				             student2.getStudentName(),
				             student2.getStudentMobile(),
				             student2.getStudentAddress());
				     }

				     System.out.println("--------------------------------------------------------------");
				     }
				     else {
						System.out.println("No Record Available!!");
					}
					break;
					
					//Read specific student
				case 3:
					
					System.out.println("Enter the id of student");
					int id1 =Integer.parseInt(bufferedReader.readLine());
					 Student student2=studentDao.getStudent(id1);
					if(student2!=null)
					{
				     System.out.println("Student information");
				     System.out.println("--------------------------------------------------------------");
				     System.out.printf("| %-5s | %-15s | %-12s | %-17s |\n", "Id", "Name", "Mobile", "Address");
				     System.out.println("--------------------------------------------------------------");

				    
				         System.out.printf("| %-5d | %-15s | %-12s | %-17s |\n",
				             student2.getStudentId(),
				             student2.getStudentName(),
				             student2.getStudentMobile(),
				             student2.getStudentAddress());
				   

				     System.out.println("--------------------------------------------------------------");
					}
					else {
						System.out.println("Record Not Found !!");
						System.out.println("-------------------------------------------------------------");
					}
				
			
					break;
					
					//Update student
				case 4:
					System.out.println("Enter the id of student want be update");
					int id3=Integer.parseInt(bufferedReader.readLine());
					
					Student student3=studentDao.getStudent(id3);	
					
					if(student3!=null)
					{
						System.out.println("Enter student name");
						String name2=bufferedReader.readLine();
						
						System.out.println("Enter student address");
						String address2=bufferedReader.readLine();
						
						System.out.println("Enter the student mobile number");
						long mobile2 =Long.parseLong(bufferedReader.readLine());
						
					student3.setStudentAddress(address2);
					student3.setStudentName(name2);
					student3.setStudentMobile(mobile2);
					
					studentDao.update(student3);
					System.out.println("Student updated successfully");
					System.out.println("-------------------------------------------------------------");
					}
					else {
						System.out.println("Record Not Found !!");
						System.out.println("-------------------------------------------------------------");
					}
					break;
					
					//Delete Student
				case 5:
					System.out.println("Enter the id of student want be delete");
					int id4=Integer.parseInt(bufferedReader.readLine());
					
					 Student student4=studentDao.getStudent(id4);
						if(student4!=null)
						{
							studentDao.delete(id4);
							System.out.println("Student deleted successfully");
							System.out.println("-------------------------------------------------------------");
						}
						else {
							System.out.println("Record Not Found !!");
							System.out.println("-------------------------------------------------------------");
						}
					
					break;
					//Exit
				case 6:
					System.out.println("Thakyou for using my application");
			  		System.out.println("See you soon !!");
			  		System.exit(0);
					break;
				default:
					System.out.println("Invalid Input!!Please Enter valid Input");
			}
    			
    		
    			} catch (Exception e) {
					System.out.println("Invalid Input Try with another one !!");
					System.out.println(e.getMessage());
			
				}
    			
    }
    		
  
}
}
