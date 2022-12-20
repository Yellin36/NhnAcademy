let curYear, curMonth, curDate, DAY = new Number();
let taskCount = 0;

function setCalendarDate() {
    const now = new Date();
    curYear = now.getFullYear();
    curMonth = now.getMonth() + 1;

    document.getElementById("date").innerText = (curMonth+"월, " + curYear + "년");
}

function setCalendarNumber() {    
    const date = new Date(curYear, curMonth, 0).getDate();
    DAY = new Date(curYear, curMonth - 1, 1).getDay();

    for(i = 1; i<=42; i++) {
        const num = (i <= DAY || i > DAY + date) ? "" : i - DAY;
        document.getElementById("day" + i).innerHTML = num;
    }
    getMonthlyTask();
}

function setCurDate(date) {
    //현재 날짜 클릭 효과
    const previousBox = document.getElementById("day" + (curDate + DAY));
    const curBox = document.getElementById("day" + date);
    const curTitle = document.getElementById("title");
    const curContent = document.getElementById("content");

    previousBox.setAttribute("style", "background-color: white");
    curContent.textContent = "";

    if(date == "") { 
        curTitle.innerHTML = "";
        curDate = taskCount = 0;
        taskCount = 0;
        return;
    }
    
    curBox.setAttribute("style", "background-color: #faedcd");

    //현재 날짜 저장
    curDate = date - DAY;

    //현재 날짜에 맞춰 데이터 세팅
    curTitle.innerHTML = curMonth + "월 " + curDate + "일";
    
    //데이터 불러오기
    loadTasks();
}
function setCalendar() {
    const box = document.getElementById("day" + (curDate + DAY));
    box.appendChild(getRound());
}