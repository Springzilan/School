package School;

public class Student {
    private String stu_id;
    private String name;
    private String batch;
    private int age;
    private String DOB;
    private String bloodgroup;
    private String address;
    private String phone;
    private String email;
    public Student(String stu_id,String name,String batch,int age,String DOB,String bloodgroup,String address,String phone,String email){
        this.stu_id=stu_id;
        this.name=name;
        this.batch=batch;
        this.age=age;
        this.DOB=DOB;
        this.bloodgroup=bloodgroup;
        this.address=address;
        this.phone=phone;
        this.email=email;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
