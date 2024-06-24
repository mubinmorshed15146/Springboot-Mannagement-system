package com.example.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.studentmanagementsystem.entity.Students;
import com.example.studentmanagementsystem.service.StdService;

@Controller
public class StudentController {
  private StdService service;

  public StudentController(StdService stdService) {
    super();
    this.service = stdService;
  }

  @GetMapping("/students")
  /*
   * We have used model from org.springframework.ui.Model for the view the first string value will
   * be used in the html file to retrieve the values for show on the browser
   */
  public String studentList(Model model) {
    model.addAttribute("student", service.getAllStudents());
    return "student";
  }

  @GetMapping("/students/new")
  public String createStudentForm(Model model) {

    // Creating a student object to hold the student data from the form to add in the database
    Students student = new Students();
    // using this method to access in the html file to show
    // the first argument is the th:object=${student} in create_student.html
    model.addAttribute("student", student);
    return "create_student";

  }

  @PostMapping("/students")
  public String saveStudent(@ModelAttribute("student") Students student) {
    service.saveStudent(student);
    // Redirecting to the student page after adding the datas in the data base
    return "redirect:/students";

  }

  @GetMapping("/students/edit/{id}")
  public String editStudent(@PathVariable Long id, Model model) {
    model.addAttribute("student", service.getStudentById(id));
    return "edit_student";

  }

  @PostMapping("/students/{id}")
  public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Students student) {
    Students existingStudent = service.getStudentById(id);
    existingStudent.setfName(student.getfName());
    existingStudent.setlName(student.getlName());
    existingStudent.setEmail(student.getEmail());
    service.updateStudent(existingStudent);
    return "redirect:/students";

  }
  
  @GetMapping("/students/{id}")
  public String  deleteStudent(@PathVariable("id")Long id) {
    service.delete(id);
    return "redirect:/students";
    
  }
}


