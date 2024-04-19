package exam03;

import exam02.B;

public class Ex01 {
    public static void main(String[] args) {
        Human human = new Human();
       // human.move();

        Tiger tiger = new Tiger();
        //tiger.move();

        Bird bird = new Bird();
        //bird.move();

 //       Human[] animals = new Human[3];

//        animals[0] = human;
//        Animal[] animals1 = new Animal[3];
//        animals1[0] = human;
//        animals1[1] = tiger;
//        animals1[2] = new Bird();

        //선언과 동시에 초기화
        Animal[] animals = {new Human(),new Bird(),new Tiger()};


        Animal originAnimal = new Animal();
        originAnimal.move(); //움직인다 출력


//        for(int i = 0; i< animal.length;i++){
//            animal[i].move();
//        }
        for(Animal animal : animals){
            animal.move();
        }
    }
}
