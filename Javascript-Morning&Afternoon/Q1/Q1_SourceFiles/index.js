function submit(){
    let inputFieldValue = document.getElementById("text");
    console.log("Input string value abstracted");

    console.log("Now checking number presence in string");
    let flag=0;
    for(let i=0;i<inputFieldValue.value.length;i++){
        let c=inputFieldValue.value.charAt(i);
        if(c==="0"||c==="1"||c==="2"||c==="3"||c==="4"||c==="5"||c==="6"||c==="7"||c==="8"||c==="9"){
            flag=1;
        }
    }
    

    if(flag===1){
        console.log("Error: Number present in string!");
        document.getElementById("inputLabel1").innerText="Error: Number present in string!";
        document.getElementById("inputLabel2").innerText="";
        document.getElementById("inputLabel3").innerText="";
        document.getElementById("inputLabel4").innerText="";
        document.getElementById("inputLabel5").innerText="";
    }
    else{
        console.log("Number not present in string");

        console.log("Calculating length of string..");    
    document.getElementById("inputLabel1").innerText="Length of string = "+inputFieldValue.value.length;

    console.log("Converting string to upper case..");    
    document.getElementById("inputLabel2").innerText="Conversion to Upper Case = "+inputFieldValue.value.toUpperCase();

    console.log("Converting string to lower case..");    
    document.getElementById("inputLabel3").innerText="Conversion to Lower Case = "+inputFieldValue.value.toLowerCase();

    console.log("Separating consonants and vowels..");    
    let consonants="";
    let vowels="";
    
    for(let i=0;i<inputFieldValue.value.length;i++){
        let c=inputFieldValue.value.charAt(i);
        if(c==="a"||c==="e"||c==="i"||c==="o"||c==="u"||c==="A"||c==="E"||c==="I"||c==="O"||c==="U"){
            vowels+=c;
        }
        else{
            consonants+=c;
        }
    }
    document.getElementById("inputLabel4").innerText="Consonants = "+consonants;
    document.getElementById("inputLabel5").innerText="Vowels = "+vowels;
}

}