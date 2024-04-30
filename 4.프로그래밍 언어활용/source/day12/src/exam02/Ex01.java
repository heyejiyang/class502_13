package exam02;

import java.util.HashMap;

public class Ex01 {
    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>();
        members.put("user01","사용자01");//키와 값 형태
        members.put("user02","사용자02");
        members.put("user03","사용자03");
        members.putIfAbsent("user03","(수정)사용자03");

        HashMap<String, String> members2 = new HashMap<>();
        members2.put("user04","사용자04");
        members2.put("user05","사용자05");

        //추가
        members.putAll(members2); //members에 members2 추가
        //있으면 바뀌고 없으면 추가
        members.put("user05","(수정)사용자05"); // = members.replace("user05","(수정)사용자05");

        //삭제
        members.remove("user05");

        //조회
        String userNm = members.get("user03"); //키값을 가지고 값 조회
        System.out.println(userNm); //사용자03

        //String userNm2 = members.get("user06"); //null -> 위험 위험

        //기본값 대체
        String userNm2 = members.getOrDefault("user06","없음");
        System.out.println(userNm2); //값이 없을때 기본값 대체 출력 '없음'


        System.out.println(members); //members.toString()
        //{user04=사용자04, user03=사용자03, user02=사용자02, user01=사용자01}

    }
}
