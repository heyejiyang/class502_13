import { useState, useEffect, useRef } from 'react';

const JoinForm = (props) => {
  //일괄 업데이트
  const [form, setForm] = useState({}); //form은 현재 상태를 나타내는 변수이고, setForm은 해당 상태를 업데이트할 수 있는 함수입니다.
  let userIdEl = useRef();
  /**useRef 훅을 사용하여 userIdEl이라는 Ref를 생성
   * 이 Ref는 나중에 사용자 아이디 입력 필드를 참조하기 위해 사용
   * useRef를 사용하면 ref 속성을 통해 해당 DOM 요소에 접근
   * userIdEl이라는 Ref를 사용하여 입력 필드에 접근하고, 해당 입력 필드에 포커스를 줄 수 있습니다.
   */

  useEffect(() => {
    //userIdEl.focus();
    console.log(userIdEl.current);
    userIdEl.current.focus();
    /**useRef를 사용하여 Ref를 생성하고, current 속성을 통해 해당 DOM 요소에 접근
     * current 속성은 useRef를 사용하여 참조한 대상에 대한 현재 값
     */
  }, [userIdEl]);
  /**
   * useEffect 훅에서 대괄호([])는 의존성 배열(dependency array)을 나타냅니다. 이 배열은 useEffect의 콜백 함수가 실행되어야 하는 조건을 지정합니다.
   * 대괄호가 비어있는 경우([]), 콜백 함수는 컴포넌트가 처음 마운트될 때 한 번만 실행
   * [userIdEl]은 userIdEl이 변경될 때마다 useEffect의 콜백 함수가 실행되어야 함을 의미
   * 그러나 userIdEl은 useRef를 사용하여 생성된 객체이며, 이 객체 자체는 변경되지 않습니다. 따라서 실제로는 userIdEl.current이 변경될 때마다 useEffect의 콜백 함수가 실행됩니다.
   * useEffect의 콜백 함수는 컴포넌트가 처음으로 렌더링될 때 한 번 실행되고, 그 후에는 실행되지 않습니다.
   */

  const onChange = (e) => {//입력필드 값이 변경될때 호출되는 콜백함수
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
    //해당 입력 필드의 name 속성을 키로 하고 사용자가 입력한 값을 값으로 하는 새로운 객체를 생성하여 form 상태를 업데이트
    //객체의 속성 이름을 동적으로 설정하기 위해 대괄호 표기법(computed property name)을 사용
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
            ref={userIdEl} //userIdel이라는 ref를 사용하여 input요소에 접근
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
