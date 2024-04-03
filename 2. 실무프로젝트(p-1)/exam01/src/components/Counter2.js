//클래스형 컴포넌트
//형태가 바뀔때마다 render함수만 계속 호출

import { Component } from "react";

class Counter extends Component{
    //state값 내부정의, 사용할 값 객체형태로
    state = {
        number: 0,
    };
    render(){
        const plus = () => this.setState({number: number + 1});
        const minus = () => this.setState({number: number - 1});


        //비구조화할당
        const { number } = this.state;
        
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