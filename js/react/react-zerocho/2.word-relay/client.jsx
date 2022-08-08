const React = require('react');
const ReactDom = require('react-dom');

const WordRelay = require('./WordRelay-hooks');

ReactDom.render(<WordRelay />, document.querySelector('#root'));