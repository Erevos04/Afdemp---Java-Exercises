package com.websystique.springmvc.controller;
 
import java.util.List;
import java.util.Locale;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.EmployeeInfo;
import com.websystique.springmvc.model.UserInfo;
import com.websystique.springmvc.model.Users;
import com.websystique.springmvc.service.EmployeeInfoService;
import com.websystique.springmvc.service.EmployeeService;
import com.websystique.springmvc.service.UserInfoService;
import com.websystique.springmvc.service.UsersService;
import org.springframework.web.bind.annotation.ModelAttribute;


 
@Controller
@RequestMapping("/")
public class AppController {
 
    @Autowired
    EmployeeService service;
    
    @Autowired
    EmployeeInfoService empservice;
    
    @Autowired
    UsersService usersservice;
    
    @Autowired
    UserInfoService userinfoservice;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
 
        List<Employee> employees = service.findAllEmployees();
        List<EmployeeInfo> employeesinfo = empservice.findAllEmployeeInfo();
        model.addAttribute("employees", employees);
        model.addAttribute("employeesinfo",employeesinfo);
        return "allemployees";
    }
 
    
    
    /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        EmployeeInfo employeeinfo = new EmployeeInfo();
        model.addAttribute("employeeinfo",employeeinfo);
        model.addAttribute("employee", employee);     
        model.addAttribute("edit", false);
        return "registration";
    }
    
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employeeinfo") EmployeeInfo employeeinfo,@ModelAttribute("employee") Employee employee,
            ModelMap model) {
        
        
         
        service.saveEmployee(employee);
        
        employeeinfo.setEmid(employee.getId());
        employee.setEmployeeinfo(employeeinfo);
        
        empservice.saveEmployeeInfo(employeeinfo);
        
 
        model.addAttribute("success", "Employee " + employee.getName() + " with last name "+employeeinfo.getLastname()+" registered successfully");
        return "success";
    }
    
    @RequestMapping(value = { "/useregister" }, method = RequestMethod.GET)
    public String useRegisterer(ModelMap model){
        Users users = new Users();
        UserInfo userinfo = new UserInfo();
        model.addAttribute("userinfo",userinfo);
        model.addAttribute("users", users);     
        
    return "useregister";
            }
    
    @RequestMapping(value = { "/useregister" }, method = RequestMethod.POST)
    public String useRegister(@ModelAttribute("userinfo") UserInfo userinfo, @ModelAttribute("users") Users users, BindingResult result, 
            ModelMap model) {
        
        
        usersservice.insertNewUser(users);       
        userinfo.setUser_id(users.getId());
        users.setUserInfo(userinfo);       
        userinfoservice.saveUserInfo(userinfo);
        
        //model.addAttribute("success", "User " + users.getUsername() + " with last name "+userinfo.getLast_name()+" registered successfully");
        return "success";
    }
 
    
 
    
        
        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         * and applying it on field [ssn] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        
         
        
 
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn,  ModelMap model) {
        Employee employee = service.findEmployeeBySsn(ssn);
        EmployeeInfo employeeinfo = empservice.findEmployeeInfoById(employee.getId());
        model.addAttribute("employee", employee); 
        model.addAttribute("employeeinfo",employeeinfo);
        
        model.addAttribute("edit", true);
        return "registration";
    }
     
    @RequestMapping(value = { "/edit-{emid}-employeeinfo" }, method = RequestMethod.GET)
    public String editEmployeeInfo(@PathVariable int emid, ModelMap model) {
        EmployeeInfo employeeinfo = empservice.findEmployeeInfoById(emid);
        Employee employee = service.findById(employeeinfo.getEmid());
        model.addAttribute("employee",employee);
        model.addAttribute("employeeinfo",employeeinfo);
        model.addAttribute("edit", true);
        return "registration";
    }
    
    
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("employee") Employee employee,  @ModelAttribute("employeeinfo") EmployeeInfo employeeinfo,
            ModelMap model) {
        
        
         
        service.updateEmployee(employee);
        
        employeeinfo.setEmid(employee.getId());
        employee.setEmployeeinfo(employeeinfo);
        
        empservice.updateEmployeeInfo(employeeinfo);
        
 
        model.addAttribute("success", "Employee " + employee.getName() + " with last name "+employeeinfo.getLastname()+" registered successfully");
        return "success";
    }
 
    @RequestMapping(value = { "/edit-{emid}-employeeinfo" }, method = RequestMethod.POST)
    public String updateEmployeeInfo(@ModelAttribute("employeeinfo") EmployeeInfo employeeinfo,@ModelAttribute("employee") Employee employee,
            ModelMap model) {
        
        
         
        service.updateEmployee(employee);
        
        employeeinfo.setEmid(employee.getId());
        employee.setEmployeeinfo(employeeinfo);
        
        empservice.updateEmployeeInfo(employeeinfo);
        
 
        model.addAttribute("success", "Employee " + employee.getName() + " with last name "+employeeinfo.getLastname()+" registered successfully");
        return "success";
    }
    
    
    
    
    /*
     * This method will delete an employee by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String ssn) {
        service.deleteEmployeeBySsn(ssn);
        return "redirect:/list";
    }
    
    
 
}