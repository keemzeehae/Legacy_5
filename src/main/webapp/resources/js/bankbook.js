console.log('bankbook');

const bookName =document.getElementById('bookName');
const bookContents = document.getElementById('bookContents');
const btn=document.getElementById('btn');
const frm=document.getElementById('frm');

let nameCheck=false;
let contentsCheck=false;

btn.addEventListener("click",function(){
    if(nameCheck&&contentsCheck){   
        frm.submit();
    }else{
        alert('정보를 바르게 입력하세요');
    }
    
})

bookName.addEventListener("blur",function(){
    if(bookName.value==''){
        nameCheck=false;
    }else{
        nameCheck=true;
    };
});

bookContents.addEventListener("blur",function(){
    if(bookContents.value==''){
        contentsCheck=false;
    }else{
        contentsCheck=true;
    };
});