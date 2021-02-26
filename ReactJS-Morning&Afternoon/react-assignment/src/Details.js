import React, {useState, useEffect, Component} from 'react';
import axios from 'axios';
import {Table, Button, Modal, ModalHeader, ModalBody, ModalFooter, FormGroup, Label, Input} from 'reactstrap';
import { render } from 'react-dom';
import {Link, useParams} from 'react-router-dom';
import {books} from './Book';

export function Details(props) {
    /*
    useEffect( ()=> {
      fetchBook();
  },[]);
  
  const [book,setItem]=useState([]);
  
  const fetchBook= async () =>{
      const bid=props.match.params.id;
      const fetchBook= await fetch('http://localhost:3000/bookLib/'+bid);
      const book= await fetchBook.json();
      setItem(book);
  };
  */

 let { id } = useParams();
 let i = id;
 let bname = books[i].name;
 let bauthor = books[i].author;
 let boverview = books[i].overview;
 let burl =books[i].url;

  return (
      <div>
          <center>
          Title: {bname} <br></br>
          <img src={burl} alt="Logo" width='300px' height='300px' /> <br></br>
          </center>
          Author: {bauthor}<br></br>
          Overview: {boverview}<br></br>
          
         <center><Link to="/"><button>Back to home!</button></Link></center> 
      </div> 
  )
  }