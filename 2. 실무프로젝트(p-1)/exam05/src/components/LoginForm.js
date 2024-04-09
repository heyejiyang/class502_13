import styled, { css } from 'styled-components';
import { BigButton } from './commons/ButtonStyle';

const commonStyle = css`
  width: 100%;
`;
/**
 * 공통된 css 스타일 적용시키는 함수
 */

const OuterBox = styled.div`
  ${commonStyle}
  position: fixed;
  height: 100%;
  left: 0;
  top: 0;
  display: flex;
  align-items: center;
`; /**
 * form박스 전체를 감싸는 부분
   보이는 화면 내에서 정 가운데 오도록
   position fixed, fixed는 보이는 화면 기준 꽉차게
   가운데 배치
   display: flex;
    align-items: center; 

 */

const FormBox = styled.form`
  width: 420px;
  margin: 0 auto;

  h1 {
    text-align: center;
  }
`; /**form함수
    역따옴표 안에 있는건 매개변수로 전달
    margin: 0 auto; -> 좌우 가운데 정렬
    form태그 안쪽에 h1(로그인 글자) 스타일 적용
*/

const InputBox = styled.input`
  ${commonStyle}
  display: block;
  height: 45px;
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 0 10px;

  & + & {
    margin-top: 5px;
  }
`;
/**
 * 내가 구성하고자 하는 태그를 속성형태로 넣어주게되면(styled.input) 해당 태그로 jsx형태의 컴포넌트가 생성됨
태그함수!!!!
스타일 입히면서 컴포넌트로 만드는 방법임
input태그의 요소 선택 & 첫번째꺼(현재요소)에서 인접 형제 '&' + &'(첫번째꺼 제외하고 인접형제들) 
'+'하면 인접형제 의미

 * 
 */

const LoginForm = () => {
  return (
    <OuterBox>
      <FormBox autoComplete="off">
        <h1>로그인</h1>
        {/**
         * placeholder: input 힌트
         * 스타일을 입히면서 적용된 input태그가 완성
         * 버튼은 공통스타일이 있고 따로 빼주는게 일반적, 파일 만들어서 버튼 만들고 적용시켜주자
         *
         */}
        <InputBox type="text" placeholder="아이디" />
        <InputBox type="password" placeholder="비밀번호" />
        <BigButton type="submit" selected={true}>
          로그인
        </BigButton>
      </FormBox>
    </OuterBox>
  );
};

export default LoginForm;
