import { useState } from 'react';
import { MdOutlineCheckBox, MdCheckBoxOutlineBlank } from 'react-icons/md';
//react-icons에서 가져옴

const initialValue = [
  //초기값
  { id: 1, title: '할일1', done: false }, //체크 안 된 메모칸
  { id: 2, title: '할일2', done: true }, //체크 된 메모칸
  { id: 3, title: '할일3', done: false },
];

const Todos = () => {
  const [items, setItems] = useState(initialValue); //초기값은 items에 들어감
  const ontoggle = (id) => {
    //클릭시 체크박스 아이콘 바뀌게
    const newItems = items.map((item) =>
      item.id === id ? { ...item, done: !item.done } : item,
    ); 
    /**
     * map을 통해서 새로운 배열객채로 이렇게 하면 새로운 배열이 만들어지면서 원래 배열의 요소 중 클릭한 요소의 상태만 변경됨
     * item이 넘어왔을때 클릭된 id이면 done속성값이 반전된다, 아니라면 초기 item 그대로 반환해준다.(item.id = 배열 내의 각 요소의 id) (id = 클릭한 항목의 id(ontoggle()함수의 매개변수로 전달되는 값))
     * ...item -> 기존 객체 복사
     * 조건이 참일 경우: ...item으로 기존 item 객체를 복사하고, done 속성을 반전시킨 후 그 객체를 반환
     */

    setItems(newItems); //새로운 객채 형태로 페이지 로딩
  };
  return (
    <ul>
      {items.map(({ id, title, done }) => (
        <li key={id} onClick={() => ontoggle(id)}>
          {/* //클릭시 done값이 바뀌도록 */}
          {done ? <MdOutlineCheckBox /> : <MdCheckBoxOutlineBlank />}{' '}
          {/**done이 true일 때는 체크된 박스 flase일때는 체크안된 박스 */}
          {title}
        </li> //키값: 내부에 쓰일 목적으로 정의하는 값
      ))}
    </ul>
  );
};

export default Todos;
