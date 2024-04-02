import PropTypes from 'prop-types';//자료형 한정 (경고를뜨게해줌)

const MyComponent = ({name, num}) => {//더 짧게 매개변수로 분해해서 쓰자
    return( 
    <>
        <div>안녕하세요!, 제 이름은 {name}입니다.</div>
        <div>제가 좋아하는 숫자는 {num}입니다. </div>
    </>
    );
};

MyComponent.defaultProps = { //값이 없을때 기본값 설정
    name:'기본이름이다 냥',
};

MyComponent.propTypes = { //문자열이 아니면 경고뜨게한다.
    name: PropTypes.string,
    num: PropTypes.number.isRequired,
}

export default MyComponent;