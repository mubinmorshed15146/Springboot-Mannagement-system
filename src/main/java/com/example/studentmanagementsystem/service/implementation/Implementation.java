package com.example.studentmanagementsystem.service.implementation;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.studentmanagementsystem.entity.Students;
import com.example.studentmanagementsystem.repository.StudentRepository;
import com.example.studentmanagementsystem.service.StdService;

/*
 * When ever we are in a service layer and we are implementing the service we have to use @Service
 * annotation.
 */
@Service
public class Implementation implements StdService {
  private StudentRepository repository;

  // we can avoid @Autowired annotation if there is only one constructor with field in springboot.
  public Implementation(StudentRepository repository) {
    super();
    this.repository = repository;
  }

  @Override
  public List<Students> getAllStudents() {
    return repository.findAll();
  }

  @Override
  public Students saveStudent(Students std) {
    return repository.save(std);
  }

  @Override
  public Students getStudentById(Long id) {
    return repository.findById(id).get();
  }

  @Override
  public Students updateStudent(Students student) {
    return repository.save(student);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

}
