import styles from './CSSModule.module.scss';
import { useState } from 'react';
import classNames from 'classnames/bind'; //클래스 결합

console.log(styles);

const cx = classNames.bind(styles); //this의 범위를 바꾼다. styles로 고정 새로운 함수를 만들어줌(호출은 하지않는다.)
//classNames가 호출될때 styles는 this로 사용될 값이다.
//styles로 지정된 값을 가지고 호출될때마다 동일한 this값을 가지는 새로운 함수인cx가 생성된다.

const CSSModule = () => {
  const [visible, setVisible] = useState(false); //visible값 false로 초기설정
  return (
    <>
      <div className={styles.wrapper}>
        <span className="commonColor">안녕하세요.</span>
        <span className={styles.highlight}>yo</span>
      </div>
      <div className={cx('menus', ['cls1', 'cls2'], { on: visible })}>메뉴</div>{' '}
      {/**on은 참일때만 추가된다(visible)
       * cx 함수를 사용하여 클래스 이름을 결합합니다. menus, cls1, cls2 클래스는 일반적인 문자열로, on 클래스는 상태값 visible에 따라 조건부로 추가됩니다.
       */}
      {/**
       * menus는 css모듈에서 정의된 클래스 이름
       * 배열은 각각의 클래스 이름을 나타냄 배열에 각요소를 병합하여 하나의 문자열로 만듦
       * cx함수를 사용하여 다양한 형태의 클래스를 결합할수있는 형태가 되었다.
       */}
      <button type="button" onClick={() => setVisible(!visible)}>
        클릭
      </button>
    </>
  );
};

export default CSSModule;
