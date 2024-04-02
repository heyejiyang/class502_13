const App = () => {
  const name = 'js';
  /*const name = 'React';*/

  const style = {
    backgroundColor: 'yellow',
    color: 'purple',
    height: '100px',
  };

  return (
    <>
      <div className="subject" style={style}> 첫번째 컴포넌트!!!</div>
      <div style={{color:'blue'}}>씽나는, {name && name} 공부</div>
      {name === 'React' && <h1>장덩둥!</h1>}
      <input type="text" />
    </>
  );
};
export default App;
