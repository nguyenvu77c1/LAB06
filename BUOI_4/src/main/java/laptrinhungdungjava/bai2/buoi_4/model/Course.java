package laptrinhungdungjava.bai2.buoi_4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Tên khóa học không được để trống")
    @Size(max = 100, message = "Tên khóa học tối đa 100 kí tự")
    private String lectureName;

    @NotBlank(message = "Tên giảng viên không được để trống")
    @Size(max = 100, message = "Tên giảng viên tối đa 100 kí tự")
    private String teacherName;

    @NotBlank(message = "Giá không được để trống")
    private String place;

    @Future(message = "Ngày bắt đầu học phải lớn hơn ngày hiện tại")
    private LocalDate startDate;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    // Constructor mặc định không tham số
    public Course() {
    }

    // Constructor có tham số
    public Course(int id, String lectureName, String place, LocalDate startDate, String address, String teacherName) {
        this.id = id;
        this.lectureName = lectureName;
        this.place = place;
        this.startDate = startDate;
        this.address = address;
        this.teacherName = teacherName;
    }

    // Getters và setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
