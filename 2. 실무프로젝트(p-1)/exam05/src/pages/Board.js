/**경로변수 url 파라미터 */

import React from 'react';
import { useParams, useLocation, useSearchParams } from 'react-router-dom';

const posts = {
  post1: {
    subject: '게시글1번',
    content: '게시글1번 내용',
  },
  post2: {
    subject: '게시글2번',
    content: '게시글2번 내용',
  },
};

const Board = () => {
  const { id } = useParams();
  const data = posts[`post${id}`]; //해당 데이터 가져오기

  //const [searchParams, setSearchParams] = useSearchParams();
  //console.log(searchParams.get('key1'));
  //setSearchParams('k1=v1&k2=v2');
  //console.log(searchParams.toString());

  //const location = useLocation();
  //console.log(location);
  return (
    <>
      {data ? (
        <>
          <h1>{data.subject}</h1>
          <div>{data.content}</div>
        </>
      ) : (
        <div>게시글이 없습니다.</div>
      )}
    </>
  );
};

/**
 * const Board = () => {
  const params = useParams();
  const id = params.id;
  return <h1>게시글</h1>;
};  -->  비구조할당으로 바꾸기 id

 게시글이 없을때는 없다는 내용 출력시켜주자 안그럼 없는 게시글찾을때 오류난다.
 삼항조건 혹은 참인경우를 볼때 &&

 */

export default React.memo(Board);
