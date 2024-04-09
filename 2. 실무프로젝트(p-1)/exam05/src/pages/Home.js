import React, { Suspense, useState } from 'react';
import { Link, Navigate } from 'react-router-dom';
//import MessageBox from '../components/commons/MessageBox';
import styled from 'styled-components';
import loadable from '@loadable/component';

//const MessageBox = React.lazy(() => import('../components/commons/MessageBox'));
const MessageBox = loadable(() => import('../components/commons/MessageBox'),{
  fallback: <div>로딩중...</div>
});

// const MessageBox2 = styled(MessageBox)`
//   background: yellow;
// `;

/**홈 화면 */
const Home = () => {
  const [visible, setVisible] = useState(false);

  // const result = true;
  // if (result) {
  //   return <Navigate to="/about" replace={true}/>;//방문기록x
  // }
  return (
    <div>
      <h1>HOME</h1>
      <div>메인 페이지</div>
      <div>
        <Link to="/about">회사 소개</Link>
        {/* <MessageBox2>메시지</MessageBox2> */}
        {/* <Suspense fallback={<div>로딩중...</div>}>
          {visible && <MessageBox>메시지!!!</MessageBox>}
        </Suspense> */}
        {visible && <MessageBox>메시지이</MessageBox>}
        <button type="button" onClick={() => setVisible(true)}>
          보이기
        </button>
      </div>
    </div>
  );
}; /**
* 링크 누르면 회사소개 컴포넌트로 이동한다 로딩없이
 질의형 데이터 querystring
*/

export default React.memo(Home); //자식 컴포넌트도 부모가 바뀌면 바뀐다. 변경된게 없으면 다시 불러지지 않도록 메모제이션!!! 항상
