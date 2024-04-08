import styles from './CSSModule.module.scss';
import { useState } from 'react';
import classNames from 'classnames';

console.log(styles);

const CSSModule = () => {
  const [visible, setVisible] = useState(false); //visible값 false로 초기설정
  return (
    <>
      <div className={styles.wrapper}>
        <span className="commonColor">안녕하세요.</span>
        <span className={styles.highlight}>yo</span>
      </div>
      <div className={classNames('menus', ['cls1', 'cls2'], { on: visible })}>
        메뉴
      </div>{' '}
      {/**on은 참일때만 추가된다(visible) */}
      <button type="button" onClick={() => setVisible(!visible)}>
        클릭
      </button>
    </>
  );
};

export default CSSModule;
