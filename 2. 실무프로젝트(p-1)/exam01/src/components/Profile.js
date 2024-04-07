//함수형 컴포넌트

import { useState } from 'react';

const Profile = () => {
  const [data, setData] = useState({
    name: '김수한무',
    age: 29,
  });//초기 상태를 객체 형태로 전달하니까 중괄호로 감쌈

  const changeProfile = () => {
    //리액트에서는 상태를 변경할 때는 상태를 변경함으로써 리렌더링을 유발하는데, 이 과정에서 상태의 참조값이 변경되어야 React가 변경사항을 감지할 수 있다.
    //직접 함수 정의
    setData((x) => {
      console.log('이전 상태값:', x); //변경 전 상태값
      return { ...data, name: '미미름' };
      // 기존의 data 객체를 복사한 후, 이름(name) 속성의 값을 변경한 새로운 객체를 생성하여 반환
    });
  
  };
  const { name, age } = data;
  return (
    <>
      <h1>{name}</h1>
      <h2>{age}</h2>
      <button type="button" onClick={changeProfile}>
        변경
      </button>
    </>
  );
};

export default Profile;
