//함수형 컴포넌트

import { useState } from 'react';

const Counter = () => {
    let num = 10;
    console.log('렌더링!','num',num);//버튼이 눌릴때마다(값이 바뀔때마다)페이지가 렌더링 되는거 확인해보기
    const [number,setNumber] = useState(0); 
    const plus = () =>{
        num++;//값 바뀌지 않음 페이지 렌더링 될때마다 10으로 초기화
        setNumber(number + 1)
    };
    const minus = () => setNumber(number - 1);
    return(
        <>
            <h1>{number}</h1>
            <button type="button" onClick={plus}>
                +1
            </button>
            <button type="button" onClick={minus}>
                -1
            </button>

        </>
    )
};

export default Counter;