import { useState, useRef } from 'react';
import AddTodo from '../components/AddTodo';
import TodoList from '../components/TodoList';

/**컨테이너컴포넌트*/

const initialValue = [
  { id: 1, title: '할일1', done: true },
  { id: 2, title: '할일2', done: false },
  { id: 3, title: '할일3', done: false },
]; //배열형태로 초기값 = items

//함수형 컴포넌트 형태
const TodoContainer = () => {
  const [items, setItems] = useState(initialValue);
  const [todo, setTodo] = useState(''); //키보드 입력할때 todo넣어주기
  const [message, setMessage] = useState('');

  let id = useRef(4); //할일 id
  //할일 등록 처리
  const onSubmit = (e) => {
    //submit는 사실사실사실 제출해도 화면이 넘어가지않는다..?
    e.preventDefault();

    if (!todo.trim()) {
      //입력이없으면
      setMessage('할일을 입력하세요.');
      return; //return undefined
    }

    //새로운 배열 객체를 만들어야 할일이 추가된다 주소가!! 달라져야 달라짐
    const newItems = items.concat({
      //items 배열에 새로운 객체를 추가한 새로운 배열을 생성하는 것
      id: id.current,
      title: todo.trim(), //공백제거 trim
      done: false,
    });

    setItems(newItems);

    id.current++;

    setTodo(''); //값 비우기
    setMessage('');
  };

  //할일 입력시 todo 상태값 변경
  const onChange = (e) => setTodo(e.currentTarget.value);

  //할일 목록 완료 여부 토글 (true -> false, false -> true)
  const onToggle = (id) => {
    const newItems = items.map((item) =>
      item.id === id ? { ...item, done: !item.done } : item,
    );
    setItems(newItems);
  };

  //할일 목록 제거
  const onRemove = (id) => {
    //filter로 배제하기, 새로운 배열객체 생성
    const newItems = items.filter((item) => item.id !== id);
    setItems(newItems);
  };

  return (
    <>
      <AddTodo
        onSubmit={onSubmit}
        onChange={onChange}
        todo={todo}
        message={message}
      />
      {/**얘도 넘겨주기 -> 프리젠테이셔널에서 props 비구조할당으로 가져오기 */}
      <TodoList items={items} onToggle={onToggle} onRemove={onRemove} />
      {/**TodoList여기서 실제 출력 ,컨테이너에서(부모) 가공한 데이터 속성 형태로 넘겨주기 props */}
    </>
  );
};

export default TodoContainer;
