//클래스형 컴포넌트
//형태가 바뀔때마다 render함수만 계속 호출

import { Component } from "react";

class Counter extends Component{
    //state값 내부정의, 사용할 값 객체형태로
    state = {
        number: 0,
        //number속성에 0이라는 숫자값을 할당해준것
    };
    render(){
        const plus = () => this.setState({number: number + 1});
        const minus = () => this.setState({number: number - 1});


        //비구조화할당
        const { number } = this.state;
        //this.state 객체에서 number 속성을 추출하여 number 변수에 할당
        //this.state.number로 직접 접근하는 대신에 비구조화 할당을 사용하여 number 변수에 해당 값이 할당
        
        return(
            <>
                <h1>{number}</h1>
                <button type="button" onClick={plus}>+1</button>
                <button type="button" onClick={minus}>-1</button>
            </>
        );
    }
}

export default Counter;