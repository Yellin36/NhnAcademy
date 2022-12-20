function drawCalendar() {
    let c = getContainer();
    let days = ["일", "월", "화", "수", "목", "금", "토"];

    //월-금 라인 그리기
    for(i = 0; i<7; i++) {
        const title = document.createElement("div");
        if(i%7 ==6) title.classList.add("sat");
        if(i%7 == 0) title.classList.add("sun");
        title.classList.add("day");
        title.innerHTML = days[i];
        c.appendChild(title);
    }
    document.getElementById("calendar").appendChild(c);
    c = getContainer();
    
    //격자 그리기
    for(i = 1; i<=42; i++) {
        c.appendChild(getBox(i));
        if(i % 7 == 0)  {
            document.getElementById("calendar").appendChild(c);
            c = getContainer();
        }
    }
    var today = new Date();
    curDate = today.getDate();
    //날짜 입력하기
    setCalendarNumber();
    
    //현재 날짜 선택하기
    clickDate(getCurDate());
}

function move(value) {
    let curMonth = getCurMonth();
    let curYear = getCurYear();

    curMonth += value;

    if(curMonth > 12) {
        curMonth = 1;
        curYear += 1;
    }
    else if(curMonth < 1) {
        curMonth = 12;
        curYear -= 1;
    }
    document.getElementById("date").innerText = (curMonth+"월, " + curYear + "년");
    
    setCurMonth(curMonth);
    setCurYear(curYear);
    
    clickDate("");
    setCalendarNumber();
}

function clickDate(date) {
    //현재 날짜 클릭 효과
    const previousBox = document.getElementById("day" + (getCurDate() + DAY));
    const curBox = document.getElementById("day" + (date + DAY));
    const curTitle = document.getElementById("title");
    const curContent = document.getElementById("content");

    previousBox.setAttribute("style", "background-color: white");
    curContent.textContent = "";

    if(date == "") { 
        curTitle.innerHTML = "";
        taskCount = 0;
        return;
    }
    
    curBox.setAttribute("style", "background-color: #faedcd");

    //현재 날짜 저장
    setCurDate(date)

    //현재 날짜에 맞춰 데이터 세팅
    curTitle.innerHTML = getCurMonth() + "월 " + getCurDate() + "일";
    
    // //데이터 불러오기
    loadTasks();
}