// import { Fragment } from "react"; //핵심적인 함수나 컴포넌트 포함
import Buttons from "./components/buttons";

function App() {
  //반환값이 태그 한개인 형태일때는 소괄호 생략 가능
  //return <h1>안녕하세요</h1>

  /*
  return (
    <h1>안녕하세요</h1>
    <h2>반갑습니다.</h2>
  );
  */
  
  const name = "";
  //자바스크립트 표현식을 작성하려면 JSX 내부에서 코드를 {}로 감싸면 된다.

  return (
    <>
      {name && <h1>{name}님 안녕하세요</h1>}
      <h2>반갑습니다</h2>
      <Buttons /> {/* 단일태그도 끝나는 태그가 있어야 한다 */}
    </>
  )


}

export default App;