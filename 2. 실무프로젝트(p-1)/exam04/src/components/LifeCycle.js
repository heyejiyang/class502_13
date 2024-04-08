import { Component } from 'react';
/**클래스형 컴포넌트 */
class LifeCycle extends Component {
  state = {
    number: 0,
  };

  constructor(props) {
    super(props); //상위쪽인 Component에서 props 받아옴

    console.log('constructor');
  }

  static getDerivedStateFromProps(prevProps, prevState) {
    console.log('getDerivedStateFromProps');
    if (prevProps.mode === 'even' && prevState.number % 2 === 1) {
      return { number: prevState.number + 1 };
    }

    return null;
  }

  shouldComponentUpdate(props, state) { //반환값을가지고 렌더링 여부설정
    //return state.number % 3 !== 0;
    return true;
    /*
    if (state.number % 3 === 0) {
      
      return false;
    }

    return true;
    */
  }

  componentDidMount() { //한번만 호출
    console.log('componentDidMount');
  }

  getSnapshotBeforeUpdate(props, state) {
    console.log('getSnapshotBeforeUpdate');

    return { value: 100 };
  }

  componentDidUpdate(props, state, snapshot) { //갱신된때마다 매번 호출
    console.log('componentDidUpdate');
    console.log('snapshot', snapshot);
  }

  componentWillUnmount() {
    console.log('componentWillUnmount');
  }

  render() {
    console.log('render');
    const { number } = this.state;
    //number.abc();

    return (
      <>
        <h1>{number}</h1>
        <button
          type="button"
          onClick={() => this.setState({ number: number + 1 })}
        >
          +1
        </button>
        <button
          type="button"
          onClick={() => this.setState({ number: number - 1 })}
        >
          -1
        </button>
      </>
    );
  }
}

export default LifeCycle;