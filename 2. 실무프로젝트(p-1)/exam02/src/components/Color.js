import { Component } from 'react';

class Color extends Component {
  state = {
    color: 'blue',
    subColor: 'black',
  };

  render() { //this -> Color로 생성된 객체의 주소
    // function changeColor(color){
    //     console.log(this);
    // }
    //화살표함수
    const changeColor = (top) => this.setState({ color: top }); //Color
    const changeSubColor = (bottom) =>
      this.setState((prevState) => ({ ...prevState, subColor: bottom })); //새로운객채 만들때 ...전개해서 복사

    const { color, subColor } = this.state;
    return (
      <>
        <div
          style={{ background: color, width: '100px', height: '100px' }}
        ></div>
        <button
          type="button"
          onClick={() => changeColor('red')}
          onContextMenu={() => changeSubColor('red')}
        >
          RED
        </button>
        <button
          type="button"
          onClick={() => changeColor('orange')}
          onContextMenu={() => changeSubColor('orange')}
        >
          ORANGE
        </button>
        <button
          type="button"
          onClick={() => changeColor('green')}
          onContextMenu={() => changeSubColor('green')}
        >
          GREEN
        </button>

        <div
          style={{ background: subColor, width: '50px', height: '50px' }}
        ></div>
      </>
    );
  }
}

export default Color;
