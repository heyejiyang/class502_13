import React from 'react'; //뒤에 /index.js 가 붙어있는데 생략 가능하고 모듈명만 입력해도 된다.
import ReactDOM from 'react-dom/client';//from 뒤에 있는 것: 모듈 경로
import './index.css'; // 내가 정의 한 자원(프로젝트 내부 소스)들은 ./(현재경로)하고 불러올 수 있다.
//./없으면 외부에서 불러온 라이브러리임 예를들어 node_modules파일 -> D:\양예지\2. 실무프로젝트(p-1)\hello\node_modules\react
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
