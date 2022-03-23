const reply=document.querySelector("#reply");
const num=document.querySelector("#num");
const writer=document.querySelector("#writer");
const contents=document.querySelector("#contents");
const replyResult=document.querySelector("#replyResult");
// const del=document.querySelectorAll(".del");
// const update=document.querySelectorAll(".update");

//-----------------**UPDATE**------------------
replyResult.addEventListener("click",function(event){

    if(event.target.classList.contains("update")){

        // event.target.classList.replace("update","reply");

        // console.log(event.target.parentNode.previousSibling.previousSibling.previousSibling.previousSibling);
       let num=event.target.getAttribute("data-index");//num
       let replynum=document.querySelector("#up"+num);//td

    
       let text=replynum.innerText;
       replynum.innerText='';


       let tx= document.createElement('textarea');
       tx.setAttribute("id","update"+num);
       tx.classList.add("reply");
       tx.setAttribute("data-num",num);
       tx.value=text;

       console.log(tx);
       replynum.append(tx);
        
    }

});

replyResult.addEventListener("change",function(event){
    if(event.target.classList.contains("reply")){
        let contents= event.target.value;
        let updateNum= event.target.getAttribute("data-num");

        let check=window.confirm("수정하시겠습니까?");
        //확인 : true / 취소 : false
        if(check){
        const xhttp=new XMLHttpRequest();
        xhttp.open("POST","../noticeReply/update");
        xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

        xhttp.send("replynum="+updateNum+"&contents="+contents);

        xhttp.onreadystatechange=function(){

            if(this.readyState==4&&this.status==200){
                console.log(this.responseText);
                if(this.responseText.trim()=='1'){
                    alert("수정되었습니다.");
                    document.querySelector("#up"+updateNum).innerHTML=contents;
                }else{
                    alert("수정 실패");
                }
            }
        }

        }

     
    }
});



//----------------**DELETE**--------------------
replyResult.addEventListener("click",function(event){
    //let cn = event.target;
    if(event.target.classList.contains("del")){
        // console.log("del click");
        let delNum=event.target.getAttribute("data-num");
        console.log(delNum);

            const xhttp3 = new XMLHttpRequest();
            xhttp3.open("POST","../noticeReply/delete");

               //요청 header정보
            xhttp3.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            xhttp3.send("replynum="+delNum);

            xhttp3.onreadystatechange=function(){

                if(this.readyState==4&&this.status==200){
                    console.log(this.responseText);
                    if(this.responseText.trim()=='1'){
                        alert("삭제했습니다.");
                        getList();
                    }else{
                        alert("삭제 실패");
                    }
                }
            }
        }
    
        
    
});



//----------------**댓글 등록**--------------------
getList();

function getList(){
    const xhttp2=new XMLHttpRequest();
    xhttp2.open("GET","../noticeReply/list?num="+num.value);
    xhttp2.send();
    xhttp2.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            console.log(this.responseText);
            replyResult.innerHTML=this.responseText.trim();
            
        }
    }

}

reply.addEventListener("click",function(){

    console.log(num.value);
    console.log(writer.value);
    console.log(contents.value);
   //JS에서 요청객체(내장객체) 생성(준비)
   const xhttp=new XMLHttpRequest();

   //요청정보 입력
   //open('method형식', 'URL 주소')
   xhttp.open("POST","../noticeReply/add");

   //요청 header정보
    xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

   //요청전송
   //post 요청시 파라미터 
   // xhttp.send("이름="+값+"&이름="+값+"&이름="+값)
   xhttp.send("num="+num.value+"&writer="+writer.value+"&contents="+contents.value);

   //응답 처리 
   xhttp.onreadystatechange=function(){
       //4번 왔다갔다 4 wqy handshake 정상적으로 왔는지 200번 성공 
       //400번 클라이언트쪽 에러, 500번 서버 에러 
       if(this.readyState==4 && this.status==200){
        console.log(this.responseText);
        let result=this.responseText.trim();
        if(result=='1'){
            alert("댓글이 등록되었습니다.");
            getList();
        }else{
            alert("댓글 등록 실패");
        }
       }
   }

})