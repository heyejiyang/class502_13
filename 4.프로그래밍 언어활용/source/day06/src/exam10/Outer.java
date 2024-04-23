package exam10;

public class Outer {
//    Calculator cal = new Calculator() {
//        @Override
//        public int add(int num1, int num2) {
//            return num1+num2;
//        }
//    };
//    int result = cal.add(30,30);
    public Calculator method(){
        return new Calculator() {
            @Override
            public int add(int num1, int num2) {
                return num1*num2;
            }
        };
    }
}
