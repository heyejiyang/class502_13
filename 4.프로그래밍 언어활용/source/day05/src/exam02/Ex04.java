package exam02;

public class Ex04 {
    public static void main(String[] args) {
        A ad = new D();
        A ac = new C();


        /*
        * ad 객체는 D의 인스턴스를 가리키며, 이 객체를 A 타입의 변수 ad에 할당
        *ad에는 D의 일부분이 담겨있게 된다.
        * ad는 A를 기반으로 하지만 D의 기능도 사용할 수 있다.
        * */
        //ad -> D객체가 A에 담겨있게 되었으니 A틀에서 d의 일부분이 담겨있는중 (A통에 d)
        //ac -> 또다른 A틀에서 c의 일부분이 담겨있는중 (또다른 A통에 c)
        //그러므로 ad,ac가 D,C의 모든 자원을 사용할수있지는 않다! 일부분일뿐

        System.out.println(ac.numA);
        System.out.println(ad.numA);
        //C c = ad; // 문제 발생 어디 안에 있는 A 앤지 출처 확인 필요
        //C c = (C)ad;// 명시적으로 형변환해서 알려주기.. 근데 얘는 C애가 아니잖아!!!

        if( ad instanceof C){ //false
            C c = (C)ad;
            System.out.println("----"+c.numB);
        }
        if( ac instanceof C){//맞아도 출처확인 필요
            C c = (C)ac;
            System.out.println("--");
            System.out.println(c.numA);
            System.out.println(c.numB);
            System.out.println(c.numC);
        }
    }

}
