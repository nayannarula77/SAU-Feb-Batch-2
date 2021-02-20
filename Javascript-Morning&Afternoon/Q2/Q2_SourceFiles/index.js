class Student{
constructor(firstName, lastName, age, gender, rollno, dob,email){
this.firstName=firstName;
this.lastName=lastName;
this.age=age;
this.gender=gender;
this.rollno=rollno;
this.dob=dob;
this.email=email}
}

let students=[];

function validateemail(x)  
{  

var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){    
  return true;  
  }  
}  


function submit(){
    
    console.log("Validating all input fields..");
    if(document.getElementById("textfn").value===""||document.getElementById("textln").value===""||document.getElementById("textage").value===""||(document.getElementById("male").checked === false&&document.getElementById("female").checked === false)||document.getElementById("textrn").value===""||document.getElementById("textdob").value===""||document.getElementById("textemail").value===""||document.getElementById("occupation").value==="")
    document.getElementById("inputLabel11").innerText="Error: Enter all fields!";
    else if(validateemail(document.getElementById("textemail").value))
    document.getElementById("inputLabel12").innerText="Error: Incorrect email format!";
    else{

        console.log("All input fields validated..");
        document.getElementById("inputLabel11").innerText="Details submitted successfully!";
        document.getElementById("inputLabel12").innerText="";

        console.log("Abstracting input values..");
let fn=document.getElementById("textfn").value;
let ln=document.getElementById("textln").value;
let age=document.getElementById("textage").value;

let gender;
if(document.getElementById("male").checked === true)
gender="Male";
else{
    gender="Female";
}

let rollno=document.getElementById("textrn").value;
let dob=document.getElementById("textdob").value;
let email=document.getElementById("textemail").value;

console.log("Creating object..");
let s = new Student(fn,ln,age,gender,rollno,dob,email);
s.Occupation=document.getElementById("occupation").value;

console.log("Pushing created object into the array..");
students.push(s);
console.log(s);
    }
}

function get(){
    let index=document.getElementById("textget").value;

    console.log("Fetching details..");
    let details="";
details+="First Name= "+students.find(students => students.rollno === index).firstName;
details+="\n Last Name= "+students.find(students => students.rollno === index).lastName;
details+="\n Age= "+students.find(students => students.rollno === index).age;
details+="\n Gender= "+students.find(students => students.rollno === index).gender;
details+="\n Roll Number= "+students.find(students => students.rollno === index).rollno;
details+="\n Date of birth= "+students.find(students => students.rollno === index).dob;
details+="\n Occupation= "+students.find(students => students.rollno === index).Occupation;
details+="\n Email= "+students.find(students => students.rollno === index).email;

console.log("Displaying details..");
    document.getElementById("inputLabel10").innerText=details;

}

