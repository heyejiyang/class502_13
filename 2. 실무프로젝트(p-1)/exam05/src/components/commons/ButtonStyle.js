import styled, { css } from 'styled-components';

export const BigButton = styled.button`
  width: 100%;
  height: 45px;
  border: 0;
  font-size: 1.5rem;
  font-weight: bold;
  background: ${({ bgcolor }) => bgcolor ?? '#C1AEEE'};

  ${({ selected, bgcolor }) =>
    selected &&
    css`
      border: 1px solid ${bgcolor ?? 'skyblue'};
      background: #fff;
    `}
`;
/**
 * background: ${(props) => props.bgcolor ?? '#C1AEEE'};
 * props객체도 styled.button함수 안에서 넘어온 값 내부에서 매개변수로 props값을 넘겨준다!
 * 함수만 정의해도 내부에서 props값을 넘겨줌...
 * 정의된 색상이 없다면 기본값 지정해주기
 * 
 * props 비구조할당해주자
 *  background: ${({bgcolor}) => bgcolor ?? '#C1AEEE'};
 * 
 * 
 * 함수만 정의하면 무조건 호출되고 무조건 props값이 넘어온다!!! ${}
 * function키워드 대신 '=>' 함수
 * 조건식 필요할땐 삼항조건이나 &&연산자
 * 
 * ${(props) => props.selected && css`
  
  `} //여기서 css는 props.selected 이게 true일때만 적용된다.

  ${({selected, bgcolor}) => selected && css`
  `} // 비구조할당하기
 */
