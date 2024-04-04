//객체생성
const todo = {
    /**
     * 스케줄 추가기능
     */
    add(){
        const subject = frmRegist.subject.value; //input란 text //그냥 subject하면 안댐

        //예외처리 input란이 공백일때 (try catch나중에)
        //좌우공백제거 trim 메서드
        if(!subject.trim()){
            alert("할일을 입력하세요.");
            return; //함수종료
        }

        const liEl = document.createElement("li"); //요소추가
        liEl.appendChild(document.createTextNode(subject)); //뒤에 추가

        const buttonEl = document.createElement("button"); //버튼요소 추가
        buttonEl.appendChild(document.createTextNode("삭제"));//삭제버튼 추가 
        liEl.appendChild(buttonEl); //li태그 뒤에 추가

        const itemsEl = document.querySelector(".items");//css 클래스 명으로 찾기 //ul태그 내
        itemsEl.appendChild(liEl); 


        /**
         * 스케줄 삭제기능
         */
        buttonEl.addEventListener("click",function(){ //삭제버튼 누르면 해당 목록 삭제
            itemsEl.removeChild(liEl);

        });


        //값 입력하고 등록하면 input창 내용 초기화
        frmRegist.subject.value="";
        //입력창 커서 깜빡이도록
        frmRegist.subject.focus();
    },
    
};


window.addEventListener("DOMContentLoaded",function(){
    frmRegist.addEventListener("submit",function(e){
        e.preventDefault();
        todo.add();//스케줄 추가
    });
});//function안쓰려면 before??what?