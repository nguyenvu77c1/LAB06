package laptrinhungdungjava.bai2.buoi_4.controller;

import laptrinhungdungjava.bai2.buoi_4.model.Course;
import laptrinhungdungjava.bai2.buoi_4.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/test")
    public String index(Model model) {return "home";}

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("Listcourse",courseService.getAllCourses());
        return "home";
    }

}
