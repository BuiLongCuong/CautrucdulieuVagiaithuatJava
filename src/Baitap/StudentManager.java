package Baitap;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> listStudent = new ArrayList<>();
    private int size;

    public StudentManager() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void add(Student newStudent) {
        listStudent.add(newStudent);
    }

    public int findById(int id) {
        for (Student sinhVien : getListStudent()) {
            if (sinhVien.getId() == id) {
                return sinhVien.getId();
            }
        }
        return -1;
    }
    public Student findStudentById(int id) {
        for (Student sinhVien : getListStudent()) {
            if (sinhVien.getId() == id) {
                return sinhVien;
            }
        }
        return null;
    }

    public void delete(int id) {
        listStudent.remove(id-1);
    }

    public void edit(int id, String name, String cla, int age, String address,double[] arrScores) {
        int index = findById(id);
        for (Student hocSinh : getListStudent()) {
            if (hocSinh.getId() == index) {
                hocSinh.setName(name);
                hocSinh.setClazz(cla);
                hocSinh.setAge(age);
                hocSinh.setAddress(address);
                hocSinh.setArrScores(arrScores);
            }
        }
    }
//    public void edit(int id, Student newStudent){
//        listStudent.set(id,newStudent);
//    }
    public void showAll() {
        for (Student sinhVien : getListStudent()) {
            System.out.println(sinhVien);
        }
    }

    public ArrayList<Student> checkAge() {
        ArrayList<Student> arrHocSinh = new ArrayList<>();
        for (Student hocSinh : getListStudent()) {
            if (hocSinh.getAge() == 20) {
                arrHocSinh.add(hocSinh);
            }
        }
        return arrHocSinh;
    }
    public int count(){
       int count =0;
        for (Student hocSinh:getListStudent()) {
            if(hocSinh.getAge()==23 && hocSinh.getAddress()=="DN"){
                count++;
            }
        }
        return count;
    }
    public ArrayList<Student> indStudentByName(String name){
        ArrayList<Student> searchStudents = new ArrayList<>();
        for (Student students: getListStudent()) {
            if(students.getName().toLowerCase().contains(name.toLowerCase())){
                searchStudents.add(students);
            }
        }
        return searchStudents;
    }
     public Student maxAvg(){
         double maxAvg =0;
         Student studentHasMaxAvg = null;
        for (Student hocSinh: getListStudent()) {
            if(hocSinh.avg()>maxAvg){
                maxAvg= hocSinh.avg();
                studentHasMaxAvg=hocSinh;
            }
        }
        return studentHasMaxAvg;
    }
}
