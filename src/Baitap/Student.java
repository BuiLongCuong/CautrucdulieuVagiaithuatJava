package Baitap;

import java.util.Arrays;

public class Student {
    private int id;
    private static int idIncrements=1;
    private String name;
    private String clazz;
    private int age;
    private String address;
    private double[] arrScores;

    public Student( String name, String clazz, int age, String address,double[] arrScores) {
        this.id = idIncrements;
        this.name = name;
        this.clazz = clazz;
        this.age = age;
        this.address = address;
        this.arrScores= arrScores;
        idIncrements++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdIncrements() {
        return idIncrements;
    }

    public static void setIdIncrements(int idIncrements) {
        Student.idIncrements = idIncrements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public double[] getArrScores() {
        return arrScores;
    }

    public void setArrScores(double[] arrScores) {
        this.arrScores = arrScores;
    }
    public double avg(){
        double sum =0;
        int count=0;
        for (int i = 0; i < arrScores.length; i++) {
            sum+=arrScores[i];
            count++;
        }
        double avg = sum/count;
        return (double) Math.round(avg*1000)/1000;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", clazz='" + clazz + '\'' + ", age=" + age + ", address='" + address + '\'' + ", arrScores=" + Arrays.toString(arrScores) + ", avg="+avg()+'}';
    }
}
