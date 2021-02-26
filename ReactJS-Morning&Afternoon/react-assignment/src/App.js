import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router , Route, Switch, Link } from 'react-router-dom';
import {books} from './Book';
import axios from 'axios';
import React, {useState, useEffect, Component} from 'react';
import {Details} from './Details';


function App() {

  


return (
<Router>
    <Switch>
          <Route path="/:id">
            <Details />
          </Route>
          <Route path="/">
            <Home />
          </Route>
        </Switch>
    </Router>
  );
}

function Home() {

  const [searchTerm, setSearchTerm] = useState("");



  const booklist = books.filter((val)=>{
    if(searchTerm==""){
      return val
    }
    else if(val.name.toLowerCase().includes(searchTerm.toLowerCase())){
      return val
    }
  }).map((book) => (
    <div>
      <h1>{book.name} <Link to={'/'+ book.id}><button>Click</button></Link></h1>
      </div>
      ));
    
      return (
    
    
        <div className="App">

        <input type="text" placeholder="Search..." onChange={(event)=>{
            setSearchTerm(event.target.value);
        }} />
<center><h1>Available books:</h1></center>
          {booklist}
          
        </div>
      )
}



export default App;
