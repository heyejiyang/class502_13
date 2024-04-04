import { MdOutlineCheckBox, MdCheckBoxOutlineBlank } from 'react-icons/md';
//react-icons에서 가져옴

const items = [
  { id: 1, title: '할일1', done: false }, //체크 안 된 메모칸
  { id: 2, title: '할일2', done: true }, //체크 된 메모칸
  { id: 3, title: '할일3', done: false },
];

const Todos = () => {
  return (
    <ul>
      {items.map(({ id, title, done}) => (
        <li key={id}>
            { done ? <MdOutlineCheckBox/> : <MdCheckBoxOutlineBlank/>}       
            {title}</li> //키값: 내부에 쓰일 목적으로 정의하는 값
      ))}
    </ul>
  );
};

export default Todos;
