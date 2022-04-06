import { useState } from 'react';
import './App.css';
import logo from './logo.svg';

function App() {

  let posts = "강남 고기 맛집";

  function fn() {
    return 100;
  }

  let [글제목, 글제목변경] = useState(['남자 코트 추천', '우동 맛집 추천', '감자 음식점']);
  let [따봉, 따봉변경] = useState(0);

  function 제목바꾸기() {
    let newArray = [...글제목];
    newArray[0] = '여자 코트 추천';
    newArray.sort();
    글제목변경(newArray);
  }

  return (
    <div className="App">

      <div className="black-nav">
        <div className={posts}>개발 Blog</div>
      </div>

      <h4 style={{ color: 'blue', fontSize: '30px' }}>{posts}</h4>
      <h4>{fn()}</h4>

      <button onClick={제목바꾸기}>남자💨여자💨정렬</button>

      <div className="list">
        <h3> {글제목[0]} <span onClick={() => { 따봉변경(따봉 + 1) }}>👍</span> {따봉} </h3>
        <p>2월 17일 발행</p>
        <hr />
      </div>
      <div className="list">
        <h3> {글제목[1]}</h3>
        <p>2월 18일 발행</p>
        <hr />
      </div>
      <div className="list">
        <h3> {글제목[2]}</h3>
        <p>2월 19일 발행</p>
        <hr />
      </div>

      <Modal />

      <img src={logo} />
    </div >
  );
}

function Modal() {
  return (
    <div className="modal">
      <h2>제목</h2>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  )
}

export default App;
