import { Component } from 'react';

//에러발생했을때
class ErrorProcess extends Component {
  state = {
    isError: false,
    message: '',
  };
  componentDidCatch(error, info) {
    console.error(error,info);
    this.setState({ isError: true, message: error.message });
  }

  render() {
    //에러 발생했을때 다른 컴포넌트로 분기
    const { isError, message } = this.state;
    const { children } = this.props;//에러발생하지 않았을때
    return isError ? <div>{message}</div> : children;
  }
}

export default ErrorProcess;
