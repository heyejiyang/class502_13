import { useState, useRef, useCallback } from 'react';
import AddTodo from '../components/AddTodo';
import TodoList from '../components/TodoList';
import { produce } from 'immer';

const intialValue = [
  { id: 1, title: '할일1', done: true },
  { id: 2, title: '할일2', done: false },
  { id: 3, title: '할일3', done: false },
];

const TodoContainer = () => {
  // 업데이트 시, 매번 호출
  const [items, setItems] = useState(intialValue);
  const [todo, setTodo] = useState('');
  const [message, setMessage] = useState('');

  let id = useRef(4); // 할일 id

  // 할일 등록 처리
  const onSubmit = useCallback(
    (e) => {
      e.preventDefault();

      if (!todo.trim()) {
        setMessage('할일을 입력하세요.');
        return;
      }

      // setItems((prevItems) => {
      //   return prevItems.concat({
      //     id: id.current,
      //     title: todo.trim(),
      //     done: false,
      //   });
      // });

      setItems(
        /*produce함수를 사용하여 items 상태를 업데이트 하자
        produce함수를 호출하여 변경할 데이터를 가공한다.
        produce 함수의 인자로 전달된 함수는 draft 상태를 조작하는 함수이다. 이 함수 내에서는 draft를 수정하여 새로운 상태를 생성한다.
        */
        produce((draft) => {
          draft.push({ //push를 사용하여 새로운 할일 객체를 items배열에추가
            id: id.current,
            title: todo.trim(),
            done: false,
          });
        }),//produce함수는 draft를 변경한 내용을 추적하고 변경된 draft를 이용하여 새로운 상태를 생성한다.
      );

      id.current++;

      setTodo('');
      setMessage('');
    },
    [todo],
  );

  // 할일 입력시 todo 상태값 변경
  const onChange = useCallback((e) => setTodo(e.currentTarget.value), []);

  // 할일 목록 완료 여부 토글(true -> false, false -> true)
  const onToggle = useCallback((id) => {
    /*
      const newItems = items.map((item) =>
        item.id === id ? { ...item, done: !item.done } : item,
      );
      setItems(newItems);
      */
    // setItems((prevItems) =>
    //   prevItems.map((item) =>
    //     item.id === id ? { ...item, done: !item.done } : item,
    //   ),
    // );

    setItems(
      produce((draft) =>
        draft.forEach((item) => item.id === id && (item.done = !item.done)),
      ),
    );
  }, []);

  // 할일 목록 제거
  const onRemove = useCallback((id) => {
    /*
      const newItems = items.filter((item) => item.id !== id);
      setItems(newItems);
      */
    setItems((prevItems) => {
      return prevItems.filter((item) => item.id !== id);
    });
  }, []);

  return (
    <>
      <AddTodo
        onSubmit={onSubmit}
        onChange={onChange}
        todo={todo}
        message={message}
      />
      <TodoList items={items} onToggle={onToggle} onRemove={onRemove} />
    </>
  );
};

export default TodoContainer;
