import { Component } from '@angular/core';
import {  FormGroup, FormControl, FormsModule } from '@angular/forms';
import { Validators } from '@angular/forms';
import * as _ from 'lodash';

class Person{
firstname:string;
lastname:string;
contactnumber:number;
dob:Date;
city:string;
pincode:number;
constructor(firstname:string,lastname:string,contactnumber:number,dob:Date,city:string,pincode:number){
this.firstname=firstname;
this.lastname=lastname;
this.contactnumber=contactnumber;
this.dob=dob;
this.city=city;
this.pincode=pincode;
}

}


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
   collection: Person[] = [];

  title = 'angassignment';
  profileForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('',Validators.required),
    contactnumber: new FormControl('',Validators.compose([Validators.minLength(10),Validators.maxLength(10), Validators.required])),
    dob: new FormControl('',Validators.required),
    city: new FormControl('',Validators.required),
    pincode: new FormControl('', Validators.compose([Validators.minLength(6),Validators.maxLength(6), Validators.required]))});

add(){
  let values=this.profileForm.value;
  //console.log(values.firstName);
//let s = new Person("nayan","tft",543,new Date(Date.now()),"ygtfr",54);
console.log(values.firstName);
let s = new Person(values.firstName,values.lastName,values.contactnumber,values.dob,values.city,values.pincode);

this.collection.push(s);
console.log(this.collection.indexOf(s));
}

deleterec(ind:number){
this.collection.splice(ind,1);
}

sortbyfname(){
  this.collection=_.sortBy(this.collection,'firstname');
  console.log(this.collection);
}

sortbylname(){
  this.collection=_.sortBy(this.collection,'lastname');
  console.log(this.collection);
}

sortbycontactnumber(){
  this.collection=_.sortBy(this.collection,'contactnumber');
  console.log(this.collection);
}

sortbydob(){
  this.collection=_.sortBy(this.collection,'dob');
  console.log(this.collection);
}

sortbycity(){
  this.collection=_.sortBy(this.collection,'city');
  console.log(this.collection);
}

sortbypincode(){
  this.collection=_.sortBy(this.collection,'pincode');
  console.log(this.collection);
}


}
