***
### react 준비
1. `npm init`
2. `npm install react react-dom`
***
### 웹팩
* `npm install -D webpack webpack-cli`
***
### 웹팩 빌드
1. package.json 안의 "scripts"를 `{"dev": "webpack"}`로 바꾸고
2. `npm run webpack`
2. or
2. `npx webpack`
***
### 웹팩에 바벨 탑재
* `npm i -D @babel/core @babel/preset-env @babel/preset-react babel-loader`
***
### 리액트 웹팩 핫 리로딩
1. `npm i -D react-refresh @pmmmwh/react-refresh-webpack-plugin webpack-dev-server`
2. package.json 안의 "scripts"를 `{"dev": "webpack serve --env development"}`로 바꾸고
3. webpack.config.js 안의 plugins 바꾸기
***
### require vs import
`const React = require('react');`
* require : node의 모듈시스템

`import React from 'react';`
* import, export : react의 모듈시스템, babel이 해결해줌
***
### 성능 문제 해결
1. class일 경우 - `PureComponent` & `shouldComponentUpdate`
2. hooks일 경우 - `memo` & `useMemo`
***
### class 형식일 때 배열 추가
* prevState를 이용한다.
```js
state = { result: [] }
this.setState((prevState) => { 
	return { result: [...prevState, value] } 
})
```
***
### useState vs useRef
1. state의 경우 return 부분이 다시 실행됨
2. ref의 경우 return 부분이 다시 실행되지 않음
***
### 라이프사이클
* class의 경우
	1. constructor -> render -> ref -> componentDidMount
	2. (setState/props 바뀔때) -> shouldComponentUpdate(return true) -> render -> componentDidUpdate
	3. (부모가 나를 없앴을 때) -> componentWillUnmount -> (소멸)
* hooks의 경우
	1. useEffect
	2. []가 빈 배열이면 componentDidMount와 동일
	3. 배열에 요소가 있으면 componentDidMount와 componentDidUpdate 둘 다 수행
	4. return이 componentWillUnmount와 동일
```js
useEffect(()=>{
	return () => {};
}, []);
```
***
### useRef vs useMemo vs useCallback
1. useRef : 일반 값을 기억
2. useMemo : 복잡한 합수 결과값을 기억
3. useCallback : 함수 자체를 기억, 자식에게 넘겨줄 때 필요
***
#### hooks
1. hooks는 조건문 안에 절대 넣으면 안된다.
2. 함수나 반복문 안에도 웬만하면 넣지 마라.
***
#### Context API
* dispatch props를 부모 거쳐거쳐서 받는 게 아니라 바로 받을 수 있음
***
### React Router
* `npm install react-router react-router-dom`
* 웹 -> `react-router-dom`
* 앱 -> `react-router-native`
***
