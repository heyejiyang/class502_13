const Common = {
  a: 1,
  b: 2,
};

export function add(num1, num2) {
  return num1 + num2;
}
//여러개 내보내기 가능

export const person = {
  name: '홍길동',
  age: 38,
};
//객체도 내보낼수있다.

export default Common;
