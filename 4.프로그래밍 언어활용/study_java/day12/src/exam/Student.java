package exam;

import collection.Member;

import java.util.HashSet;

public class Student {

    private String memId;
    private String memName;

    Student(String number, String name){
        this.memId = number;
        this.memName = name;
    }

    @Override
    public int hashCode() {
        int number = Integer.parseInt(memId);
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            Student student = (Student) obj;
            if(this.memId == student.memId){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return memId+":"+memName;
    }
}
