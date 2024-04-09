//객체생성
const todo = {
  id: 1,
  data: [], //스케줄 데이터
  init() {
    // 저장값 조회 -> 스케줄 완성
    const jsonData = localStorage.getItem("todos");
    const todos = jsonData ? JSON.parse(jsonData) : []; //값 비어있을때 빈값
    this.data = todos;
    //console.log(todos);
    this.id = todos.length + 1;

    const itemsEl = document.querySelector(".items");

    for (const item of todos) {
      //Symbol.iterator / 반복자패턴/ 반복이 필요한 객체
      const liEl = this.getItem(item.title);
      liEl.dataset.id = item.id;
      itemsEl.appendChild(liEl);
    }
  },

  /**
   * 스케줄 추가기능
   */
  add() {
    const subject = frmRegist.subject.value; //input란 text //그냥 subject하면 안댐

    //예외처리 input란이 공백일때 (try catch나중에)
    //좌우공백제거 trim 메서드
    if (!subject.trim()) {
      alert("할일을 입력하세요.");
      return; //함수종료
    }

    const itemsEl = document.querySelector(".items"); //css 클래스 명으로 찾기 //ul태그 내
    const liEl = this.getItem(subject);
    itemsEl.appendChild(liEl);

    //값 입력하고 등록하면 input창 내용 초기화
    frmRegist.subject.value = "";
    //입력창 커서 깜빡이도록
    frmRegist.subject.focus();

    const { data } = this;
    let id = this.id++;
    data.push({
      id,
      title: subject,
    });

    this.save();

    liEl.dataset.id = id;
  },
  save() {
    localStorage.setItem("todos", JSON.stringify(this.data));
  },
  getItem(subject) {
    const liEl = document.createElement("li"); //요소추가
    liEl.appendChild(document.createTextNode(subject)); //뒤에 추가

    const buttonEl = document.createElement("button"); //버튼요소 추가
    buttonEl.appendChild(document.createTextNode("삭제")); //삭제버튼 추가
    liEl.appendChild(buttonEl); //li태그 뒤에 추가

    /**
     * 스케줄 삭제기능
     */
    buttonEl.addEventListener("click", function () {
      const itemsEl = document.querySelector(".items");

      //삭제버튼 누르면 해당 목록 삭제
      itemsEl.removeChild(liEl);

      const id = liEl.dataset.id;
      //localStorage에 저장된 데이터도 삭제 (실데이터 삭제)
      const index = todo.data.findIndex((item) => item.id == id);
      if(index !== -1){
        todo.data.splice(index,1);
        todo.save();
      }
    });

    return liEl;
  },
};

window.addEventListener("DOMContentLoaded", function () {
  todo.init(); //데이터 조회 및 완성

  frmRegist.addEventListener("submit", function (e) {
    e.preventDefault();
    todo.add(); //스케줄 추가
  });
}); //function안쓰려면 before??what?
