//ID PW 이름 이메일 전화번호
//return
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


let pwCheck=true;//같지 않을 때 true 같으면 false


//pw와 pw2가 같은지 검증
pw2.addEventListener("blur",function(){
    
    let message="비밀번호가 일치합니다"
    if(pw.value!=pw2.value){
        pwCheck=true;
        message="비밀번호가 일치하지 않습니다"// 밖으로 빼준이유는 message에 비밀번호가 일치할때 일치한다고 나오게
        pw2.value='';
        

    }else{
        pwCheck=false;
    }
    pwResult2.innerHTML=message;

})

// 검증이 끝나고 pw를 수정했을 경우
pw.addEventListener('change',function(){
    pwCheck=true;
    pw2.value='';
    pwResult2.value='';
    pw2.focus();
})

// pw  길이 검증
pw.addEventListener("blur",function(){
    if(pw.value.length<8||pw.value.length>12){
        pwResult.innerHTML='비밀번호를 바르게 입력하세요'
        
    }
})


// 아이디 입력 후 
id.addEventListener("blur",function(){
    if(id.value==''){
        idResult.innerHTML='아이디를 바르게 입력하세요';//innerText를 써도 상관없음
        
    }
})


// 가입버튼 클릭했을 때 작동하는 부분
btn.addEventListener("click",function(){
    
    if(id.value==''){
        alert('아이디를 입력하세요');
        id.focus();
        return;
    }
    if(pw.value==''|| pw.value.length<8||pw.value.length>12){
        alert('비밀번호를 바르게 입력하세요');
        pw.focus();
        return;
    }
    if(pwCheck){
        alert('비밀번호가 일치하지 않습니다');
        pw2.focus();
        return;
    }

    if(name.value==''){
        alert('이름을 입력하세요');
        name.focus();
        return;
    }
    if(phone.value==''){
        alert('번호를 입력하세요');
        phone.focus();
        return;
    }
    if(email.value=='') {
        alert('이메일을 입력하세요');
        email.focus();
        return;
    }
   
        frm.submit();
        alert('회원가입 성공');
    

})




