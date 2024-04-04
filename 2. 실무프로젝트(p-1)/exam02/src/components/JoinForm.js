import { useState, useEffect, useRef } from 'react';

const JoinForm = (props) => {
  //일괄 업데이트
  const [form, setForm] = useState({}); //form은 현재 상태를 나타내는 변수이고, setForm은 해당 상태를 업데이트할 수 있는 함수입니다.
  let userIdEl = useRef();

  useEffect(() => {
    //userIdEl.focus();
    //console.log(userIdEl.current);
    userIdEl.current.focus();
  }, [userIdEl]);

  const onChange = (e) => {
    /*
    form[e.currentTarget.name] = e.currentTarget.value;
    //여기서 form은 객체이며, e.currentTarget.name은 속성의 이름을 나타냅니다. 
    //속성을 추가하거나 변경할 때 대괄호 표기법을 사용하는 이유는 변수나 계산된 표현식을 통해 동적으로 속성의 이름을 설정할 수 있기 때문

    setForm({...form,[e.currentTarget.name]: e.currentTarget.value});
    //객체의 복사본을 만들고 해당 복사본에 새로운 속성을 추가하는 방식으로 상태를 업데이트
    */

    /*
    //이 함수는 이전 상태를 변경하지 않고 새로운 상태를 반환하므로, 비동기적 업데이트에 안전한 방식
    //함수를 사용하여 이전 상태를 직접 참조하기 때문에, React는 최신 상태를 보장
    // ...prevForm부분 이전 상태 복사
    setForm((prevForm) => ({
      ...prevForm,
      [e.currentTarget.name]: e.currentTarget.value,
      //e.currentTarget.name은 이벤트가 발생한 요소의 name 속성
      //e.currentTarget.value는 이벤트가 발생한 요소의 현재 값(value),주로 입력 필드에서 사용자가 입력한 값

    }));//e.currentTarget === this, document객체임
    */

    const name = e.currentTarget.name;
    const value = e.currentTarget.value;
    setForm((prevForm) => ({ ...prevForm, [name]: value }));
  };

  //함수 폼이 제출될때 호출되는 함수
  const onSubmit = (e) => {
    //기본적으로 HTML 폼이 제출되면 페이지가 새로고침되거나 다른 페이지로 이동하는 등의 동작을 수행합니다.
    e.preventDefault(); //기본동작 차단, 페이지 이동하지 않고 현재 페이지에 머물러있다.
    //console.log(form);

    setForm({}); //양식 값 비워주기, 가입하기 누르고 나서 양식 초기화됨
    //form 상태를 빈 객체 {}로 설정하여 폼 안의 모든 값들을 초기화
  };

  return (
    <form onSubmit={onSubmit}>
      <dl>
        <dt>아이디({form.userId})</dt>
        <dd>
          <input
            type="text"
            name="userId"
            onChange={onChange}
            value={form.userId ?? ''}
            //ref={(ref) => (userIdEl = ref)} //돔선택
            ref={userIdEl} //userRef사용
          />
        </dd>
      </dl>
      <dl>
        <dt>비밀번호</dt>
        <dd>
          <input
            type="password"
            name="userPw"
            onChange={onChange}
            value={form.userPw ?? ''}
          />
        </dd>
      </dl>
      <dl>
        <dt>비밀번호 확인</dt>
        <dd>
          <input
            type="password"
            name="confirmPW"
            onChange={onChange}
            value={form.confirmPw ?? ''}
          />
        </dd>
      </dl>
      <dl>
        <dt>회원명</dt>
        <dd>
          <input
            type="text"
            name="userNm"
            onChange={onChange}
            value={form.userNm ?? ''}
          />
        </dd>
      </dl>
      <button type="submit">가입하기</button>
    </form>
  );
};

export default JoinForm;
