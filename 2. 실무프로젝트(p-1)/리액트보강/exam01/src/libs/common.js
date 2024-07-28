// 공통 js

export const objA = { a : 10 }
export const objB = { b: 20 } //모듈 두가지 한번에 내보내기
//변수형태로 바로 대입 불가능


function myFunc() {
    console.log("myFunc");
}

export default myFunc; //함수 한개 내보내기( 함수 객체 주소 )