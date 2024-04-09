import classNames from 'classnames';
import React from 'react';
import { Outlet, NavLink } from 'react-router-dom';

const MainLayout = () => {
  return (
    <>
      <header>
        <h1>헤더 영역</h1>
        <div>
          <NavLink
            to="/about"
            className={({ isActive }) => classNames('menu', { on: isActive })}
          >
            ABOUT
          </NavLink>
          <NavLink
            to="/board"
            className={({ isActive }) => classNames('menu', { on: isActive })}
          >
            BOARD
          </NavLink>
        </div>
      </header>
      <main>
        <Outlet />
        {/**중첩된 라우터의 결과물이 출력된다 */}
      </main>

      <footer>
        <h1>footer 영역</h1>
      </footer>
    </>
  );
};

export default React.memo(MainLayout);
