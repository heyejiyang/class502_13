import { useReducer, useState, useRef, useCallback } from 'react';
import AddTodo from '../components/AddTodo2';
import TodoList from '../components/TodoList2';

const intialValue = [
  { id: 1, title: '할일1', done: true },
  { id: 2, title: '할일2', done: false },
  { id: 3, title: '할일3', done: false },
];

function reducer(items, action) {
  //현재상태값, 현재 액션
  //console.log('state', state, 'action', action);
  switch (action.type) {
    case 'ADD':
      return items.concat(action.todo);
    case 'Toggle':
      return items.map((item) =>
        item.id === action.id ? { ...item, done: !item.done } : item,
      );
    case 'Remove':
      return items.filter((item) => item.id !== action.id);
  }
  return items;
}

const TodoContainer = () => {
  const [items, dispatch] = useReducer(reducer, intialValue);
  //dispatch를 가지고 액션을 발생시킨다.

  // 업데이트 시, 매번 호출

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

      dispatch({
        type: 'ADD',
        todo: {
          id: id.current,
          title: todo,
          done: false,
        },
      }); //어떤 액션을 할것인가 -> Add

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
    dispatch({ type: 'Toggle', id });
  }, []);

  // 할일 목록 제거
  const onRemove = useCallback((id) => {
    dispatch({ type: 'Remove', id });
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
