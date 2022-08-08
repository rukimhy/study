import React from 'react';
import ReactDom from 'react-dom/client';

import Tictactoe from './Tictactoe-hooks';

ReactDom.createRoot(document.querySelector('#root')).render(<Tictactoe />)