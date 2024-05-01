package exam;

public class MyDog {
    String name;
    String type;

    public MyDog(String name, String type){
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return type+" "+name;
    }
}
