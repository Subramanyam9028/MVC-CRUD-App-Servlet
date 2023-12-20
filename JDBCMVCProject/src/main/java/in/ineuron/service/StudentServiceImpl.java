package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = StudentDaoFactory.getStudentDao();
	
	
	@Override
	public String save(Student student) {
		
		
		return studentDao.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
		// TODO Auto-generated method stub
		return studentDao.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		// TODO Auto-generated method stub
		return studentDao.deleteById(sid);
	}

}
