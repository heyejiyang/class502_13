package exam01;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class Ex01Test {

    @Test
    void test1(){
        //Locale.KOREAN
        Faker faker = new Faker(new Locale("ko_kr"));//언어 설정 한국어
        String name = faker.name().fullName();  //가짜데이터 항목

        System.out.println(name);
    }

    @Test
    void test2(){
        Faker faker = new Faker(Locale.KOREAN);
        String address = faker.address().zipCode()+" "+faker.address().cityName()+faker.address().streetAddress();
        System.out.println(address);
        String addressSub = faker.address().secondaryAddress();
        System.out.println(addressSub);
    }
}
