package ex197_5;

public class Person {

    public String name;
    public int money;

    public Person(String name, int money){
        this.name = name;
        this.money = money;
    }
    public void star_Cafe(Star_Cafe star_cafe){
        star_cafe.menuMethod("아메리카노");
        star_cafe.showInfo();
        if(this.money < star_cafe.money){
            System.out.println("잔액이 부족합니다.");
        }else{
            //this.money -= 4000;
            System.out.println(name+"는 "+star_cafe.star+"에서 "+star_cafe.money+"원짜리 "+star_cafe.menu+"를 마셨습니다.");
        }
    }

    public void cong_Cafe(Cong_Cafe cong_cafe){
        cong_cafe.menuMethod("라테");
        cong_cafe.showInfo();
        if(this.money < cong_cafe.money){
            System.out.println("잔액이 부족합니다.");
        }else{
            //this.money -= 4500;
            System.out.println(name+"는 "+cong_cafe.cong+"에서 "+cong_cafe.money+"원짜리 "+cong_cafe.menu+"를 마셨습니다.");
        }
    }

}
