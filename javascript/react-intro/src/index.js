import React from 'react';
import ReactDOM from 'react-dom';
import {App, colors} from './app';
import './index.css';


// ReactDOM.render(
//   <StarRating totalStars = {totalStars}/>,
//   document.getElementById('root'));

ReactDOM.render(
  <App colors={colors}/>,
  document.getElementById('root'));
