import './App.css';
import logo from './logo.svg';

function App() {

  let posts = "강남 고기 맛집";

  function fn() {
    return 100;
  }

  return (
    <div className="App">
      <div className="black-nav">
        <div className={posts}>개발 Blog</div>
      </div>
      <img src={logo} />
      <h4 style={{ color: 'blue', fontSize: '30px' }}>{posts}</h4>
      <h4>{fn()}</h4>
    </div >
  );
}

export default App;
