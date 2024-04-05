/**할 일 기록 컴포넌트 양식/ 프리젠테이셔널 컴포넌트 */

import { MdOutlineAdd } from 'react-icons/md'; //플러스 아이콘

const AddTodo2 = ({ onSubmit, state, dispatch }) => {
  return (
    <form onSubmit={onSubmit} autoComplete="off">
      <input
        type="text"
        value={state.todo}
        onChange={dispatch({ type: 'INPUT' })}
      />
      <button type="submit">
        <MdOutlineAdd />
      </button>
    </form>
  ); //jsx문법 소괄호!
};

export default AddTodo2;
