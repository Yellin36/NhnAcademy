package com.nhnacademy.domain;

import lombok.*;

//@Getter
//@AllArgsConstructor //순서가 같아야하고, 중간에 문제가 생겨서 코드가 깨질 수 있기에 사용을 권장하지 않는다.
//@RequiredArgsConstructor    //이걸로 꼭 필요한 데이터들을 final로 하여 생성 ㄱㄱ
//@Value  //한번 쓰고 영원히 바꾸지 않는 경우
@Data   //한번 쓰고 중간에 수정도 가능
public class Student {
    private final String id;
    private final String name;
    private final String gender;
    private final int age;


}

