package laptrinhungdungjava.bai2.buoi_4.services;

import laptrinhungdungjava.bai2.buoi_4.model.Course;
import laptrinhungdungjava.bai2.buoi_4.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void add(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public void deleteCourseById(int id) {
        courseRepository.deleteById(id);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }
}
