
import { Routes, Route } from 'react-router-dom';
import loadable from '@loadable/component';
//import ScssComponent from "./components/ScssComponent";
//import CSSModule from "./components/CSSModule";
//import LoginForm from "./components/LoginForm";
// import Home from './pages/Home';
// import About from './pages/About';
// import Board from './pages/Board';
// import BoardList from './pages/BoardList';
// import MainLayout from './layouts/MainLayout';
// import NotFound from './pages/NotFound';


const Home = loadable (() => import('./pages/Home'));
const About = loadable(()=> import('./pages/About'));
const BoardList = loadable(()=> import('./pages/BoardList'))
const MainLayout = loadable(()=> import('./layouts/MainLayout'))
const NotFound = loadable(()=> import('./pages/NotFound'))
const App = () => {
  //return <LoginForm />;
  return (
    // <Routes>
    //   <Route index element={<Home />} />
    //   <Route path="/about" element={<About />} />
    //   <Route path='/board' element={<BoardList />}>
    //       <Route path='view/:id' element={<Board/>}/>
    //       {/** /board/biew/:id */}
    //     </Route>
    // </Routes>
    <Routes>
      <Route element={<MainLayout />}>
        {/**메인경로는 path인 /(슬래시)를 아예 생략해도 된다. */}
        <Route index element={<Home />} />{' '}
        {/**상위 라우트의 경로와 동일할때는 path대신 index를 붙여줘도 된다. */}
        <Route path="about" element={<About />} />
        <Route path="board" element={<BoardList />} />
        <Route path="*" element={<NotFound />} />
        {/**앞에 경로들 체크해보고 없는 경로일경우(현재 index와 about경로만 존재) NotFound로 컴포넌트 연동*/}
      </Route>
    </Routes>
  );
};
//헤더푸터를 고정시키고 바뀌는 부분만 중첩된 라우터 이용해서 바꾼다.
export default App;
