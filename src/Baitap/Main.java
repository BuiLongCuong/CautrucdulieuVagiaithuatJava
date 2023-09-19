package Baitap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager clazz = new StudentManager();
        Student sv1 = new Student("An", "12a1", 20, "SG",new double[] {9,8,9});
        Student sv2 = new Student("Bản", "12a1", 23, "DN",new double[] {8,7,9});
        Student sv3 = new Student("Dung", "12a1", 20, "BD",new double[] {9,9,8});
        Student sv4 = new Student("Khang", "12a1", 20, "DN",new double[] {7,7,7});
        Student sv5 = new Student("Nhật", "12a1", 25, "SG",new double[] {9,7,8});
        Student sv6 = new Student("Nghi", "12a1", 23, "DN",new double[] {7,7,7});
        Student sv7 = new Student("Phú", "12a1", 20, "HN",new double[] {9,6,8});
        clazz.add(sv1);
        clazz.add(sv2);
        clazz.add(sv3);
        clazz.add(sv4);
        clazz.add(sv5);
        clazz.add(sv6);
        clazz.add(sv7);
        System.out.println("Danh sách học sinh:");
        clazz.showAll();
        System.out.println("---------------------------------------------------------------------");
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu quản lí học sinh:");
            System.out.println("1.Thêm học sinh mới.");
            System.out.println("2.Xóa học sinh.");
            System.out.println("3.Sửa học sinh.");
            System.out.println("4.Tìm kiếm học sinh");
            System.out.println("5.Danh sách học sinh cần tìm.");
            System.out.println("6.Học sinh có điểm trung bình cao nhất.");
            System.out.println("7.Danh sách sinh viên.");
            System.out.println("8.Hiển thị các học sinh 20 tuổi.");
            System.out.println("9.Cho biết số lượng các học sinh có tuổi là 23 và ở DN.");
            System.out.println("0.Thoát.");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên:");
                    String name = input.nextLine();
//                    input.nextLine();
                    System.out.println("Nhập lớp:");
                    String cla = input.nextLine();
                    System.out.println("Nhập tuổi:");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.println("Nhập địa chỉ:");
                    String address = input.nextLine();
                    double[] arrScores = new double[3];
                    System.out.println("Nhập điểm môn Toán:");
                    double toan= input.nextDouble();
                    arrScores[0]=toan;
                    System.out.println("Nhập điểm môn Văn:");
                    double van= input.nextDouble();
                    arrScores[1]=van;
                    System.out.println("Nhập điểm môn Anh:");
                    double anh= input.nextDouble();
                    arrScores[2]=anh;
                    Student newStudent = new Student(name, cla, age, address,arrScores);
                    clazz.add(newStudent);
                    System.out.println("Thêm thành công!!");
                    clazz.showAll();
                    break;
                case 2:
                    System.out.println("Nhập số id của học sinh bạn muốn xóa:");
                    int id = input.nextInt();
                    clazz.delete(id);
                    System.out.println("Xóa thành công!!");
                    clazz.showAll();
                    break;
                case 3:
                    System.out.println("Nhập số id của học sinh bạn muốn sửa:");
                    int editId = input.nextInt();
                    input.nextLine();
                    if (clazz.findById(editId) != -1) {
                        System.out.println("Nhập tên:");
                        String editName = input.nextLine();
                        System.out.println("Nhập lớp:");
                        String editCla = input.nextLine();
                        System.out.println("Nhập tuổi:");
                        int editAge = input.nextInt();
                        input.nextLine();
                        System.out.println("Nhập địa chỉ:");
                        String editAddress = input.nextLine();
                        double[] editArrScores = new double[3];
                        System.out.println("Nhập điểm môn Toán:");
                        double editToan= input.nextDouble();
                        editArrScores[0]=editToan;
                        System.out.println("Nhập điểm môn Văn:");
                        double editVan= input.nextDouble();
                        editArrScores[1]=editVan;
                        System.out.println("Nhập điểm môn Anh:");
                        double editAnh= input.nextDouble();
                        editArrScores[2]=editAnh;
                        clazz.edit(editId, editName, editCla, editAge, editAddress,editArrScores);
                        System.out.println("Sửa thành công!!");
                        clazz.showAll();
                    } else {
                        System.out.println("Không có học sinh nào!!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập id của học sinh bạn muốn tìm:");
                    int searchId = input.nextInt();
                    if(clazz.findById(searchId)!=-1){
                        System.out.println(clazz.findStudentById(searchId));
                    }else {
                        System.out.println("Không có học sinh nào!");
                    }
                    break;
                case 5:
                    System.out.println("Nhập tên học sinh bạn muốn tìm:");
                    String searchName = input.nextLine();
                    if(clazz.findStudentByName(searchName)!=null){
                        System.out.println(clazz.findStudentByName(searchName));
                    }else {
                        System.out.println("Không có học sinh nào!!");
                    }
                    break;
                case 6:
                    System.out.println(clazz.maxAvg());
                    break;
                case 7:
                    clazz.showAll();
                    break;
                case 8:
                    if (clazz.checkAge() != null) {
                        for (Student hocSinh:clazz.checkAge()) {
                            System.out.println(hocSinh);
                        }
                    } else {
                        System.out.println("Không có học sinh nào!!");
                    }
                    break;
                case 9:
                    if (clazz.count() != 0) {
                        System.out.println("Số lượng các họ sinh có tuổi là 23 và ở DN: " + clazz.count());
                    } else {
                        System.out.println("Không có học sinh nòa!!");
                    }
                    break;
            }
        } while (choice != 0);
    }
}