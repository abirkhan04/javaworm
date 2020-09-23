import { faExpand } from '@fortawesome/free-solid-svg-icons';
import React from 'react';
import ReactDOM from 'react-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import './index.css';
// import App from './App';
import * as serviceWorker from './serviceWorker';

const navItems =  [{
  title : 'Item 1',
  url: 'url1',
  children: [
    {
      title: 'child item 1',
      url: 'child url 1',
      children: [
        {
          title: 'child item 2',
          url: 'child url 2'
        }
      ]
    }
  ] 
},
{
  title: "item2",
  url: "url2",
  children: []
}]

const navItemStyle = {
  marginTop: "10px",
  marginLeft: "20px",
  lineHeight: "30px"
}

const Navigation = ({navItem}) => {
  const nestedItem = (navItem.children || []).map(navItem => {
    return <Navigation key={navItem.title} navItem={navItem} type="child"/>
  })

  return (
    <div style={navItemStyle}>
      <div><FontAwesomeIcon icon={faExpand} /> &nbsp;{navItem.title}</div>
      {nestedItem}
    </div>
  )
}

class  SideNavigation extends React.Component {
  constructor(props) {
    super();
  }
  render() {
  return (
    <div style={{width: "200px", backgroundColor: "cyan"}}>
      {
        this.props.navItems.map((navItem)=> {
          return (
            <Navigation key={navItem.title} navItem={navItem}/>
          )
        })
      }
    </div>
  )
  }
}

const App = () => {
  return (<SideNavigation  navItems = {navItems}/>)
}


ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

serviceWorker.unregister();
