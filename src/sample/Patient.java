package sample;

public class Patient {

    String name;
    String dob;


    String age;
    String phone;
    String gender;
    String id;


    public Patient(String name,  String age, String phone, String dob,String gender, String id) {
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.id = id;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
