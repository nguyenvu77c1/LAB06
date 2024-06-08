package laptrinhungdungjava.bai2.buoi_4.controller;

import jakarta.validation.Valid;
import laptrinhungdungjava.bai2.buoi_4.model.Course;
import laptrinhungdungjava.bai2.buoi_4.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("course", new Course());
        return "create";
    }

    @PostMapping("/create")
    public String createCourse(@Valid Course newCourse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create";
        }
        courseService.add(newCourse);
        return "redirect:/course/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("Listcourse", courseService.getAllCourses());
        return "home";
    }

    @GetMapping("/edit/{id}")
    public String editCourseForm(@PathVariable("id") int id, Model model) {
        Optional<Course> course = courseService.getCourseById(id);
        if (course.isPresent()) {
            model.addAttribute("course", course.get());
            return "edit";
        } else {
            return "redirect:/course/home";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateCourse(@PathVariable("id") int id, @Valid @ModelAttribute("course") Course updatedCourse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("course", updatedCourse);
            return "edit";
        }
        updatedCourse.setId(id);
        courseService.updateCourse(updatedCourse);
        return "redirect:/course/home";
    }



    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        courseService.deleteCourseById(id);
        return "redirect:/course/home";
    }
}
