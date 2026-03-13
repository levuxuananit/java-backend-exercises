package session01.lab02;

public class Student {
    String id;
    String name;
    int age;
    String address;
    String gender;
    String email;

    public Student() {
    }

    public Student(String id, String name, int age, String address, String gender, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return    "id: "        + id +
                ", name: "    + name +
                ", age: "     + age +
                ", address: " + address +
                ", gender: "  + gender +
                ", email: "   + email;
    }
}
