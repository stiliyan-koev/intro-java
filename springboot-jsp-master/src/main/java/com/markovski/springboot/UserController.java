package com.markovski.springboot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.markovski.dto.Employee;
import com.markovski.dto.EmployeeDTOForEmployer;
import com.markovski.dto.EmployeeRepository;
import com.markovski.dto.Employer;
import com.markovski.dto.EmployerRepository;
import com.markovski.dto.Task;
import com.markovski.dto.TaskRepository;
import com.markovski.dto.Update;
import com.markovski.dto.UpdateRepository;
import com.markovski.dto.User;
import com.markovski.dto.UserRepository;

@RestController
@ComponentScan("com.markovski.dto")
@EnableJpaRepositories("com.markovski.dto")
@EntityScan(basePackageClasses = User.class)
@SessionAttributes("person")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	EmployerRepository employerRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	UpdateRepository updateRepository;
	private String loggedName;

	@RequestMapping("/hello")
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "hello";
	}

	// how to get like json
	@RequestMapping(value = "/records", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Employer> getRecords() {
		List<Employer> list = employerRepository.findAll();
		return list;
	}

	@RequestMapping("/insertRecords")
	public void insertRecords() throws ParseException {
		String dateOne = "10/10/1980";
		Date dateeOne = new SimpleDateFormat("dd/MM/yyyy").parse(dateOne);

		List<User> users = new ArrayList<>();
		users.add(new User("Asen", "Ivanov", dateeOne, "08888", "asen@gmail.com", true, "asen", "asen",
				new Employer("Asen", "N", "Ivanov", 1, "088886", dateeOne, true, dateeOne, 10000, 2000, 5000)));

		users.add(new User("Asen2", "Ivanov2", dateeOne, "08888", "asen@gmail.com", true, "asen", "asen",
				new Employer("Asen2", "N", "Ivanov2", 1, "088886", dateeOne, true, dateeOne, 10000, 2000, 5000)));

		users.add(new User("Martin", "Martinov", dateeOne, "08888", "Martin@gmail.com", true, "Martin", "Martin",
				new Employee("Martin", "N", "Martinov", 1, "088886", dateeOne, "IT", 5, true, dateeOne, 10000, 2000,
						5000, true)));
		userRepository.save(users);

		Employer boss = new Employer("Iliq", "N", "Boss", 1, "0888651215", dateeOne, true, dateeOne, 53000, 23000,
				1500);

		User bossUser = new User("Iliq", "Boss", dateeOne, "0888651215", "iliya@gmail.com", true, "iliya", "iliya",
				boss);

		Employee pesho = new Employee("Pesho", "P", "Petrov", 1, "08854654", dateeOne, "Quality Assurance", 5, true,
				dateeOne, 30000, 10000, 2000, true);

		Employee iliq = new Employee("Iliq", "D", "Dimitrov", 1, "08854654", dateeOne, "Developper", 2, true, dateeOne,
				10000, 1000, 1000, true);

		userRepository.save(bossUser);

		Task devTask = new Task("Bug fix", "Pesho Petrov");
		List<Update> updates = new ArrayList();
		Update update = new Update("Bug fixed ");
		update.setTaskRefference(devTask);
		updates.add(update);
		devTask.setUpdates(updates);
		devTask.setEmployee(pesho);
		Task qaTask = new Task("Check if Pesho fix the bug", "Iliq Dimitrov");
		qaTask.setEmployee(iliq);
		List<Employee> listEmployees = new ArrayList<>();
		listEmployees.add(pesho);
		listEmployees.add(iliq);

		boss.setEmployees(listEmployees);
		pesho.setTaskRefference(devTask);
		iliq.setTaskRefference(qaTask);

		employerRepository.save(boss);
		pesho.setEmployerRefference(boss);
		iliq.setEmployerRefference(boss);
		employeeRepository.save(pesho);
		employeeRepository.save(iliq);

		taskRepository.save(devTask);
		taskRepository.save(qaTask);

		// updateRepository.save(update);

	}

	@Autowired
	private UserRepository userData;

	@RequestMapping(value = "/addNewUser.html", method = RequestMethod.POST)
	public String newUser(User user) {

		userData.save(user);
		return ("redirect:/listUsers.html");

	}

	@RequestMapping(value = "/addNewUser.html", method = RequestMethod.GET)
	public ModelAndView addNewUser(@Valid User user, BindingResult bindingResult, Model model) {

		User emp = new User();
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
		}
		return new ModelAndView("newUser", "form", emp);

	}

	@RequestMapping(value = "/listUsers.html", method = RequestMethod.GET)
	public List<User> users() {
		List<User> allUsers = userData.findAll();
		return allUsers;
		// return new ModelAndView("allUsers", "users", allUsers);
	}

	@RequestMapping("/employer-menu")
	public String employerMenu() {
		return "employer-menu";
	}

	@RequestMapping("/employerMenu")
	public ModelAndView employerMenu(@RequestParam("accName") String loggedName, ModelMap model) {
		this.loggedName = loggedName;
		User user = userRepository.findByAccountName(loggedName);
		Employer employer = user.getEmployerRefference();
		List<Employee> employeesList = employer.getEmployees();
		model.addAttribute("employeeCount", employeesList.size());
		return new ModelAndView("employer-menu", "employeesList", employeesList);
	}

	@RequestMapping(value = "/edit-form-employer", method = RequestMethod.GET)
	public String showEditPersonForm(@RequestParam("id") int id, Model model, RedirectAttributes attributes) {
		System.out.println(id);
		Employee person = employeeRepository.findOne(id);
		System.out.println(person.getBonus());
		if (person == null) {
			return "error";
		}
		model.addAttribute("person", person);
		return "edit-form-employer";
	}

	@RequestMapping(value = "send-update", method = RequestMethod.POST)
	public String submitEditPersonForm(@Valid @ModelAttribute("person") EmployeeDTOForEmployer updated,
			BindingResult bindingResult, RedirectAttributes attributes) {

		if (bindingResult.hasErrors()) {
			System.out.println("Edit person form contains validation errors. Rendering form view.");
			return "person/edit";
		} else {
			Employee employee = employeeRepository.findOne(updated.getId());
			if (employee != null) {
				employee.setDepartmentId(updated.getDepartmentId());
				employee.setJob(updated.getJob());
				employee.setSalary(updated.getSalary());
				employee.setBonus(updated.getBonus());
				employee.setComission(updated.getComission());
				employeeRepository.save(employee);
			}
		}

		return "redirect:/employerMenu?accName=" + loggedName;
	}

	@RequestMapping(name = "/personFormb", method = RequestMethod.POST)
	public String save(@ModelAttribute("person") Person person, BindingResult result, SessionStatus status,
			@RequestParam("action") String request) {
		if ("Save".equals(request)) {
			System.out.println("da");
			if (result.hasErrors()) {
				System.out.println("ne"); // https://dzone.com/articles/adding-crud-capability-spring
			} else {
				System.out.println("ne");
				status.setComplete();
			}
		} else {
			System.out.println("ne");
			status.setComplete();
		}
		return request;
	}

	// all new below
	@RequestMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return ResponseEntity.ok().body(user);
	}

	@RequestMapping(value = "/recs", method = RequestMethod.GET)
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}
}
