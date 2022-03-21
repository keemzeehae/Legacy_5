const reply=document.querySelector("#reply");
const num=document.querySelector("#num");
const writer=document.querySelector("#writer");
const contents=document.querySelector("#contents");
const replyResult=document.querySelector("#replyResult");
    

result();

function result(){
    const xhttp=new XMLHttpRequest();
    xhttp.open("GET","../noticeReply/list");
    xhttp.send();
}

reply.addEventListener("click",function(){

    console.log(num.value);
    console.log(writer.value);
    console.log(contents.value);
   //JS에서 요청객체 생성(준비)
   const xhttp=new XMLHttpRequest();

   //요청정보 입력
   xhttp.open("POST","../noticeReply/add");

   //요청 header정보
    xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

   //요청전송
   //post 요청시 파라미터 
   // xhttp.send("이름="+값+"&이름="+값+"&이름="+값)
   xhttp.send("num="+num.value+"&writer="+writer.value+"&contents="+contents.value);

   //응답 처리 
   xhttp.onreadystatechange=function(){
       if(this.readyState==4 && this.status==200){
        console.log(this.responseText);
        let result=this.responseText.trim();
        if(result=='1'){
            alert("댓글이 등록되었습니다.");
        }else{
            alert("댓글 등록 실패");
        }
       }
   }

})