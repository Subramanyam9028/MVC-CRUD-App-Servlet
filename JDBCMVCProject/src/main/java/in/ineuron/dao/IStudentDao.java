package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {

	
	String save(Student student);//create record indatabase
	
	Student findById(Integer sid);//for read 
	
	String updateById(Student student);//updating record
	
	String deleteById(Integer sid);//deleteing record

}
