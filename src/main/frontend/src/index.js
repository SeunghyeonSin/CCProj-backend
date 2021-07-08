import React from 'react';
import './index.css';
import ReactDOM from 'react-dom';
import App from './App';
import Join from './join/join';
import Login from './login/login';
import Find from './login/find';
import Main from './main/main';
import FB from './main/board/FB';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

ReactDOM.render(
  <React.StrictMode>
     <BrowserRouter>
          <Switch>
            <Route exact path="/" component={App}></Route>
            <Route path ="/join" component={Join}></Route>
            <Route path ="/login" component={Login}></Route>
            <Route path="/find" component={Find}></Route>
            <Route path="/main" component={Main}></Route>
            <Route path="/fb" component={FB}></Route>
          </Switch>
        </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);
reportWebVitals();
