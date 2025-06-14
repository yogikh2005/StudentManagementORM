package com.spring.orm.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//Save student
	@Transactional
	public int insert(Student student)
	{
		Integer res = (Integer)this.hibernateTemplate.save(student);
		
		return res;
	}
	
	//Get specific student
	public Student getStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//Get all student
	@Transactional
	public List<Student> getList()
	{
		List<Student>lStudents=this.hibernateTemplate.loadAll(Student.class);
		return lStudents;
	}
	
	//Delete student
	@Transactional
	public void delete(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
	}
	
	//Update student
	@Transactional
	public void update(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	
	
}
