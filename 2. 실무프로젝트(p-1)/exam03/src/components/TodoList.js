/**등록한 내용이 보이게 하는곳 / 프리젠테이셔널 컴포넌트*/

import { MdCheckBox, MdCheckBoxOutlineBlank } from 'react-icons/md'; // 체크박스 아이콘
import { FaRegTrashCan } from 'react-icons/fa6'; //휴지통아이콘

const TodoList = ({ items, onToggle, onRemove }) => {
  return (
    <ul>
      {items.map(({ id, title, done }) => (
        <li key={id}>
          <span onClick={() => onToggle(id)}>
            {done ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
            {title}
          </span>

          <button type="button" onClick={() => onRemove(id)}>
            <FaRegTrashCan />
          </button>
        </li>
      ))}
      {/** 자바스크립트함수쓸라면 중괄호 필요함
       * item.id 이런식으로 하기 넘 복잡하다 짧게 쓰려고 map안에 비구조할당 소괄호로 감싸자
       * li태그에 키값! 키값은 항상있어야함
       * 태그 안에는 제목 넣어줄거, 체크박스
       * done이 참이면 체크박스 보여주고 체크 안되어잇으면 비어있게
       * span태그 클릭시 토글기능 되도록
       * 휴지통 버튼 추가
       *  */}
    </ul>
  );
};

export default TodoList;
