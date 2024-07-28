import React, {Component} from "react";

//권장사항 -> 파일명과 동일한 클래스, 컴포넌트명 사용
class Buttons2 extends Component{
    render() {

        const {color, children}= this.props;
        //자식쪽에서는 props 데이터를 바꾸지 못하게 동결 상태로 되어있다
        //현재 부모쪽은 app.js

        const styles = {
            background: color,
        }

        //반환값이 컴포넌트에 출력되는 부분
        return (
            <button style={styles}>{children}</button>  
        );
    }
}

export default Buttons2;
