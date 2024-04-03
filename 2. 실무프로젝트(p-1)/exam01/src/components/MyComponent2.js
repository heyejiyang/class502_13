import { Component } from "react";
import PropTypes from 'prop-types';

//클래스형 컴포넌트
class MyComponent extends Component{
    static defaultProps= {
        name:'기본이름',
    };

    static propTypes = {
        name: PropTypes.string,
        num: PropTypes.number.isRequired,
    };
    
    render(){
        const{ name,num,children } = this.props;//비구조화 할당
        //console.log(this.props)// app.js에 있는 값 불러오기 
        return(
            <>
                <div>안녕하세요!, 제 이름은 {name}입니다.</div>
                <div>좋아하는 숫자는 {num}입니다.</div>
                {children}
            </>

        );
    }//반환값이 출력되는 결과물
}



export default MyComponent;//모듈 내보내기