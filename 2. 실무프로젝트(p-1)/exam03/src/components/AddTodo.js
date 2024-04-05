/**할 일 기록 컴포넌트 양식/ 프리젠테이셔널 컴포넌트 */

import { MdOutlineAdd } from 'react-icons/md'; //플러스 아이콘

const AddTodo = ({ onSubmit, onChange, todo, message }) => {
  return (
    <form onSubmit={onSubmit} autoComplete="off">
      {/**자동완성 끄기 */}
      <input type="text" value={todo ?? ''} onChange={onChange} />
      <button type="submit">
        {/**버튼에 +아이콘 */}
        <MdOutlineAdd />
      </button>
      {message && <div>{message}</div>} {/**메시지가 있으면 message출력 */}
    </form>
  ); //jsx문법 소괄호!
};

export default AddTodo;
