package exam01;

public enum Transportation { //교통수단 관련 enum클래스, 자료형:Transportation
    BUS(1400) {
        @Override
        public int getTotal(int person) {
            return 0;
        }
    }, //Transportation의 정적 상수객체
    //내부적으로 public static final BUS = new Transportation();으로 되어있다.
    SUBWAY(1300) {
        @Override
        public int getTotal(int person) {
            return 0;
        }
    }, //매개변수가있는 생성자 호출
    TAXI(3500) {
        @Override
        public int getTotal(int person) {
            return 0;
        }
    };

    private final int fare; //상수로 정의

    Transportation(int fare){
        this.fare = fare;//생성자 통해서 값 초기화
    }

    //fare조회 메서드
    public int getFare(){
        return fare;
    }

    //편의기능 추가생성
    public abstract int getTotal(int person);
}
