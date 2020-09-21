import React from 'react';
import ReactDOM from 'react-dom';
import { CountDownDispatcher, countDownActions, CountdownStore, Countdown } from './count-down';
import { App, colors} from './app';
import './index.css';

const appDispatcher = new CountDownDispatcher()
const actions = countDownActions(appDispatcher)
const store = new CountdownStore(10, appDispatcher)
const render = count => ReactDOM.render(<Countdown count = {count} {...actions}/>, document.getElementById('count-down'))
store.on("TICK", ()=> render(store.getCount()))
store.on("RESET", ()=> render(store.getCount()))
render(store.getCount())

ReactDOM.render(
  <App colors={colors}/>,
  document.getElementById('root'));
