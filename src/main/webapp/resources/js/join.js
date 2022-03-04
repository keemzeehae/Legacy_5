const pwResult= document.getElementById('pwResult');
const pwResult2= document.getElementById('pwResult2');
const pw =document.getElementById('pw');
const pw2 =document.getElementById('pw2');
const id =document.getElementById('id');
const idResult=document.getElementById('idResult');
const name=document.getElementById('name');
const phone=document.getElementById('phone');
const email=document.getElementById('email');

const frm=document.getElementById('frm');
const btn=document.getElementById('btn');

let idCheck=false; //Check가 (필수입력)되면 true , Check 안되면 false
let pwCheck=false;
let nameCheck=false;
let phoneCheck=false;
let emailCheck=false;

pw.addEventListener("change",function(){
    pwCheck=false;
    pw2.value='';
    pw2.focus();
    pwResult2.innerHTML='';
})

btn.addEventListener("click",function(){
    if(idCheck&&pwCheck&&nameCheck&&phoneCheck&&emailCheck){
        frm.submit();
    }else{
        alert('정보를 입력하세요');
    }
})

pw.addEventListener("keyup",function(){
    let n = pw.value.length;  
    if(n<8){
        pwResult.innerHTML="8글자 이상 입력해주세요"
    }else if(8<=n&&n<=12){
        pwResult.innerHTML="사용가능한 비밀번호입니다"
    }
    else if(n>13){
        pwResult.innerHTML="12글자 이하로 입력해주세요"
    };
});

//방법1
id.onblur=function(){
    
    idResult.innerHTML="ID는 필수 입니다";
    idCheck=false;
    if(id.value.length>0){
        idResult.innerHTML="사용가능";
        idCheck=true;
    }
}
//null 도 알수없는 데이터 이지만 자리를 차지하고 있음
//방법2
id.addEventListener("blur",function(){
    let v =id.value;
    if(v.length==0){ //v==''
        console.log('비어있다');
    }else{
        console.log('비어있지 않다');
    }
})

//방법1
pw2.addEventListener("blur",function(){
    
    if(pw.value==pw2.value){
        pwResult2.innerHTML="비밀번호 일치";
        pwCheck=true;
    }else{
        pwResult2.innerHTML="비밀번호 불일치";
        pwCheck=false;
    }

})

//방법2
// pw2.addEventListener("blur",function(){
//     let v=pw.value;
//     let v2 = pw2.value;
//     if(v==v2){
//         pwResult2.innerHTML="비밀번호 일치";

//     }else{
//         pwResult2.innerHTML="비밀번호 불일치"
//     }
// })

name.addEventListener("blur",function(){
    if(name.value==''){
        nameCheck=false;
    }else{
        nameCheck=true;
    }
});

phone.addEventListener("blur",function(){
    if(phone.value==''){
        phoneCheck=false;
    }else{
        phoneCheck=true;
    }

});

email.addEventListener("blur",function(){
    if(email.value==''){
        emailCheck=false;
    }else{
        emailCheck=true;
    }

})

