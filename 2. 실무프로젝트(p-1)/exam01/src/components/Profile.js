//함수형 컴포넌트

import { useState } from 'react';

const Profile = () => {
  const [data, setData] = useState({
    name: '김수한무',
    age: 29,
  });

  const changeProfile = () => {
    //직접 함수 정의
    setData((state) => {
      console.log('이전 상태값:', state); //변경 전 상태값
      return { ...data, name: '미미름' };
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
